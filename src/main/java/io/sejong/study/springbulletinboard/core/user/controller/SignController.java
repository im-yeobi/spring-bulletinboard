package io.sejong.study.springbulletinboard.core.user.controller;

import io.sejong.study.springbulletinboard.core.user.http.req.CreateUserReq;
import io.sejong.study.springbulletinboard.core.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/bulletinboard")
public class SignController {

    private final UserService userService;

    public SignController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/sign-in")
    public String signIn(Model model, @ModelAttribute CreateUserReq request) {
        return "/sign/sign-in";
    }

    @RequestMapping("/sign-up")
    public String signUp() {
        return "/sign/sign-up";
    }
}
