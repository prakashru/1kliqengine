package com.emuntiy.rest.webservice.pojo.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Component
public class UserDaoService {

     static int userCount = 0;
    public List<User> findAll(){
        return users;
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.remove(predicate);
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    //public User Save(User user) {}

    //JPA/Hibernate Database
    //UserDaoService > Static List
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(++userCount,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount,"Eve", LocalDate.now().minusYears(20)));
        users.add(new User(++userCount,"Jim", LocalDate.now().minusYears(10)));

    }
}
