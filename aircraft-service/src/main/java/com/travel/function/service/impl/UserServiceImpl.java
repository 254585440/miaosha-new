package com.travel.function.service.impl;

import com.travel.function.dao.UserDao;
import com.travel.function.entity.User;
import com.travel.service.UserService;
import com.travel.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserVo getUser(Integer id) {
        User user = userDao.getUser(id);
        if(user != null){
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user,userVo);
            return userVo;
        }

        return null;
    }
}
