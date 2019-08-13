package com.cn;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class  UserServiceImpl implements UserService{

    public List<User> getUsers() {

        return Arrays.asList(
                new User(1,"张三"),
                new User(2,"李四"),
                new User(3,"王五"));
    }

    public Response delete(int id) {
        Response response=new Response();
        response.setCode("00");
        response.setMsg("succes");
        return response;
    }

    public User getUser(int id) {
        return Storage.users.get(id);
    }

    public Response insert(User user) {
        return null;
    }

    public Response update(User user) {
        return null;
    }
}
