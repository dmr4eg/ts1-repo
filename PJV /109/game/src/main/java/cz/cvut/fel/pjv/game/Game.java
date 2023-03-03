package cz.cvut.fel.pjv.game;

public class Game {
    private final Player[] players;

    public Game(Player[] players) {
        this.players = players;
    }

    public void playGame() {
        String winner = "";
        while (winner.equals("")) {
            winner = playRound();
        }
        System.out.println("Vyhral " + winner);
    }
    
    private String playRound() {
        for (Player player : players) {
            int currPos = player.advance();
            System.out.println(player.getName() + " postoupil na pole " + currPos);
            if (currPos >= 50) {
                return player.getName();
            }
        }
        return "";
    }
    
}
