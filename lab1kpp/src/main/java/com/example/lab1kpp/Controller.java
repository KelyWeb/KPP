package com.example.lab1kpp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/ConvertData")
    double func1(@RequestParam(value = "toConvert", defaultValue = "0") double toConvert,
                 @RequestParam(value = "toConvert2", defaultValue = "0") int toConvert2) {

        if(toConvert == 0) {
            return 0.39 * toConvert2;
        } else {
            return (int)(toConvert / 0.39);
        }

    }
}
