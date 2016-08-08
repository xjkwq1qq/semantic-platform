package com.upsoft.temder.web.mapper.user;

import com.upsoft.temder.web.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/8/2.
 */
public interface UserMapper {
    void insert(List<User> users);

    List<Map<String,Object>> selectUsers();

    Long selectUserCount();
}
