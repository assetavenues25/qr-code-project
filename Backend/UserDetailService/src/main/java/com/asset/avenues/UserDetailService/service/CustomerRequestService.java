package com.asset.avenues.UserDetailService.service;

import com.asset.avenues.UserDetailService.entity.User;
import com.asset.avenues.UserDetailService.repository.CustomerRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerRequestService {

    @Autowired
    private CustomerRequestRepository repository;

    public User saveRequest(User request) {

        return repository.save(request);
    }

    // Fetch all users
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    // Fetch user by ID
    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }
}
