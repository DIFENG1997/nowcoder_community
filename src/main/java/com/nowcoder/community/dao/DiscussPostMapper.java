package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DiscussPostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DiscussPost record);

    int insertSelective(DiscussPost record);

    List<DiscussPost> selectDiscussPosts(Integer userId,int offset,int limit);

    //如果只有一个参数，并且在if里使用，一定要用@param
    int selectDiscussPostRows(@Param("userId") Integer userId);
    DiscussPost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DiscussPost record);

    int updateByPrimaryKeyWithBLOBs(DiscussPost record);

    int updateByPrimaryKey(DiscussPost record);
}