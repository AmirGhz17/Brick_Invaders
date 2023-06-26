import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

public class Bullet extends PApplet{

    static int speed=5;
        int locationX;
        int locationY;
        static PImage bulletimage;

        private static PApplet pApplet = Main.pApplet;


        public Bullet(int locationX, int locationY) {
            this.locationX = locationX;
            this.locationY = locationY;
        }

        public static void makeBullet() {
            Main.bullets.add(new Bullet(pApplet.mouseX, 475));
        }

        public static void showBullet() {
            for (int x=0;x<Main.bullets.size();x++){
                Main.pApplet.image(bulletimage,Main.bullets.get(x).getLocationX(),Main.bullets.get(x).getLocationY(),30,30);
                if(Main.bullets.get(x).locationY<10){
                    Main.bullets.remove(Main.bullets.get(x));
                }
            }

        }

        public static void moveBullet(int speed) {

            for (Bullet bullet:Main.bullets) {
                bullet.locationY -=speed;
            }

        }

    public static void Bulletface() {

        bulletimage = Main.pApplet.loadImage("bullettwo2.png");

    }

    public  static void remove_Bullet_and_giant(){

            for (int i = 0; i < Main.bullets.size(); i++) {
                for (int j = 0; j < Main.giants.size(); j++) {
                    if (Main.bullets.get(i).locationX+10 >= Main.giants.get(j).getLocationX() && Main.bullets.get(i).getLocationX() <= Main.giants.get(j).getLocationX() + 90 && Main.bullets.get(i).locationY >= Main.giants.get(j).getLocationY() && Main.bullets.get(i).getLocationY() <= Main.giants.get(j).getLocationY() + 90) {

                        Main.giants.get(j).R--;
                        Main.bullets.remove(i);
                        Main.gianthit++;

                        if (Main.giants.get(j).R==0){
                            Main.score+=1000;
                            DataBase.AddHighScore(Main.score + Main.passed);
                            Main.giants.remove(j);
                            Main.game=false;
                            Main.win=true;
                        }
                        break;
                    }
                }
            }
    }



    public static void remove_Bullet_and_chicken() {

        for (int i = 0; i < Main.bullets.size(); i++) {
            for (int j = 0; j < Main.chickens.size(); j++) {
                if (Main.bullets.get(i).locationX >= Main.chickens.get(j).getLocationX() && Main.bullets.get(i).getLocationX() <= Main.chickens.get(j).getLocationX() + 60 && Main.bullets.get(i).locationY >= Main.chickens.get(j).getLocationY() && Main.bullets.get(i).getLocationY() <= Main.chickens.get(j).getLocationY() + 70) {

                    Main.chickens.get(j).R--;

                    if (Main.chickens.get(j).R==2){

                        Main.chickens.get(j).newimage=Chicken.chickenimage1;
                    }
                    if (Main.chickens.get(j).R==1){

                        Main.chickens.get(j).newimage=Chicken.chickenimage2;
                    }
                    if (Main.chickens.get(j).R==0){

                        Main.chickens.get(j).newimage=Chicken.chickenimage3;
                    }

                    Main.bullets.remove(Main.bullets.get(i));

                    if (Main.chickens.get(j).R==-1){
                    Main.chickens.remove(Main.chickens.get(j));
                    Main.removed++;
                    Main.score+=15;
                    }
                    break;


                }
            }
        }
    }

        public int getLocationX() {
            return locationX;
        }

        public int getLocationY() {
            return locationY;
        }

        public static void removeBullet() {
            for (int i=0; i<Main.bullets.size() ; i++){
                if (Main.bullets.get(i).locationY <= 10) {
                    Main.bullets.remove(Main.bullets.get(i));
                }
            }
        }


}
