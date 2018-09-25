package com.training.pos.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.Order;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.pos.bean.CartBean;
import com.training.pos.bean.OrderBean;
import com.training.pos.bean.PosException;
import com.training.pos.bean.ProfileBean;
import com.training.pos.service.OrderService;

@Controller
public class OrderController {
		@Autowired
		OrderService ord;
		@RequestMapping("/order")
		public ModelAndView showOrder(@CookieValue("foo")String userID) {
			try {
				List<OrderBean> cred=ord.getOrder(userID);
				ModelAndView mv = new ModelAndView("displayOrder","OrderBean",cred);
				System.out.println("show executing");
				return mv;
			}
			catch (PosException e) {
				ModelAndView mv = new ModelAndView("error");
				mv.addObject("error",e);
				return mv;
			}
		}
		@RequestMapping("/orderadmin")
		public ModelAndView showOrderadmin() {
			try {
				List<OrderBean> cred=ord.getOrder();
				ModelAndView mv = new ModelAndView("displayOrderadmin","OrderBean",cred);
				System.out.println("show executing");
				return mv;
			}
			catch (PosException e) {
				ModelAndView mv = new ModelAndView("error");
				mv.addObject("error",e);
				return mv;
			}
		}
		
		@RequestMapping(value="/addOrder",method=RequestMethod.POST)
		public String addOrder() {
			System.out.println("add executing");
			return "addOrder";
		}
		
		@RequestMapping(value="/saveOrder",method=RequestMethod.POST)
		public ModelAndView saveOrder(@ModelAttribute("CartBean") CartBean cart,@CookieValue("foo") String user,@CookieValue("store") String  storeid) {
			try {
				
				System.out.println(cart.getCartID()+cart.getUserId());
				OrderBean order = new OrderBean();
				String userid = cart.getCartID().split(",")[0];
				order.setCartId(userid);
				order.setUserId(cart.getUserId().split(",")[0]);
				order.setOrderDate(cart.getOrderDate());
				order.setStoreId(storeid);
				double cost = cart.getCost();
				System.out.println(cart.getCost());
				order.setTotalPrice(cost);
				SessionFactory sf = new Configuration().configure().buildSessionFactory();
				Session session = sf.openSession();
				Query q = session.createSQLQuery("select order_seq.nextval from dual");
				BigDecimal key = (BigDecimal) q.uniqueResult();
				order.setOrderId(String.valueOf(key));
				Query query = session.createQuery(" from ProfileBean where userId=:userId");
				query.setParameter("userId", user);
				ProfileBean profile = (ProfileBean)query.uniqueResult();
				System.out.println(profile);
				order.setStreet(String.valueOf(profile.getStreet()));
				order.setCity(String.valueOf(profile.getCity()));
				order.setState(String.valueOf(profile.getState()));
				order.setPincode(String.valueOf(profile.getPincode()));
				order.setOrderStatus("Pending");
				order.setMobileNo(String.valueOf(profile.getMobileNo()));
				List<OrderBean> cred1 = ord.addOrder(order,user);
				ModelAndView mv = new ModelAndView("displayOrder","OrderBean",cred1);
				System.out.println("save executing");
				session.close();
				return mv;
			} catch (PosException e) {
				ModelAndView mv = new ModelAndView("error");
				mv.addObject("error",e);
				return mv;
			}
		
	}
		@RequestMapping(value="/deleteOrder/{orderId}",method=RequestMethod.GET)
		public ModelAndView deleteOrder(@PathVariable String  orderId){
			System.out.println(orderId);
				int profile1 = ord.delete(orderId);
				return new ModelAndView("redirect:/orderadmin");
			 
		}
		@RequestMapping(value="/editOrder",method=RequestMethod.GET)
		public ModelAndView editOrder(@RequestParam("orderid") String  orderid){
			System.out.println("Order Id = "+orderid);
				OrderBean order = ord.getOrderById(orderid);
				System.out.println(order.getCartId());
				ModelAndView mv = new ModelAndView("updateorder","OrderBean",order);
				System.out.println(order.getCartId());
				return mv;
		}
		
		@RequestMapping(value="/updateorder",method=RequestMethod.POST)
		public ModelAndView updateOrder(@ModelAttribute("OrderBean") OrderBean order) {
			System.out.println("HELLO");
				int order1 = ord.update(order);
			//	ModelAndView mv = new ModelAndView("displayProfile","ProfileBean",profile1);
				System.out.println("save executing");
				return new ModelAndView("redirect:/orderadmin");
			
		}
}
