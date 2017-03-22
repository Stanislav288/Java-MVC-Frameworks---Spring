package com.softuni_store.repositoryImpl;

import com.softuni_store.entites.Game;
import com.softuni_store.repositories.GameRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

/**
 * Created by Galin on 5.3.2017 г..
 */

@Stateless
public class GameRepositoryImpl implements GameRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Game game) {
        this.entityManager.persist(game);
    }

    @Override
    public Game findById(long id) {
        Game game=this.entityManager.find(Game.class,id);
        return game;
    }

    @Override
    public void update(Game game) {
        this.entityManager.merge(game);
    }

    @Override
    public void deleteById(long id) {
        Query query=entityManager.createQuery("DELETE FROM Game AS g "+
        "WHERE g.id=:id");
        query.setParameter("id",id);
        query.executeUpdate();
    }

    @Override
    public List<Game> findAll() {
        Query query=entityManager.createQuery("SELECT g FROM Game AS g");
        List<Game> games=query.getResultList();
        return games;
    }
}
