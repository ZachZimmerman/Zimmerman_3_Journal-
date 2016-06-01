package pkg10x10;

import java.util.Random;

public class Ogre {

    public static Random rand = new Random();
    public int x;
    public int y;
    char symbol = 'J';

    Ogre(int a, int b) {
        this.x = a;
        this.y = b;

    }

    public void move() {
        int chance = rand.nextInt(100);
        if (chance < 25) {

        } else {
            if (this.x < Main.player1.x) {
                this.x++;
            } else if (this.x > Main.player1.x) {
                this.x--;
            } else if (this.y < Main.player1.y) {
                this.y++;
            } else if (this.y > Main.player1.y) {
                this.y--;
            }
        }
    }
}