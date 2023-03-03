package cz.cvut.fel.pjv.game;

public class Start {

    public static void main(String[] args) {
        Dice dice = new Dice();
        Player[] players = {
            new Player("Pepa", dice),
            new Player("Eva", dice),
            new Player("Tom", dice)
        };
        
        Game game = new Game(players);
        game.playGame();
        
//        System.out.println(dice.throwDice());

    }
}
