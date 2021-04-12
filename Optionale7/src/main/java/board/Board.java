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


    public synchronized Token getToken(int id) {
        Token returnedToken = null;
        if (tokenList.size() > 0) {
            returnedToken = tokenList.get(id);
            deleteToken(id);
        }

        return returnedToken;

    }

    public int getNumberOfTokens() {
        return this.tokenList.size();
    }

    public void play() {
        for (Player player : players) {
            Thread t = new Thread(player);
            t.start();
        }

    }

    private int getTotalValueOfTokens(Player player) {
        int sum = 0;
        for (Token token : player.getTokens()) {
            sum += token.valoare;
        }
        return sum;
    }


    /**
     * Comparam playerii in functie de numarul de tokeni, iar daca acesta este egal,
     * comparam in functie de suma valorii a tuturor tokenilor
     *
     */
    public void showWinner() {
        Player winner = this.players.get(0);
        for (Player player : players) {
            if (player.getTokens().size() > winner.getTokens().size())
                winner = player;
            else if (player.getTokens().size() == winner.getTokens().size()) {
                if (getTotalValueOfTokens(player) > getTotalValueOfTokens(winner)) {
                    winner = player;
                }
            }
        }
        System.out.println("The winner is " + winner.getName());
    }


    @Override
    public String toString() {
        return "Board{" +
                "tokenList=" + tokenList +
                '}';
    }


}
