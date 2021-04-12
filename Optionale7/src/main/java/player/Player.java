package player;

import board.Board;
import board.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Player implements Runnable {
    String name;
    List<Token> tokens;
    final Board board;

    public Player(String name, Board board) {
        this.name = name;
        this.tokens = new ArrayList<>();
        this.board = board;
    }

    public Player() {
        this.board = null;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", tokens=" + tokens +
                '}';
    }


    /**
     * Cât timp mai sunt tokeni pe tablă, fiecare jucator extrage un token random
     */
    @Override
    public void run() {
        Random rand = new Random();

        while(this.board.getNumberOfTokens()>0){

            int tokenId = rand.nextInt(this.board.getNumberOfTokens());
            Token localToken = this.board.getToken(tokenId);
            this.tokens.add(localToken);

        }

    }
}
