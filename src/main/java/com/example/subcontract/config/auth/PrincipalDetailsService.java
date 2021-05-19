package com.example.subcontract.config.auth;

import com.example.subcontract.user.repository.UserRepository;
import com.example.subcontract.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//시큐리티 설정에서 loginProcessingUrl("/login");
// /login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC되어 있는 loadUserByUsername 함수가 실행된다.
@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    //시큐리티 session(Authentication 객체(UserDetails 객체))
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //log.info("username:" + username);
        UserVO userEntity = userRepository.findByUserId(username);
        if(userEntity != null){
            return new PrincipalDetails(userEntity);
        }
        return null;
    }
}
