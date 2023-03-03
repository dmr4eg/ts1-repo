package cz.cvut.fel.pjv.game;

public class Player {
    private final String name;
    private int currentPosition = 0;
    private final Dice dice;

    public Player(String name, Dice dice) {
        this.name = name;
        this.dice = dice;
    }

    public String getName() {
        return name;
    }
    
    public int advance() {
        int throw_dice = dice.throwDice();
        if (currentPosition == 0) {
            if (throw_dice == 6) {
                currentPosition += dice.throwDice();
            } 
        } else {
            int counter = 0;
            while (throw_dice == 6) {
                counter += 6;
                throw_dice = dice.throwDice();
            }
            currentPosition += throw_dice + counter;
        }
     
        
        return currentPosition;
    }
}
