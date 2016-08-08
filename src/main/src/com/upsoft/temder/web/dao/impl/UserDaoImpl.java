package com.upsoft.temder.web.dao.impl;

import com.github.pagehelper.PageHelper;
import com.upsoft.temder.web.bean.PageBean;
import com.upsoft.temder.web.dao.UserDao;
import com.upsoft.temder.web.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/8/5.
 */
@Component
public class UserDaoImpl implements UserDao {
    @Resource(name="userMapper")
    private UserMapper userMapper;
    @Override
    public List<Map<String, Object>> selectUsers(Map<String, String> params, PageBean page) {
        PageHelper.startPage(page.getPageIndex(), page.getPageSize());
        return  userMapper.selectUsers();
    }

    @Override
    public Long selectUserCount(Map<String, String> params) {
        return userMapper.selectUserCount();
    }
}
