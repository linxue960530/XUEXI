package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.District;
import com.yc.bean.Street;
import com.yc.biz.DistrictBiz;
import com.yc.dao.BaseDao;

@Service
public class DistrictBizImpl implements DistrictBiz {
	
	@Resource(name="baseDaoImpl")
	private  BaseDao baseDao;
	
	@Override
	public List<District> getDistrictList() {
		List<District> districts=null;
		districts=baseDao.findAll(District.class, "findAllDistrict");
		return districts;
	}

	@Override
	public List<Street> getStreetByDistrictId(Integer did) {
		List<Street> street=null;
		Map<String,String> map=new HashMap<String,String>();
		map.put("id",did+"" );
		street=baseDao.findAll(Street.class, "getStreetByDistrict",map);
		return street;
	}

	

}
