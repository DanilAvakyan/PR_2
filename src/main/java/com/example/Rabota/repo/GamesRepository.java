package com.example.Rabota.repo;

import com.example.Rabota.Models.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GamesRepository extends CrudRepository<Game,Long> {
    List<Game> findByName(String name);

    List<Game> findByPrice(float price);

}
