package com.temelt.issuemanagement.service.implementation;

import com.temelt.issuemanagement.entity.User;
import com.temelt.issuemanagement.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.temelt.issuemanagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    @Override
    public User save(User user) {

        if (user.getEmail()==null){
            throw new IllegalArgumentException("Email cannot be empty");
        }

        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return getAllPageable(pageable);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean delete(User user) {
        userRepository.delete(user);
        return true;
    }
}
