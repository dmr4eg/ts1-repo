package cz.cvut.fel.pjv.game;

import java.util.Random;

public class Dice {
    private final int sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    public Dice() {
        this.sides = 6;
    }
    
    public int throwDice() {
        Random rnd = new Random();
        return rnd.nextInt(sides) + 1;
    }
}
