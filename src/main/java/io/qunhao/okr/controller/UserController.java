package io.qunhao.okr.controller;

import io.qunhao.okr.entity.UserEntity;
import io.qunhao.okr.payload.UserSummary;
import io.qunhao.okr.repo.UserRepo;
import io.qunhao.okr.security.CurrentUser;
import io.qunhao.okr.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserRepo userRepository;

    @GetMapping("/user/{id}")
    public UserEntity getUsersById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("/me")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        return new UserSummary(currentUser.getId(),
                currentUser.getUsername(), currentUser.getName());
    }

    @GetMapping("/count")
    public Long getUserCount() {
        return userRepository.count();
    }

    @GetMapping("")
    public List<UserEntity> getUsersByPage(@RequestParam int page, @RequestParam int size) {
        Pageable pr = PageRequest.of(page - 1, size);
        return userRepository.findAll(pr).getContent();
    }

    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = new ArrayList<>();
        for (UserEntity userEntity : userRepository.findAll()) {
            users.add(userEntity);
        }
        return users;
    }
}
