package com.cl.mapper.system;

import com.cl.entity.system.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    /**
     * query all users
     * @return list
     */
    List<User> query();

    /**
     * query by primary key
     * @param username
     * @return
     */
    List<User> queryByPrimaryKey(@Param("username")String username,@Param("password")String password);
}
