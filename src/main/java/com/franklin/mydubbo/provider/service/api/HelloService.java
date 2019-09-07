package com.franklin.mydubbo.provider.service.api;

import com.franklin.mydubbo.entity.Person;

/**
 * @author Kirby
 * @date 2019/9/7 0007 11:01
 */
public interface HelloService {

    String sayHello(String username);

    Person helloPerson(Integer id);
}
