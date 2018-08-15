package com.yc.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.District;
import com.yc.bean.JsonModel;
import com.yc.bean.Street;
import com.yc.biz.DistrictBiz;


@Controller
public class StreetController {
	@Resource(name="districtBizImpl")
	private DistrictBiz districtBiz;
	@RequestMapping("street.action")
	@ResponseBody 
     public JsonModel street(Integer id){
		//System.out.println(id);
		JsonModel jsonModel=new JsonModel();
		List<Street> db = districtBiz.getStreetByDistrictId(id);
		
		jsonModel.setCode(1);
		jsonModel.setObj(db);
		return jsonModel;
    	 
     }
}
