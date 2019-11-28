package com.fh.vue.controller;

import com.fh.vue.entity.Game;
import com.fh.vue.service.GameService;
import com.fh.vue.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("game")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("queryList")
    @ResponseBody
    public ServerResponse queryList(){
        List<Game> gameList = gameService.queryList();
        return ServerResponse.success(gameList);
    }

    @PostMapping("addGame")
    @ResponseBody
    public ServerResponse addGame(Game game){
        game.setShowTime(new Date());
        gameService.addGame(game);
        return ServerResponse.success("添加成功");
    }

    @PostMapping("updateGame")
    @ResponseBody
    public ServerResponse updateGame(Game game){
        gameService.updateGame(game);
        return  ServerResponse.success("修改成功");
    }

    @PostMapping("deleteGame")
    @ResponseBody
    public ServerResponse deleteGame(int id){
        gameService.deleteGame(id);
        return ServerResponse.success("删除成功");
    }
}
