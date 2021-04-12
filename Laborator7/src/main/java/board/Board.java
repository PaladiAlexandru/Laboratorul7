package board;

import player.Player;

import java.util.List;

import static java.lang.Thread.sleep;

public class Board {
    List<Token> tokenList;
    List<Player> players;


    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board(List<Token> tokenList) {
        this.tokenList = tokenList;
    }

    public void deleteToken(int id) {
        this.tokenList.remove(id);
    }


    public synchronized Token getToken(int id){
        Token returnedToken = null;
        if(tokenList.size()>0){
            returnedToken = tokenList.get(id);
            deleteToken(id);
        }
        
        return returnedToken;

    }

    public  int getNumberOfTokens() {
        return this.tokenList.size();
    }

    public void play() {
        for (Player player: players) {
            Thread t = new Thread(player);
            t.start();
        }
        System.out.println(this.players);
    }


    @Override
    public String toString() {
        return "Board{" +
                "tokenList=" + tokenList +
                '}';
    }


}
