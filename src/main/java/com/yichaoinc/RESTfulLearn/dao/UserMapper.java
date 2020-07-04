package com.yichaoinc.RESTfulLearn.dao;

import com.yichaoinc.RESTfulLearn.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

//    /**
//     * 根据id和password查询员工
//     * @param user 包含指定id、password的用户
//     * @return 符合指定id和password的用户集合
//     */
//    @Select(" select * from user_inf\n" +
//            "        where user_id = {#id}\n" +
//            "        user_password = {#password}")
//    User findUserByIdAndPassword(User user);

    String findUserPassword(int id);

}
