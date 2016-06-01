package pkg10x10;

import java.util.Scanner;

public class Main {

    
    public static String movement;   
    public static Player player1;
    public static Shoots shootz;
    public static Ogre ogre1;
    public static Trap trap1;
    public static Trap trap2;
    public static Treasure treasure1;
    public static boolean letsplay = true;    
    public static void main(String[] args) {
        trap2 = new Trap(3,5);
        trap1 = new Trap(10,10);
        player1 = new Player(12, 12);
        treasure1 = new Treasure(1, 1);
        ogre1 = new Ogre(8,3);
        shootz = new Shoots (9,13);
        
        System.out.println("Use the arrow keys on the NumPad to move N,NE,E,SE,S,SW,W,NW \n Find the treasure chest T and and extra gold G to win."
                + " \n Watch out for Traps X and enemies J, S");
        
        while (letsplay){
            System.out.println("Health");
            System.out.println(player1.hp);
            System.out.println("Score");
            System.out.println(player1.score);
        board();       
        player1.move();
        player1.update();
        ogre1.move();
        shootz.move();
        }
    }

static void board() {
        char[][] board = new char[23][23];
        
        //Makes the Matrix
        for (int i = 0; i <= board[0].length - 1; i++) {
            for (int j = 0; j <= board[1].length - 1; j++) {
               board[i][j] = '.';
            }
        }
        board[player1.x][player1.y]='@';
        board[trap2.x][trap2.y]='X';
        board[trap1.x][trap1.y]='X'; 
        board[treasure1.x][treasure1.y]='T';
        board[ogre1.x][ogre1.y]='J';
        board[shootz.x][shootz.y]='S';
        
        //Prints the Matrix
        for(int i = 0; i < board.length; i++) {
            for(int a = 0; a < board.length; a++) {
                if(a < board.length - 1) {
                    System.out.print(board[i][a]);
                } else {
                    System.out.println(board[i][a]);
                }
            }
        }
    }

public static void win() {
    System.exit(0);
    System.out.println("Good Job you won");
}

public static void endGame(int i) {
    if(i == 0) {
        System.out.println("You ran out of health!!");
        System.exit(0);
    }
    if(i == 1) {
        System.out.println("You defeated all of the enemies!!!");
        System.exit(0);
    }
}
}