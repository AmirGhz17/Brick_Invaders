import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.Random;

public class Star {
    int locationX;
    int locationY;
    public  static int speedY=-300;

    private static PApplet pApplet= Main.pApplet;


    public Star(int locationX, int locationY) {
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public static void makeStars(){
        for (int i=0;i<6;i++){

            Main.stars.add(new Star(new Random().nextInt(1,650),speedY));
            speedY-=400;
            Main.stars.add(new Star(new Random().nextInt(1,650),speedY));
            speedY-=400;
            Main.stars.add(new Star(new Random().nextInt(1,650),speedY));
            speedY-=400;
            Main.stars.add(new Star(new Random().nextInt(1,650),speedY));
            speedY-=400;
            Main.stars.add(new Star(new Random().nextInt(1,650),speedY));
            speedY-=400;
            Main.stars.add(new Star(new Random().nextInt(1,650),speedY));
            speedY-=400;
            Main.stars.add(new Star(new Random().nextInt(1,650),speedY));
            speedY-=400;
            Main.stars.add(new Star(new Random().nextInt(1,650),speedY));
            speedY-=400;
        }
    }
    private static PImage starimage;
    public static void Starface() {

        starimage = Main.pApplet.loadImage("bullet11.png");
        Random random = new Random();

        for (int i=0 ; i<80 ; i++) {
            Main.stars.add(new Star(random.nextInt(10, 650), random.nextInt(-10000, -100 )));
        }
    }

    public static void showStar(ArrayList<Star> stars) {
        for (Star star: stars) {

            Main.pApplet.image(starimage,star.getLocationX(),star.getLocationY(),30,30);
        }
    }

    public static void moveStar(int speed) {
        for (Star star:Main.stars) {
            star.locationY +=speed;
        }
    }
    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }


}
