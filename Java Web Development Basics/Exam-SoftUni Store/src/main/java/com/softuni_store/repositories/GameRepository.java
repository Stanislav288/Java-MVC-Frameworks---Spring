package com.softuni_store.repositories;

import com.softuni_store.entites.Game;

import java.util.List;
import java.util.Set;

/**
 * Created by Galin on 5.3.2017 г..
 */
public interface GameRepository {
    void create(Game game);

    Game findById(long id);

    void update(Game game);

    void deleteById(long id);

    List<Game> findAll();
}
