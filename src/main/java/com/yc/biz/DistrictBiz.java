package com.yc.biz;

import java.util.List;

import com.yc.bean.District;
import com.yc.bean.Street;

public interface DistrictBiz {
	/**
	 * 查询所有的区
	 */
	public List<District> getDistrictList();
	/**
	 *根据区id查询所有街道
	 * @return
	 */
	public List<Street> getStreetByDistrictId(Integer did);

	
}
