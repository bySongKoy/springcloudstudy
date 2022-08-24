package com.test.service.clients.fallbak;

import com.test.entity.User;
import com.test.service.clients.UserClient;
import org.springframework.stereotype.Component;

@Component
public class UserFallbackClient implements UserClient {
    @Override
    public User findUserById(int uid) {
        System.out.println("降级熔断");
        return new User();
    }
}
