package com.cl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cl.common.base.ResultInfo;
import com.cl.common.util.Constants;
import com.cl.entity.system.User;
import com.cl.service.system.impl.ISystemService;

@RestController
@RequestMapping("/system")
public class SystemController {
	
	@Autowired
	ISystemService service;
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public ResultInfo login(HttpServletRequest request) {
		ResultInfo resultInfo = new ResultInfo();
		try {
			String username = (String) request.getAttribute("username");
			String password = (String) request.getAttribute("password");
			User user = service.findUser(username, password);
			if(user==null) {
				resultInfo.setCode(Constants.FAILURE);
				resultInfo.setDesc("账号或密码错误！！！");
				resultInfo.setObj(null);
			}
			request.getSession().setAttribute("user", User.SESSION_KEY);;
			resultInfo.setCode(Constants.SUCCESS);
			resultInfo.setDesc("登录成功！！！");
			resultInfo.setObj(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultInfo;
	}
	
}
