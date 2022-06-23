package com.survey.service;

import com.survey.dto.UserDTO;
import com.survey.model.User;
import com.survey.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserControllerImp implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUserNameAndPassword(String name, String password) {
        return userRepository.findByUserNameAndPassword(name, password);
    }

    @Override
    public User save(UserDTO userDTO) {

        return userRepository.save(userDTO.toEntity());
    }

    @Override
    public User findById(Long surveyId) {
        Optional<User> user = userRepository.findById(surveyId);
        if (user.isPresent()) return user.get();
        return null;
    }

//    @Override
//    public User update(UserDTO userDTO) {
//        final Optional<User> foundUser = userRepository.findById(userDTO.getUserId());
//        foundUser.ifPresent(newUser -> {
//            newUser.setUserName(userDTO.getUserName());
//            newUser.setBankAccount(userDTO.getBankAccount());
//            newUser.setBankName(userDTO.getBankName());
//            newUser.setBirth(userDTO.getBirth());
//            newUser.setEmail(userDTO.getEmail());
//            newUser.setPassword(userDTO.getPassword());
//            newUser.setPhoneNumber(userDTO.getPhoneNumber());
//            userRepository.save(newUser);
//        });
//
//        return userRepository.findByUser(foundUser);
//    }
}
