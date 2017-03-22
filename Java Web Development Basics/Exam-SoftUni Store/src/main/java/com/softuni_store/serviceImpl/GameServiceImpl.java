package com.softuni_store.serviceImpl;

import com.softuni_store.entites.Game;
import com.softuni_store.entites.User;
import com.softuni_store.models.bindingModels.GameBindingModel;
import com.softuni_store.models.bindingModels.GameEditBindingModel;
import com.softuni_store.models.viewModels.GameDetailsViewModel;
import com.softuni_store.models.viewModels.GameEditViewModel;
import com.softuni_store.models.viewModels.GameHomeViewModel;
import com.softuni_store.models.viewModels.GameViewModel;
import com.softuni_store.repositories.GameRepository;
import com.softuni_store.repositories.UserRepository;
import com.softuni_store.service.GameService;
import com.softuni_store.utils.parser.interfaces.ModelParser;
import org.modelmapper.PropertyMap;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class GameServiceImpl implements GameService{

    @Inject
    private GameRepository gameRepository;

    @Inject
    private UserRepository userRepository;

    @Inject
    private ModelParser modelParser;

    @Override
    public void save(GameBindingModel gameBindingModel,String userEmail) {
        Game game=new Game();
        PropertyMap<GameBindingModel,Game> propertyMap=new PropertyMap<GameBindingModel, Game>() {
            @Override
            protected void configure() {
                    skip().setReleaseDate(null);
            }
        };

        game=this.modelParser.convert(gameBindingModel,Game.class,propertyMap);
        try {
            game.setReleaseDate(new SimpleDateFormat("yyyy-MM-dd").parse(gameBindingModel.getReleaseDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        User user=this.userRepository.findByEmail(userEmail);
        game.setUser(user);
        this.gameRepository.create(game);
    }

    @Override
    public GameEditViewModel findById(long id) {
        Game game=this.gameRepository.findById(id);
        GameEditViewModel gameEditViewModel=this.modelParser.convert(game,GameEditViewModel.class);
        return gameEditViewModel;
    }

    @Override
    public void update(GameEditBindingModel gameEditBindingModel) {
        Game game=this.modelParser.convert(gameEditBindingModel,Game.class);
        this.gameRepository.update(game);
    }

    @Override
    public void deleteById(long id) {
        this.gameRepository.deleteById(id);
    }

    @Override
    public List<GameViewModel> findAll() {
        List<Game> games=this.gameRepository.findAll();
        List<GameViewModel> gameViewModels=new ArrayList<>();
        for (Game game:games) {
            GameViewModel gameViewModel=this.modelParser.convert(game,GameViewModel.class);
            gameViewModels.add(gameViewModel);
        }

        return gameViewModels;
    }

    @Override
    public List<GameHomeViewModel> findAllWithExtraInfo() {
        List<Game> games=this.gameRepository.findAll();
        List<GameHomeViewModel> gameHomeViewModels=new ArrayList<>();
        for (Game game:games) {
            GameHomeViewModel gameHomeViewModel=this.modelParser.convert(game,GameHomeViewModel.class);
            gameHomeViewModels.add(gameHomeViewModel);
        }

        return gameHomeViewModels;
    }

    @Override
    public GameDetailsViewModel findGameDetails(long id) {
        Game game=this.gameRepository.findById(id);
        GameDetailsViewModel gameDetailsViewModel=this.modelParser.convert(game,GameDetailsViewModel.class);
        return gameDetailsViewModel;
    }
}
