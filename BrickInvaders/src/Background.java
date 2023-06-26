import processing.core.PImage;

public class Background {

    public static PImage background;
    public static PImage background2;
    public static PImage background3;


    public static void loadBackgrounds () {


        background = Main.pApplet.loadImage("backgroundd.jpg");

    }
    public static void loadBackgrounds1 () {

        background2=Main.pApplet.loadImage("map1.jpg");

    }

    public static void loadBackgrounds2 () {

        background2=Main.pApplet.loadImage("backf.png");

    }
    public static void loadBackgrounds3 () {


        background3 = Main.pApplet.loadImage("backlose.png");

    }


    public static void showBackground() {
        Main.pApplet.image(background, 0, 0, 700, 600);
    }

    public static void showBackground1() {
        Main.pApplet.image(background2, 0, 0, 700, 600);
    }

    public static void showBackground2() {
        Main.pApplet.image(background2, 0, 0, 700, 600);
    }
    public static void showBackground3() {
        Main.pApplet.image(background3, 0, 0, 700, 600);
    }

}

