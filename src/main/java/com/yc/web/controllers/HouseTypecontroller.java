package com.yc.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.HouseType;
import com.yc.bean.JsonModel;

@Controller
public class HouseTypecontroller {
	
	@RequestMapping("houseType.action")
	@ResponseBody
     public JsonModel houseType(HttpServletRequest request){
		JsonModel jsonModel=new JsonModel();
		ServletContext application=request.getServletContext();
		List<HouseType> houseTypelist=new ArrayList<HouseType>();
		if(application.getAttribute("houseTypelist")!=null){
			houseTypelist= (List<HouseType>) application.getAttribute("houseTypelist");
		  }
		jsonModel.setCode(1);
		jsonModel.setObj(houseTypelist);
		return jsonModel;
    	 
     }
	
}
