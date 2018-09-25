package com.training.pos.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.training.pos.bean.FoodBean;
import com.training.pos.bean.PosException;
import com.training.pos.service.FoodService;

@Controller
public class FoodController {
	@Autowired
	FoodService fds;
	@RequestMapping("/displayfood")
	public ModelAndView showFoods() {
		try {
			List<FoodBean> foods=fds.getAllFoods();
			ModelAndView mv = new ModelAndView("displayFood","FoodBean",foods);
			System.out.println("show executing");
			return mv;
			
		}
		catch (PosException e) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error",e);
			return mv;
		}
	}
	@RequestMapping("/displayfoodadmin")
	public ModelAndView showFoodsadmin() {
			List<FoodBean> foods;
			try {
				foods = fds.getAllFoods();
				ModelAndView mv = new ModelAndView("displayFoodadmin","FoodBean",foods);
				System.out.println("show executing");
				return mv;
			} catch (PosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			
		
		}
	@RequestMapping(value="/addFood")
	public String addFood() {
		System.out.println("add executing");
		return "addFood";
	}
//	@RequestMapping(value="/updatefood")
//	public String updateFood(@PathParam("foodId")String foodid) {
//		System.out.println("add executing");
//		return "updateFood";
//	}
	
	@RequestMapping(value="/updatefood")
	public ModelAndView updatefood(@RequestParam("foodId") String edit) {
		System.out.println("HELLO");
		ModelAndView mv = new ModelAndView("updateFood","foodId",edit);
		System.out.println("save executing");
		return mv;
		
	}
	@RequestMapping(value="/saveFood",method=RequestMethod.POST)
	public ModelAndView saveFood(@ModelAttribute("FoodBean") FoodBean food) {
		try {
			List<FoodBean> foods = fds.addFood(food);
			ModelAndView mv = new ModelAndView("displayFoodadmin","FoodBean",foods);
			System.out.println("save executing");
			return mv;
		} catch (PosException e) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error",e);
			return mv;
		}
}
	@RequestMapping(value="/deleteFood/{foodId}",method=RequestMethod.GET)
	public ModelAndView deleteFood(@PathVariable String  foodId){
		System.out.println(foodId);
			int profile1 = fds.delete(foodId);
			return new ModelAndView("redirect:/displayfoodadmin");
		 
	}
	
	@RequestMapping(value="/editFood",method=RequestMethod.GET)
	public ModelAndView editFood(@RequestParam String foodId){
		System.out.println(foodId);
		FoodBean food= fds.getFoodById(foodId);
			ModelAndView mv = new ModelAndView("updateFood","FoodBean",food);
			System.out.println("HELLO1");
			return mv;
	}
	
	@RequestMapping(value="/updateFood",method=RequestMethod.POST)
	public ModelAndView updateFood(@ModelAttribute ("FoodBean") FoodBean edit) {
		System.out.println("HELLO");
		int profile1 =fds.updateFood(edit);
		System.out.println("save executing");
		return new ModelAndView("redirect:/displayfoodadmin");
		
	}
}
