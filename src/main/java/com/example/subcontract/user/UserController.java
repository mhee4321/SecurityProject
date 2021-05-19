package com.example.subcontract.user;

import com.example.subcontract.user.vo.UserVO;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @GetMapping("/loginForm")
    public String loginForm(){
        return "user/loginForm";
    }
    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    @GetMapping("/user")
    public String user(){
        return "user/user";
    }

    @GetMapping("/admin")
    public String admin(){
        return "user/admin";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/info")
    @ResponseBody
    public String info(){
        return "개인정보";
    }


    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/data")
    @ResponseBody
    public String data(){
        return "데이정보";
    }
}
