package com.nowcoder.community.service;

import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.util.CommunityConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface UserService extends CommunityConstant {
    public User findUserById(int id);

    public Map<String,Object> register(User user);

    public int activation(int userId, String code);
}
