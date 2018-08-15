package com.yc.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.House;
import com.yc.bean.JsonModel;
import com.yc.bean.PageBean;
import com.yc.bean.User;
import com.yc.biz.HouseBiz;
import com.yc.biz.UserBiz;

@Controller
public class HouseController {
	
	@Resource(name="houseBizImpl")
    private HouseBiz houseBiz;
	
	
	@RequestMapping("show.action")
	@ResponseBody
	public PageBean show(Integer pages){
		Map<String, Object> map=new HashMap<String, Object>();
		int pagesize=3;
		int start=(pages-1)*pagesize;
		map.put("pagesize", pagesize);
		map.put("pages", pages);
		map.put("start", start);
		PageBean<House> hb = houseBiz.searchHouseByPage(map);
		//System.out.println(hb);
		hb.setCode(1);
		return hb;
		
	}
	
	@RequestMapping("update.action")
	@ResponseBody
	public JsonModel update(House house){
		JsonModel jsonModel=new JsonModel();
		houseBiz.updateHouse(house);		
		jsonModel.setCode(1);
		return jsonModel;	
	}
	
	@RequestMapping("del.action")
	@ResponseBody
	public JsonModel del(Integer id){
		JsonModel jsonModel=new JsonModel();
		houseBiz.delHouse(id);		
		jsonModel.setCode(1);
		return jsonModel;	
	}
	
	@RequestMapping("addHouse.action")
	@ResponseBody
	public JsonModel addHouse(House house,HttpSession session){
		JsonModel jsonModel=new JsonModel();
		User u = (User) session.getAttribute("user");
		house.setUser(u);
		//System.out.println(house);
		houseBiz.addHouse(house);	
	
		jsonModel.setCode(1);
		return jsonModel;	
	}
	
    
}
