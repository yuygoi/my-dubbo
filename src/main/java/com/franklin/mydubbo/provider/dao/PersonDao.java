package com.franklin.mydubbo.provider.dao;

import com.franklin.mydubbo.entity.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Kirby
 * @date 2019/9/7 0007 16:32
 */
public class PersonDao {

    private static Map<Integer,Person> map = new HashMap<>();

    static {
        for (int i = 1; i <= 10; i++) {
            Person person = new Person();
            person.setId(i);
            person.setAge((int) (Math.random()*30));
            person.setName(
                    UUID.randomUUID().toString().substring(0,10)
            );
            map.put(person.getId(),person);
        }
    }

    public static Person queryPersonById(Integer id){
        return map.get(id);
    }
}
