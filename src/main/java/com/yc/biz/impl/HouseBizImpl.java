package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.House;
import com.yc.bean.JsonModel;
import com.yc.bean.PageBean;
import com.yc.biz.HouseBiz;
import com.yc.dao.BaseDao;


@Service
public class HouseBizImpl implements HouseBiz {
	@Resource(name="baseDaoImpl")
	private BaseDao baseDao;

	@Override
	public House getHouseBean(House hb) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("id", hb.getId()+"");
		List<House> list=this.baseDao.findAll(hb, "findHouseConditionCount");
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}

	}

	@Override
	public boolean addHouse(House house) {
			baseDao.save(house, "saveHouse");
			return true;
	}

	@Override
	public boolean updateHouse(House house) {
			baseDao.update(house, "updateHouse");
			return true;
	}

	@Override
	public boolean delHouse(int id) {
			baseDao.del(House.class, id+"","delSingleHouse");
			return true;
	}

	@Override
	public boolean delHouses(List<Integer> ids) {
		baseDao.del(House.class, ids,"delMutilHouse");
		return true;
	}

	@Override
	public JsonModel<House> searchHouse(Map<String, Object> map) {
		List<House> list=baseDao.findAll(House.class, "findHouseCondition",map );
		//System.out.println(list);
		int total=baseDao.getCount( House.class, map, "findHouseConditionCount");
	    JsonModel<House> jsonModel=new JsonModel<House>();
	    return jsonModel;
	}

	
	@Override
	public PageBean<House> searchHouseByPage(Map<String, Object> map) {
		PageBean pageBean=new PageBean();
		List<House> list=baseDao.findAll(House.class, "findHouseCondition",map );
		//System.out.println(list);
		int total=baseDao.getCount( House.class, map, "findHouseConditionCount");
	    pageBean.setList(list);
	    pageBean.setTotal((long)total);
	    
	    if(map.get("pages")!=null){
			int pages=Integer.parseInt( map.get("pages").toString());
			pageBean.setPages(pages);
		}
		if(map.get("pagesize")!=null){
			int pagesize=Integer.parseInt( map.get("pagesize").toString());
			pageBean.setPagesize(pagesize);
			int totalPage=total/pagesize==0?total/pagesize:total/pagesize+1;
			pageBean.setTotalPage((long)totalPage);
		}
		
		
	    return pageBean;
	}
	
	
}
