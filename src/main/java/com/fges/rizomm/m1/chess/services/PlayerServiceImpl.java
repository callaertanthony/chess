package com.fges.rizomm.m1.chess.services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static List<String> player1Pieces = new ArrayList<>();
    private static List<String> player2Pieces = new ArrayList<>();

    @PostConstruct
    private void init() {
        player1Pieces.add("KING");
        player1Pieces.add("QUEEN");
        player1Pieces.add("ROOK");

        player2Pieces.add("KING");
        player2Pieces.add("QUEEN");
        player2Pieces.add("KNIGHT");
    }

    @Override
    public List<String> getPiecesForPlayer(@NotNull String player) {
        if("player1".equals(player)) {
            return player1Pieces;
        }

        return player2Pieces;
    }
}
