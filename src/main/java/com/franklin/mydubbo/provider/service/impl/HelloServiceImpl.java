package com.franklin.mydubbo.provider.service.impl;

import com.franklin.mydubbo.entity.Person;
import com.franklin.mydubbo.provider.dao.PersonDao;
import com.franklin.mydubbo.provider.service.api.HelloService;

/**
 * @author Kirby
 * @date 2019/9/7 0007 11:02
 */
public class HelloServiceImpl implements HelloService {

    public String sayHello(String username) {
        return "Hello " + username;
    }

    @Override
    public Person helloPerson(Integer id) {
        return PersonDao.queryPersonById(id);
    }
}
