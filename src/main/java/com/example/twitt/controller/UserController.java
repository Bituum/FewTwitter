package com.example.twitt.controller;

import com.example.twitt.config.jwt.JwtTokenUtil;
import com.example.twitt.entity.MainUser;
import com.example.twitt.exception.UsernameIsTakenException;
import com.example.twitt.exception.WrongUserLoginOrPasswordException;
import com.example.twitt.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:8080/")
public class UserController {

    private final UserServiceImpl userService;
    private final JwtTokenUtil tokenUtil;

    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    public UserController(UserServiceImpl userService, JwtTokenUtil tokenUtil) {
        this.userService = userService;
        this.tokenUtil = tokenUtil;
    }



    @GetMapping("/user")
    public List<MainUser> all() {
        List<MainUser> users = userService.getAll();
        for (MainUser us : users) {
            logger.info(us.getLogin());
            logger.info(us.getPassword());
        }
        return userService.getAll();
    }

    @PostMapping("/user")
    public MainUser newUser(@RequestBody MainUser newUser) {
        try {
            MainUser user = newUser;
            user.setId(0);
            MainUser usertmp = userService.addOne(user);
            return userService.addOne(user);
        } catch (UsernameIsTakenException usernameIsTakenException) {
            usernameIsTakenException.getMessage();
        }
        return null;
    }


    @GetMapping("/user/{id}")
    public MainUser one(@PathVariable int id) {
        return userService.getOneById(id);
    }

    @PutMapping("/user/{id}")
    public MainUser replaceUser(@RequestBody MainUser user) {
        return userService.updateOne(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteOneById(id);
    }

    @PostMapping("/auth/user")
    public ResponseEntity authentication(@RequestBody MainUser user) {
        try {
            MainUser check = userService.checkUser(user);

            String token = tokenUtil.create(user);
            Map<Object, Object> response = new HashMap<>();
            response.put("username", user.getUsername());
            response.put("token", token);
            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (WrongUserLoginOrPasswordException exception) {
            exception.getMessage();
            logger.info("ERROR WRONG PERSON!");
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("WRONG USERNAME OR PASSWORD ERROR");
        }
    }

    @CrossOrigin
    @GetMapping("/check")
    public ResponseEntity check(@RequestParam String token) {
        try {
            logger.info("jwt token = " + token);
            logger.info("CHECKING TOKEN");
            tokenUtil.validateToken(token);
            logger.info("CHECKED!");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("OK");
        } catch (IllegalArgumentException jwtException) {
            logger.info("CHECKING TOKEN FAILED");
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("JWT IS EXPIRED");
        }
    }

}
