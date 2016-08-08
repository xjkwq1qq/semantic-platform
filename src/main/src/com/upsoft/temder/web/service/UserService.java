package com.upsoft.temder.web.service;

import com.upsoft.temder.web.bean.PageBean;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/8/5.
 */
public interface UserService {
    List<Map<String,Object>> list(Map<String, String> params, PageBean page);
}
