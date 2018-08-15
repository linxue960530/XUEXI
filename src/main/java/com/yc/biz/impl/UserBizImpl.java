package com.yc.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.User;
import com.yc.biz.UserBiz;
import com.yc.dao.BaseDao;
@Service
public class UserBizImpl implements UserBiz {
	@Resource(name="baseDaoImpl")
	private BaseDao<User> baseDao;
	@Override
	public boolean register(User user) {
		baseDao.save(user, "saveUser");
		return true;
	}

	@Override
	public boolean vaildate(User user) {
		user=baseDao.findOne(user, "isUserExists");
		System.out.println(user);
		if(user!=null){
		return true;
		}else{
			return false;
		}

	}

	@Override
	public User getUsersById(Integer id) {
		User u=new User();
		u.setId(id);
		
		return baseDao.findOne(u, "getUserByLogin");
	}

	@Override
	public User login(User user) {
		User u=baseDao.findOne(user, "getUserByLogin");
		return u;
	}

}
