package com.upsoft.semantic.mapper.user;

import com.upsoft.semantic.domain.User;

import java.util.List;

/**
 * Created by admin on 2016/8/2.
 */
public interface UserMapper {
    void insert(List<User> users);

    List<User> selectUsers();
}
