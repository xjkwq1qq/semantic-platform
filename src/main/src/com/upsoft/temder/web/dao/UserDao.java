package com.upsoft.temder.web.dao;

import com.upsoft.temder.web.bean.PageBean;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/8/5.
 */
public interface UserDao {
    List<Map<String,Object>> selectUsers(Map<String, String> params, PageBean page);

    Long selectUserCount(Map<String, String> params);
}
