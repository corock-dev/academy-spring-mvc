package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.User;
import com.nhnacademy.springmvc.exception.UserNotFoundException;
import com.nhnacademy.springmvc.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/{userId}")
public class UserController {
    private final UserRepository userRepository;

    @ModelAttribute("user")
    public User getUser(@PathVariable("userId") String userId) {
        return userRepository.getUser(userId);
    }

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // @GetMapping("/{userId}")
    @GetMapping
    public String getUserInfo(/* @PathVariable("userId") String userId, */
                              @ModelAttribute("user") User user,
                              Model model) {
        // User user = userRepository.getUser(userId);
        // if (Objects.isNull(user)) {
        //     model.addAttribute("exception", new UserNotFoundException());
        //     return "error";
        // }

        model.addAttribute("user", user);
        return "userInfo";
    }

    // @GetMapping("/{userId}/modify")
    @GetMapping("/modify")
    public String userModifyForm(/* @PathVariable("userId") String userId, */
                                 @ModelAttribute("user") User user,
                                 Model model) {
        // User user = userRepository.getUser(userId);
        // if (Objects.isNull(user)) {
        //     model.addAttribute("exception", new UserNotFoundException());
        //     return "error";
        // }

        model.addAttribute("user", user);
        return "userModify";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String handleException(Model model, UserNotFoundException exc) {
        model.addAttribute("exception", exc);
        return "error";
    }
}
