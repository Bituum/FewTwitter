package com.example.twitt.controller.moderator;

import com.example.twitt.message.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModeratorController {

    public ResponseEntity moder() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        new ResponseMessage("vse ok")
                );
    }
}
