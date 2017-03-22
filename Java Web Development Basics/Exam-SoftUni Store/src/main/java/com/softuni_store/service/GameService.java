package com.softuni_store.service;

import com.softuni_store.models.bindingModels.GameBindingModel;
import com.softuni_store.models.bindingModels.GameEditBindingModel;
import com.softuni_store.models.viewModels.GameDetailsViewModel;
import com.softuni_store.models.viewModels.GameEditViewModel;
import com.softuni_store.models.viewModels.GameHomeViewModel;
import com.softuni_store.models.viewModels.GameViewModel;

import java.util.List;

/**
 * Created by Galin on 5.3.2017 г..
 */
public interface GameService {
    void save(GameBindingModel gameBindingModel, String userEmail);

    GameEditViewModel findById(long id);

    GameDetailsViewModel findGameDetails(long id);

    void update(GameEditBindingModel gameEditBindingModel);

    void deleteById(long id);

    List<GameViewModel> findAll();

    List<GameHomeViewModel> findAllWithExtraInfo();
}
