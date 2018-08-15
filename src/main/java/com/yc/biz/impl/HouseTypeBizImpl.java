package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.HouseType;
import com.yc.biz.HouseTypeBiz;
import com.yc.dao.BaseDao;

@Service
public class HouseTypeBizImpl implements HouseTypeBiz {
	@Resource(name="baseDaoImpl")
	private BaseDao baseDao;
	@Override
	public List<HouseType> getTypeList() {
		List<HouseType> houseType=null;
		houseType=baseDao.findAll(HouseType.class, "getAllHouseType");
		return houseType;
	}

}
