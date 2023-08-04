package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import com.nowcoder.community.dao.UserMapper;

import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = SpringProjectApplication.class)
public class MapperTest {
    @Autowired
    UserMapper userMapper;
    @Autowired
    DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);
        user = userMapper.selectByName("liubei");
        System.out.println(user);
        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("12345");
        user.setEmail("12345@gmail");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        int row = userMapper.insertUser(user);
        System.out.println(row);
        System.out.println(user.getId());
    }
    @Test
    public void updateUser(){
        int rows = userMapper.updateStatus(150,1);
        System.out.println(rows);
        rows = userMapper.updateHeader(150,"http://www.nowcoder.com/150.png");
        System.out.println(rows);
        rows = userMapper.updatePassword(150,"hello");
        System.out.println(rows);
    }
    @Test
    public void selectPost(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149,0,10);
        for(DiscussPost discussPost:list){
            System.out.println(discussPost);
        }
        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println("rows:"+rows);
    }

}
