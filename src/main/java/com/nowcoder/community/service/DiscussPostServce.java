package com.nowcoder.community.service;

import com.nowcoder.community.entity.DiscussPost;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DiscussPostServce {
    public List<DiscussPost> findDiscussPost(int userId,int offset,int limit);

    public int selectDiscussPostRows(int userId);
}
