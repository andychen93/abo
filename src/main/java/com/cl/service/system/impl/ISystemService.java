package com.cl.service.system.impl;

import com.cl.entity.system.User;

public interface ISystemService {
	User findUser(String username,String password) throws Exception;
}
