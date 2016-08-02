package com.upsoft.semantic.user.mapper;

import com.github.pagehelper.PageHelper;
import com.upsoft.semantic.domain.User;
import com.upsoft.semantic.mapper.user.UserMapper;
import com.upsoft.semantic.util.IDCreator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/8/2.
 */
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestUserMapper {
    @Resource(name="userMapper")
    private UserMapper userMapper;
    @Test
    public void testInsert() {
        List<User> users = new ArrayList<User>(100);
        for (int i = 0; i < 100; i++) {
            users.add(new User(IDCreator.create(), "wangqiang" + i, "password" + i, i));
        }
        userMapper.insert(users);
    }

    @Test
    public void testSelectUser(){
        PageHelper.startPage(1, 10);
        List<User> users = userMapper.selectUsers();
        System.out.println(users);
        for(User user:users){
            System.out.println(user);
        }
    }

}
