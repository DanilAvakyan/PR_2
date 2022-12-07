package com.example.Rabota.repo;

import com.example.Rabota.Models.Specifications;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpecsRepository extends CrudRepository<Specifications,Long> {
    List<Specifications> findByCPU(String CPU);

    List<Specifications> findByGPU(String GPU);
}
