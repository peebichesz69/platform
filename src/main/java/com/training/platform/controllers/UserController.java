package com.training.platform.controllers;

import com.training.platform.entities.User;
import com.training.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demo")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping(value = "/findById/{id}")
    public Optional findById(@PathVariable int id) {
        Optional<User> users = userService.findById(id);
        return users;
    }

    @GetMapping(value = "/findByName/{name}")
    public List findByName(@PathVariable String name) {
        List<User> users = userService.findByName(name);
        return users;
    }

    @GetMapping(value = "/findByAddress/{address}")
    public List findByAddress(@PathVariable String address) {
        List<User> users = userService.findByAddress(address);
        return users;
    }

    @GetMapping(value = "/findAllByLimit")
    public Page findAllByLimit(@RequestParam Integer start, Integer limit, String field) {
        Page<User> users = userService.findAllByLimit(start, limit, field);
        return users;
    }

    @GetMapping(value = "/findByCityAndActiveAndAge")
    public List findByCityAndActiveAndAge(@RequestParam String city, Integer active, Integer age) {
        List<User> users = userService.findByCityAndActiveAndAge(city, active, age);
        return users;
    }

    @GetMapping(value = "/findByAgeIn/{ages}")
    public List findByAgeIn(@PathVariable List<Integer> ages) {
        List<User> users = userService.findByAgeIn(ages);
        return users;
    }

    @GetMapping(value = "/findAllByQuery")
    public List<User> findAllByQuery() {
        return userService.findAllByQuery();
    }

    @GetMapping(value = "/findAllByParamsQuery")
    public List<User> findAllByParamsQuery(@RequestParam Integer active, String city) {
        return userService.findAllByParamsQuery(active, city);
    }

    @GetMapping(value = "/findAllByJpqlQuery")
    public List<User> findAllByJpqlQuery() {
        return userService.findAllByJpqlQuery();
    }

    @GetMapping(value = "")
    public List<User> index() {
        // Change from UserRepository to UserService
        return userService.findAllByJpqlParamsQuery(0, "bangkok");
    }

}
