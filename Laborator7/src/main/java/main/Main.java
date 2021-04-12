package main;

import board.Board;
import board.Token;
import player.Player;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<Token> tokenList = IntStream.rangeClosed(0, 3).mapToObj(i -> new Token()).collect(Collectors.toList());
        Board board = new Board(tokenList);
        List<Player> players = IntStream.rangeClosed(0, 3).mapToObj(i -> new Player("Player"+ i, board )).collect(Collectors.toList());
        board.setPlayers(players);
        board.play();

    }
}
