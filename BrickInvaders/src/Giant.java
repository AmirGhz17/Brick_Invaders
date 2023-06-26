import processing.core.PImage;
import java.util.ArrayList;
import java.util.Random;

public class Giant {

    public int R;

    public  static int speedY=-20;
    int locationX;
    int locationY;
    private static PImage Giantimage;

    public Giant(int locationX, int locationY,int R) {

        this.locationX = locationX;
        this.locationY = locationY;
        this.R=R;

    }

    public static void makeGiants(){

        for (int y=0;y<1;y++) {
            Main.giants.add(new Giant(300, speedY,50));
        }
    }




    public static void Giantface() {
        Giantimage = Main.pApplet.loadImage("enemygiant.png");
    }

    public static void showGiant(ArrayList<Giant> giants) {
        for (Giant giant: giants) {

            Main.pApplet.image(Giantimage,giant.getLocationX(),giant.getLocationY(),120,120);

       }
    }

    static boolean limit;
    public static void moveGiant(int speed) {
        for (Giant giant : Main.giants) {

            if (giant.locationY<=30) {
                giant.locationY += speed;
            }
            else {
                if (giant.locationX<=30){
                    limit=true;
                }
                else if (giant.locationX>=520){
                    limit=false;
                }
                if (limit) {
                    if (Main.pApplet.frameCount%5==0) {
                        giant.locationY += speed;
                    }
                    giant.locationX++;

                }
                else {
                    if (Main.pApplet.frameCount%5==0) {
                        giant.locationY += speed;
                    }
                    giant.locationX--;
                }
            }



        }
    }

    public static void removeGiant() {
        for (int i = 0; i < Main.giants.size(); i++) {
            if (Main.giants.get(i).locationY > 550) {
                Main.giants.remove(i);
                Main.game=false;
                Main.lose=true;
                break;
            }
        }
    }


    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

}
