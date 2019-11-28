package com.fh.vue.mapper;

import com.fh.vue.entity.Game;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameMapper {
    List<Game> queryList();

    void addGame(Game game);

    void updateGame(Game game);

    void deleteGame(int id);
}
