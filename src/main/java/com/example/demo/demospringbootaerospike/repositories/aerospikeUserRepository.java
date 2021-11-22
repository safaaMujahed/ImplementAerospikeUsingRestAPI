package com.example.demo.demospringbootaerospike.repositories;

import com.example.demo.demospringbootaerospike.objects.User;
import org.springframework.data.aerospike.repository.AerospikeRepository;

public interface aerospikeUserRepository extends AerospikeRepository<User, Object> {
}