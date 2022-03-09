package com.senla.course.service.impl;

import com.senla.course.enums.ActivityStatus;
import com.senla.course.model.Role;
import com.senla.course.model.User;
import com.senla.course.repository.RoleRepository;
import com.senla.course.repository.UserRepository;
import com.senla.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findRoleByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(ActivityStatus.ACTIVE);
        User registeredUser = userRepository.save(user);
       // LOGGER.info("IN register - user: {} successfully registered", registeredUser);
        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
      //  LOGGER.info("IN getAll - {} users found", result.size());
        return result;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepository.findUserByUsername(username);
        //LOGGER.info("IN findByUsername - user: {} found by username: {}", result, username);
        return result;
    }

    @Override
    public User findById(Long id) {

        User result = null;
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
          //  LOGGER.warn("IN findById - no user found by id: {}", id);&&&??????????????????????????
            result = optional.get();
        }
      //  LOGGER.info("IN findById - user: {} found by id: {}", result,id);
        return result;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
       // LOGGER.info("IN delete - user {}", user);//&&&&&&&&&&&&
    }

}
