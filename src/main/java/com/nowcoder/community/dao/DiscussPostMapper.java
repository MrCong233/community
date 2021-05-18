package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    //根据userId筛选DiscussPost;
    // 当userId!=0时，根据userId查询，当userId==0时，查找所有的DiscussPost，实现动态sql查询;
    //offset和limit用于分页，offset表示起始行的行号，limit表示每页的行数
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    // 查询表里一共有多少条数据
    // 当userId!=0时，根据userId查询，当userId==0时，查找所有的DiscussPost，实现动态sql查询;
    // @Param()用于给参数起别名，简化写法，
    // ** 当sql里需要用到动态条件，且动态条件必须用到该参数，且该方法只有一个参数时，必须使用该注解
    int selectDiscussPostRows(@Param("userId") int userId);


}
