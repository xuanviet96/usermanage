package com.demo.usermanage.service;

import com.demo.usermanage.entity.User;
import com.demo.usermanage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(Integer id) {
        return userRepository.findById(id).get();
    }

//    public List<User> search(String term){
//        return userRepository.findByNameContaining(term);
//    }

    public User save(User user) {
        return  userRepository.save(user);
    }
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }




}
