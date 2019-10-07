package io.qunhao.okr.controller;

import io.qunhao.okr.payload.UserSummary;
import io.qunhao.okr.repo.UserRepo;
import io.qunhao.okr.security.CurrentUser;
import io.qunhao.okr.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepo userRepository;

    @GetMapping("/user/me")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(),
                currentUser.getUsername(), currentUser.getName());
        return userSummary;
    }
}
