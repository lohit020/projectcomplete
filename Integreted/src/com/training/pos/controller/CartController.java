package com.training.pos.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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
import org.springframework.web.util.WebUtils;

import com.training.pos.bean.CartBean;
import com.training.pos.bean.FoodBean;
import com.training.pos.bean.PosException;
import com.training.pos.service.CartService;

@Controller
@Transactional
public class CartController {
	@Autowired
	CartService cs;
	@RequestMapping("/cart")
	public ModelAndView showCart(@CookieValue("foo") String UserId) {
		try {
			List<CartBean> items=cs.getCart(UserId);
			System.out.println(items.size()+"======");
			ModelAndView mv = new ModelAndView("displayCart","CartBean",items);
			System.out.println("show executing");
			System.out.println(mv);
			return mv;
			
		}
		catch (PosException e) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error",e);
			
			return mv;
		}
	}
		
	@RequestMapping(value="/addCart",method=RequestMethod.POST)
	public String addCart() {
		System.out.println("add executing");
		return "addCart";
	}
	
	@RequestMapping(value="/saveCart",method=RequestMethod.POST)
	public ModelAndView saveCart(@ModelAttribute("CartBean") CartBean items,@CookieValue("foo") String UserId) {
		try {
			System.out.println("again save");
			List<CartBean> item = cs.addCart(items,UserId);
			ModelAndView mv = new ModelAndView("displayCart","CartBean",item);
			System.out.println("save executing");
			return mv;
		} catch (PosException e) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error",e);
			return mv;
		}
	
	
}
	
	@RequestMapping(value="/deleteCart",method=RequestMethod.GET)
	public ModelAndView deleteCart(@RequestParam("itemID") String cartID,@CookieValue("foo") String userId){
		System.out.println(cartID);
		List<CartBean> items = null;
			int profile1 = cs.delete(cartID);
			try {
				items=cs.getCart(userId);
				ModelAndView mv = new ModelAndView("displayCart","CartBean",items);
				return mv;
			} catch (PosException e) {
				// TODO Auto-generated catch block
				ModelAndView mv = new ModelAndView("show","CartBean",items);
				e.printStackTrace();
				return mv;
			}
			
			
		 
	}
	
	@RequestMapping(value="/editCart",method=RequestMethod.GET)
	public ModelAndView editCart(@RequestParam String cartID){
		System.out.println(cartID);
		CartBean cart= cs.getCartById(cartID);
			ModelAndView mv = new ModelAndView("updateCart","CartBean",cart);
			System.out.println("HELLO1");
			return mv;
	}
	
	/*@RequestMapping(value="/updateCart",method=RequestMethod.POST)
	public ModelAndView updateCart(@ModelAttribute ("CartBean") CartBean edit,@CookieValue("foo") String userId) {
		System.out.println("HELLO");
		edit.setUserId(userId);
		int profile1 =cs.updateCart(edit);
		System.out.println("save executing");
		return new ModelAndView("redirect:/");
		
	}*/
	@RequestMapping(value="/updateCart",method=RequestMethod.POST)
	public ModelAndView updateCart(@RequestParam("foodId") String foodId,@ModelAttribute("FoodBean") FoodBean food,@CookieValue("foo") String userId) throws PosException {
		System.out.println("HELLO");
		
		CartBean edit = new CartBean();
		System.out.println(userId+foodId);
		System.out.println(food.getFoodId());
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query q = session.createSQLQuery("select cart_seq.nextval from dual");
		BigDecimal key = (BigDecimal) q.uniqueResult();
		edit.setCartID(String.valueOf(key));
		edit.setUserId(userId);
		edit.setFoodId(food.getFoodId());
		edit.setType(food.getType());
		edit.setQuantity(food.getQuantity());
		edit.setCost(food.getPrice());
		System.out.println(edit);
		List<CartBean> profile1 =cs.addCart(edit,userId);
		/*System.out.println("save executing");
		List<CartBean> items=cs.getCart();*/
		ModelAndView mv = new ModelAndView("displayCart","CartBean",profile1);
		return  mv;
		
	}
	
	

}
