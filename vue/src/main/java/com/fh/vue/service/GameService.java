package com.fh.vue.service;

import com.fh.vue.entity.Game;

import java.util.List;

public interface GameService {
    List<Game> queryList();

    void addGame(Game game);

    void updateGame(Game game);

    void deleteGame(int id);
}
