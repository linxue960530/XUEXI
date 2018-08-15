package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.House;
import com.yc.bean.JsonModel;
import com.yc.bean.PageBean;

public interface HouseBiz {
	/**
	 * 根据id查某个房子的信息
	 * @param hb
	 * @return
	 */
	public House getHouseBean(House hb);
	public boolean addHouse(House house);
	public boolean updateHouse(House house);
	public boolean delHouse(int id);
	public boolean delHouses(List<Integer> ids);
	/**
	 * 分页查询
	 */
	public JsonModel<House> searchHouse(Map<String,Object> map);
	PageBean<House> searchHouseByPage(Map<String, Object> map);
	
}
