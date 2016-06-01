package pkg10x10;

import java.util.Scanner;
import static pkg10x10.Main.movement;


public class Player {
    public int x;
    public int y;
    char symbol = '@';
    public int hp;
    public int score;
    public boolean isAlive;
    
   Player(int a, int b){
       this.x = a;
       this.y = b;
       this.hp = 10;
       this.score = 0;
       this.isAlive = true;
   }
   
   public void checkIntersectTrap() {
       if (this.x == Main.trap1.x && this.y == Main.trap1.y) {
          this.hp -= 5;
       }     
   }
   public void checkIntersectShoots() {
       if (this.x == Main.shootz.x && this.y == Main.shootz.y) {
           this.hp -= 10;
       }
   }
   
   public void checkIntersectOgre() {
       if (this.x == Main.ogre1.x && this.y == Main.ogre1.y) {
           this.hp -= 2;
       }
    }
   
   public void checkIntersectTreasure() {
       if (this.x == Main.treasure1.x && this.y == Main.treasure1.y){
          Main.win();
       }
   }
   
   public void update() {
       checkIntersectTrap();
       checkIntersectTreasure();
       checkIntersectOgre();
       checkIntersectShoots();
       this.isAlive = checkPlayerDead();
       if(!this.isAlive) {
           Main.endGame(0);
       }
   }
   
   void move() {
        
        

        Scanner compass = new Scanner(System.in);
        movement = compass.nextLine().trim().toLowerCase();            // this movement thing is being told that it works for compass
        
        if (movement.contains("3")) { //South East
            x++;
            y++;
        }
        else if (movement.contains("7")) { //North West
            x--;
            y--;        
        }
        if (movement.contains("1")) { //South West
            x++;
            y--;
        }
        else if (movement.contains("9")) { //North East
            x--;
            y++;
        }
        if (movement.contains("8")) {
            x--;
            //y++;
        }
        else if (movement.contains("2")) {
            x++;
            //y--;
        }
        if (movement.contains("6")) {
           //x--;
           y++;
        }
        else if (movement.contains("4")) {
            y--;
        }
        }
   public boolean checkPlayerDead() {
       boolean alive = true;
       if(this.hp <= 0) {
           alive = false;
       }
       
       return alive;
   }
}