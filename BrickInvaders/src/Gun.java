import processing.core.PImage;


public class Gun implements Guninterface{

    int width = 15;
    public void star() {
        int j=Main.stars.size();
        for (int i = 0; i < j; i++) {
            if (Main.pApplet.mouseX < Main.stars.get(i).locationX) {
                if (Main.stars.get(i).locationX - Main.pApplet.mouseX <= 15 && 525 - Main.stars.get(i).locationY <= 70 && 525 - Main.stars.get(i).locationY > -70) {
                    Main.score+=10;
                    j--;
                    Main.stars.remove(Main.stars.get(i));

                }
            } else {

                if (Main.pApplet.mouseX - Main.stars.get(i).locationX <= 50 && 525 - Main.stars.get(i).locationY <= 70 && 525 - Main.stars.get(i).locationY > -70) {
                    Main.score+=10;

                    j--;
                    Main.stars.remove(Main.stars.get(i));

                }
            }
        }
    }

    int lives = 3;
    public void heart() {
        for (int i = 0; i < Main.hearts.size(); i++) {
            if (Main.pApplet.mouseX < Main.hearts.get(i).locationX) {
                if (Main.hearts.get(i).locationX - Main.pApplet.mouseX <= 15 && 525 - Main.hearts.get(i).locationY <= 70 && 525 - Main.hearts.get(i).locationY > -70) {
                    if(lives<5){
                        lives++;
                    }
                    Main.hearts.remove(Main.hearts.get(i));

                }
            } else {

                if (Main.pApplet.mouseX - Main.hearts.get(i).locationX <= 50 && 525 - Main.hearts.get(i).locationY <= 70 && 525 - Main.hearts.get(i).locationY > -70) {
                    if(lives<5){
                        lives++;
                    }
                    Main.hearts.remove(Main.hearts.get(i));

                }
            }
        }
    }

    public void lose_for_chickens() {
        for (int i = 0; i < Main.chickens.size(); i++) {
            if (Main.pApplet.mouseX < Main.chickens.get(i).locationX) {
                if (Main.chickens.get(i).locationX - Main.pApplet.mouseX <= 15 && 475 - Main.chickens.get(i).locationY <= 70 && 475 - Main.chickens.get(i).locationY > -70) {
                    lives--;
                    Main.hit++;
                    Main.chickens.remove(Main.chickens.get(i));

                }
            } else {

                if (Main.pApplet.mouseX - Main.chickens.get(i).locationX <= 90 && 475 - Main.chickens.get(i).locationY <= 70 && 475 - Main.chickens.get(i).locationY > -70) {
                    lives--;
                    Main.hit++;
                    Main.chickens.remove(Main.chickens.get(i));

                }
            }
        }
    }
    public void lose_for_giant() {
        for (int i = 0; i < Main.giants.size(); i++) {
            if (Main.pApplet.mouseX < Main.giants.get(i).locationX) {
                if (Main.giants.get(i).locationX - Main.pApplet.mouseX <= 25 && 475 - Main.giants.get(i).locationY <= 110 && 475 - Main.giants.get(i).locationY > -70) {
                    lives=0;
                    Main.gianthit++;
                    Main.giants.remove(Main.giants.get(i));

                }
            } else {

                if (Main.pApplet.mouseX - Main.giants.get(i).locationX <= 125 && 475 - Main.giants.get(i).locationY <= 110 && 475 - Main.giants.get(i).locationY > -70) {
                    lives=0;
                    Main.gianthit++;
                    Main.giants.remove(Main.giants.get(i));

                }
            }
        }
    }

    public void passed(){
        for(int i=0;i<Main.chickens.size();i++){
            if(Main.chickens.get(i).locationY >700){
                Main.passed++;
            }
        }
    }


    private static PImage gun;

    public static void gunface() {
        gun = Main.pApplet.loadImage("gun2.png");
    }
    public static void showGun() {

        int directionX = Main.pApplet.mouseX - 25;

        Main.pApplet.image(gun, directionX,475, 60,80);

    }


    }



