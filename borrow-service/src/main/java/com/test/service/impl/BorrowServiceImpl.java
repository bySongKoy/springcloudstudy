package com.test.service.impl;

import com.test.entity.Book;
import com.test.entity.Borrow;
import com.test.entity.User;
import com.test.entity.UserBorrowDetail;
import com.test.mapper.BorrowMapper;
import com.test.service.BorrowService;
import com.test.service.clients.BookClient;
import com.test.service.clients.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {


   @Autowired
   private BorrowMapper borrowMapper;
//   @Resource
//   private RestTemplate template;
    @Resource
    private UserClient userClient;

    @Resource
    private BookClient bookClient;


    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrow = borrowMapper.getBorrowsByUid(uid);
        //那么问题来了，现在拿到借阅关联信息了，怎么调用其他服务获取信息呢？
        //获取用户信息
        //User user = user.getForObject("http://userservice/user/"+uid,User.class);
        User user = userClient.findUserById(uid);
        List<Book> bookList = borrow.
                stream().map(b -> bookClient.findBookById(b.getBid())).collect(Collectors.toList());


        return new UserBorrowDetail(user,bookList);
    }
}
