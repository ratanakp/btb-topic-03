package com.example.demotopic03.repositories;

import com.example.demotopic03.models.Role;
import com.example.demotopic03.models.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    @Select("select id, username, password, status, " +
            "profile_img from tb_user where username=#{username}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "profileImg", column = "profile_img"),
            @Result(property = "roles", column = "id", many = @Many(select = "getRolesByUserId"))

    })
    User loadUserByUsername(String username);


    @Select("select id, role " +
            "from tb_role tr inner join tb_user_role tur on tr.id = tur.role_id where tur.user_id=#{id}")
    List<Role> getRolesByUserId(Integer id);







}
