package com.nowcoder.community.dao;

import com.nowcoder.community.entity.User;
import org.springframework.stereotype.Repository;

//添加MyBatis注解让Spring容器能装配这个bean（Repository可以用）
@Repository
public interface UserMapper {
    //声明增删改查方法,具体方法与项目实际使用方法有关
    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    /**
     *
     * @param user 插入一个User
     * @return 插入的行数
     */
    int insertUser(User user);

    int updateStatus(int id ,int status);

    int updateHeader(int id,String headerUrl);

    int updatePassword(int id,String password);
}
