package com.upsoft.temder.web.service.impl;

import com.upsoft.temder.web.bean.PageBean;
import com.upsoft.temder.web.dao.UserDao;
import com.upsoft.temder.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/8/5.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<Map<String, Object>> list(Map<String, String> params, PageBean page) {
        List<Map<String, Object>> ret = userDao.selectUsers(params,page);
        page.setTotal(userDao.selectUserCount(params));
        return ret;
    }
}
