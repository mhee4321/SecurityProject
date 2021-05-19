package com.example.subcontract.user.repository;

import com.example.subcontract.user.vo.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    //findBy규칙 -> Username문법
    //select * from user where username = ?
    //public UserVO findByUsername(String username);
    public UserVO findByUserId(String userId);
}
