package com.yc.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.District;
import com.yc.bean.JsonModel;
@Controller
public class DistrictController {
	@RequestMapping("district.action")
	@ResponseBody
     public JsonModel houseType(HttpServletRequest request){
		JsonModel jsonModel=new JsonModel();
		ServletContext application=request.getServletContext();
		List<District> districtlist=new ArrayList<District>();
		if(application.getAttribute("districtlist")!=null){
			districtlist= (List<District>) application.getAttribute("districtlist");
		  }
		jsonModel.setCode(1);
		jsonModel.setObj(districtlist);
		return jsonModel;
    	 
     }
}
