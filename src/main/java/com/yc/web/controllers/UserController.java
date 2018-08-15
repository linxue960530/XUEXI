package com.yc.web.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.JsonModel;
import com.yc.bean.User;
import com.yc.biz.UserBiz;
//           路径值        如果设这个值value值会被覆盖
@Api(value="/user", tags="用户模块") //该注解放在一个类上面，用来表明类中包含作为HTTP接口的方法，该注解的value用来设置接口的前缀
@Controller
public class UserController {
	@Resource(name="userBizImpl")
	private UserBiz userBiz;
	
	@RequestMapping("toReg.action")
	@ResponseBody
     public JsonModel register(User user){
		JsonModel jm=new JsonModel();
		//System.out.println(user);
		boolean u = userBiz.register(user);
		jm.setCode(1);
		jm.setObj(u);
		return jm;
    	 
     }
	//             value用于方法描述           notes用于提示内容 
	@ApiOperation(value="用户登录", notes = "用户登录")
	//				name–参数名 	  value–参数说明 	required–是否必填         dataType–重写属性类型 
	@ApiImplicitParam(name="user", value="User", required = true, dataType = "User")
	//@RequestMapping("toReg.action",method = RequestMethod.GET)
	@PostMapping("toLogin.action")
	@ResponseBody
     public JsonModel login(User user,HttpSession session){
		
		JsonModel jm=new JsonModel();
		//System.out.println(user);
		if(!userBiz.vaildate(user)){
			jm.setCode(0);
			jm.setErrmsg("用户名不存在");
			//System.out.println(jm);
			return jm;
		}
			User u = userBiz.login(user);
			if(u!=null){
				jm.setCode(1);
				jm.setObj(u);
				session.setAttribute("user", u);
			}else{
				jm.setCode(0);
				jm.setErrmsg("密码错误，请重新输入");
		    }
		//System.out.println(jm);
		return jm;
    	 
     }
}
