import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.Random;

public class Chicken extends PApplet {

    public int R;

    public static int speedY = -100;
    int locationX;
    int locationY;

    private static PImage chickenimage;
    public static PImage chickenimage1;
    public static PImage chickenimage2;
    public static PImage chickenimage3;

    public PImage newimage;


    public Chicken(int locationX, int locationY,int R) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.R=R;
        this.newimage=chickenimage;
    }

    public static void makeChickens() {

        for (int i = 0; i < 30; i++) {

            Main.chickens.add(new Chicken(new Random().nextInt(1, 650), speedY,3));

            speedY -= 96;
            Main.chickens.add(new Chicken(new Random().nextInt(1, 650), speedY,1));

            speedY -= 96;
            Main.chickens.add(new Chicken(new Random().nextInt(1, 650), speedY,2));

            speedY -= 96;
            Main.chickens.add(new Chicken(new Random().nextInt(1, 650), speedY,1));

            speedY -= 96;
            Main.chickens.add(new Chicken(new Random().nextInt(1, 650), speedY,3));

            speedY -= 96;

        }
        for (Chicken chicken:Main.chickens){
            if (chicken.R==2){

                chicken.newimage=Chicken.chickenimage1;
            }
            if (chicken.R==1){

                chicken.newimage=Chicken.chickenimage2;
            }
            if (chicken.R==0){

                chicken.newimage=Chicken.chickenimage3;
            }
        }
    }

    public static void showChicken(ArrayList<Chicken> chickens) {
        for (Chicken chicken : chickens) {

                Main.pApplet.image(chicken.newimage,chicken.getLocationX(),chicken.getLocationY(),80,80);
        }
    }

    public static void moveChicken(int speed) {
        for (Chicken chicken : Main.chickens) {
            chicken.locationY += speed;
        }
    }


    public static void removeChicken() {

        for (int i = 0; i < Main.chickens.size(); i++) {
            if (Main.chickens.get(i).locationY > 700) {
                Main.removed++;
                Main.chickens.remove(i);
                break;
            }
        }
    }
    public  static void chickenface(){


        chickenimage = Main.pApplet.loadImage("enemy1.png");
        chickenimage1 = Main.pApplet.loadImage("enemy2.png");
        chickenimage2 = Main.pApplet.loadImage("enemy3.png");
        chickenimage3 = Main.pApplet.loadImage("enemy4.png");


    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

}
