package com.training.platform.services;

import com.training.platform.entities.User;
import com.training.platform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> findByAddress(String address) {
        return userRepository.findByAddress(address);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Page<User> findAllByLimit(Integer start, Integer limit, String field) {
        PageRequest page = PageRequest.of(start, limit, Sort.by(Sort.Direction.ASC, field));
        return userRepository.findAll(page);
    }

    @Override
    public List<User> findByCityAndActiveAndAge(String city, Integer active, Integer age) {
        return userRepository.findByCityAndActiveAndAge(city, active, age);
    }

    @Override
    public List<User> findByAgeIn(List<Integer> ages) {
        return userRepository.findByAgeIn(ages);
    }

    @Override
    public List<User> findAllByQuery() {
        return userRepository.findAllByQuery();
    }


    @Override
    public List<User> findAllByParamsQuery(Integer active, String city) {
        return userRepository.findAllByParamsQuery(active, city);
    }

    @Override
    public List<User> findAllByJpqlQuery() {
        return userRepository.findAllByJpqlQuery();
    }

    @Override
    public List<User> findAllByJpqlParamsQuery(Integer active, String city) {
        return userRepository.findAllByJpqlParamsQuery(active, city);
    }
}

