package com.training.pos.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.training.pos.bean.PosException;
import com.training.pos.bean.StoreBean;
import com.training.pos.service.StoreService;


@Controller
public class StoreController {
	@Autowired
	StoreService ads;
	@RequestMapping("/showstores")
	public ModelAndView showStores() {
		try {
			List<StoreBean> stores=ads.getAllStores();
			ModelAndView mv = new ModelAndView("displayStore","StoreBean",stores);
			System.out.println("show executing");
			return mv;
			
		}
		catch (PosException e) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error",e);
			
			return mv;
		}
	}
	@RequestMapping("/showstoresuser")
	public ModelAndView showStoresuser(@CookieValue("foo")String userId,HttpServletResponse response) {
		List<StoreBean> stores;
		try {
			System.out.println(userId);
			stores = ads.getAllStoresuser(userId);
			ModelAndView mv = new ModelAndView("displayStoreuser","StoreBean",stores);
			Cookie foo = new Cookie("store", stores.get(0).getStoreId()); 
			foo.setMaxAge(2000); 	
			response.addCookie(foo);
			System.out.println("show executing");
			return mv;
		} catch (Exception e) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error","couldn't find the store near to you");
			return mv;
		}
		
		
		
	}
	@RequestMapping(value="/addStore")
	public String addStore() {
		System.out.println("add executing");
		return "addStore";
	}
	@RequestMapping(value="/editStorepage")
	public String editStore() {
		System.out.println("add executing");
		return "update";
	}
	
	@RequestMapping(value="/saveStores",method=RequestMethod.POST)
	public ModelAndView saveStores(@ModelAttribute("StoreBean") StoreBean stores) {
		try {
			//StoreBean stores;
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			Query q = session.createSQLQuery("select store_seq.nextval from dual");
			BigDecimal key = (BigDecimal) q.uniqueResult();
			String s = stores.getName().substring(0, 2)+String.valueOf(key);
			stores.setStoreId(s);
			List<StoreBean> store = ads.addStore(stores);
			ModelAndView mv = new ModelAndView("displayStore","StoreBean",store);
			System.out.println("save executing");
			return mv;
		} catch (PosException e) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error",e);
			return mv;
		}
	}
	
	@RequestMapping(value="/deleteStore/{storeId}",method=RequestMethod.GET)
		public ModelAndView deleteStore(@PathVariable String  storeId){
			System.out.println(storeId);
				int profile1 = ads.delete(storeId);
				return new ModelAndView("redirect:/showstores");
			 
		}
		
	@RequestMapping(value="/editStore",method=RequestMethod.GET)
	public ModelAndView editProfile(@RequestParam String  storeId){
		    System.out.println("storeId"  + storeId);
			StoreBean storebean = ads.getStoreById(storeId);
			System.out.println(storebean.getStoreId());
			ModelAndView mv = new ModelAndView("update","StoreBean",storebean);
			System.out.println("HELLO1");
			return mv;
	}
		
	@RequestMapping(value="/update",method=RequestMethod.POST)
		public ModelAndView updateStore(@ModelAttribute("ProfileBean") StoreBean store) {
			System.out.println("HELLO");
				int profile1 = ads.update(store);
			//	ModelAndView mv = new ModelAndView("displayProfile","StoreBean",profile1);
				System.out.println("save executing");
				return new ModelAndView("redirect:/");
			
		}
}
