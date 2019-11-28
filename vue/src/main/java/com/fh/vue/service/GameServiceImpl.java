package com.fh.vue.service;

import com.fh.vue.entity.Game;
import com.fh.vue.mapper.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameMapper gameMapper;

    @Override
    public List<Game> queryList() {
        return gameMapper.queryList();
    }

    @Override
    public void addGame(Game game) {
        gameMapper.addGame(game);
    }

    @Override
    public void updateGame(Game game) {
        gameMapper.updateGame(game);
    }

    @Override
    public void deleteGame(int id) {
        gameMapper.deleteGame(id);
    }
}
