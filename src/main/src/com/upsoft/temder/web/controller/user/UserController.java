package com.upsoft.temder.web.controller.user;

import com.upsoft.temder.web.bean.DataTableReturn;
import com.upsoft.temder.web.bean.PageBean;
import com.upsoft.temder.web.service.UserService;
import com.upsoft.temder.web.util.PageUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by admin on 2016/8/5.
 */
@Controller
@RequestMapping(UserController.PRE_PACK)
public class UserController {
    public static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    public static final String PRE_PACK = "/user";
    @Autowired
    private UserService userService;
    @RequestMapping("tolist")
    public String tolist(){
        return PRE_PACK.concat("/list");
    }

    @ResponseBody
    @RequestMapping("datalists")
    public DataTableReturn datalists(UserVo userVo,HttpServletRequest request){
        PageBean page = PageUtil.parseRequest2PageBean(request);
        Map<String, String> params = null;
            try {
                params = BeanUtils.describe(userVo);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            params = new HashMap<>();
        }
        List<Map<String, Object>> data = userService.list(params, page);
        return new DataTableReturn(page.getDraw(), page.getTotal(), page.getTotal(), data);
    }
}
