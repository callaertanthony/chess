package com.fges.rizomm.m1.chess.controllers;

import com.fges.rizomm.m1.chess.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {

    private static List<String> playerOnePieces = new ArrayList<>();

    private final PlayerService playerService;

    @Autowired
    public GameController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/game")
    public String game(Model model) {
        return "game";
    }

    @GetMapping("/pieces")
    @ResponseBody
    public List<String> getPieces() {
        List<String> pieces = new ArrayList<>();
        pieces.add("KING");
        pieces.add("QUEEN");
        pieces.add("ROOK");

        return pieces;
    }

    @GetMapping("/myPieces")
    @ResponseBody
    public List<String> getMyPieces(@RequestParam("player") String player) {
        return playerService.getPiecesForPlayer(player);

    }


}
