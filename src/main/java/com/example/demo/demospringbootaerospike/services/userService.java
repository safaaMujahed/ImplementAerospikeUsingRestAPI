package com.example.demo.demospringbootaerospike.services;

import com.example.demo.demospringbootaerospike.objects.User;
import com.example.demo.demospringbootaerospike.repositories.aerospikeUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
@AllArgsConstructor
public class userService {
    aerospikeUserRepository aerospikeUserRepository;
    public Optional<User> readUserById(int id) {
        return aerospikeUserRepository.findById(id);
    }
    public void addUser(User user) {
        aerospikeUserRepository.save(user);
    }
    public void removeUserById(int id) {
        aerospikeUserRepository.deleteById(id);
    }
}