package com.cl.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cl.common.base.ResultInfo;
import com.cl.common.util.Constants;
import com.cl.entity.system.User;
import com.cl.mapper.system.UserMapper;
import com.cl.service.system.impl.ISystemService;

@Service
public class SystemService implements ISystemService{
	
	@Autowired
	UserMapper mapper;
	
	public User findUser(String username, String password) throws Exception {
		User user = new User();
		List<User> users = mapper.queryByPrimaryKey(username, password);
		if(users!=null&&users.size()>0) {
			user = users.get(0);
		}
		return user;
	}

}
