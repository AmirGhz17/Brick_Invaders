import processing.core.PApplet;
import java.util.ArrayList;

public class Main extends PApplet {

    static int locationY = 100;

    static int gianthit=0;
    static int speed = 3;
    static int bulletspeed=5;
    static PApplet pApplet;
    static int no = 0;
    static int hit = 0;
    static int highscore = 0;
    static int removed = 0;
    static int score = 0;
    static int passed = 5;

    public static ArrayList<Chicken> chickens = new ArrayList<>();
    public static ArrayList<Star> stars = new ArrayList<>();
    public static ArrayList<Heart> hearts = new ArrayList<>();
    public static ArrayList<Giant> giants = new ArrayList<>();
    public static ArrayList<Bullet> bullets = new ArrayList<>();

    DataBase dataBase= new DataBase();

    public static void main(String[] args) {

        PApplet.main("Main", args);

    }

    Gun gun;

    public void setup() {
        DataBase.selectHighScore();
        pApplet = this;
        gun = new Gun();
        Star.makeStars();
        Heart.makeHearts();
        Giant.makeGiants();
        Star.Starface();
        Heart.Heartface();
        Bullet.Bulletface();
        Chicken.chickenface();
        Giant.Giantface();
        Chicken.makeChickens();
    }

    public void settings() {
        size(700, 550);
    }

    public static boolean start = true;
    public static boolean lose = false;
    public static boolean game = false;
    public static boolean win = false;
    public static boolean giant = false;

    public void draw() {
        if (start) {

            Background.loadBackgrounds();
            Background.showBackground();

            fill(255);

            textSize(30);
            text("high score = " + highscore, 250, 200);
            if (mouseX < 200 && mouseX > 150 && mouseY > 250 && mouseY < 300) {
                fill(0, 0, 255);
            } else {
                fill(255);
            }
            textSize(50);
            text("play", 150, 300);
            if (mouseX < 550 && mouseX > 500 && mouseY > 250 && mouseY < 300) {
                fill(255, 0, 0);
            } else {
                fill(255);
            }
            text("exit", 500, 300);
        }

        if (game) {

            Background.loadBackgrounds1();
            Background.showBackground1();


            fill(255);
            text("lives =" + gun.lives, 10, 50);
            fill(255);
            text("score = " + (score + passed), 450, 50);
            Chicken.showChicken(chickens);
            Chicken.moveChicken(speed);
            Star.showStar(stars);
            Star.moveStar(speed);
            Heart.showHeart(hearts);
            Heart.moveHeart(speed);
            Bullet.showBullet();
            Bullet.moveBullet(bulletspeed);

            if (score > 400) {
                speed = 10;
            } else if (score > 300) {
                speed = 9;
            } else if (score > 200) {
                speed = 8;
            } else if (score > 120) {
                speed = 7;
            } else if (score > 90) {
                speed = 6;
            } else if (score > 60) {
                speed = 5;
            } else if (score > 30) {
                speed = 4;
            }

            fill(0, 0, 255);
            rect(mouseX, 650, gun.width, gun.width);
            Gun.gunface();
            Gun.showGun();
            gun.passed();
            gun.lose_for_chickens();
            gun.lose_for_giant();
            gun.heart();
            gun.star();

            Bullet.remove_Bullet_and_chicken();
            Chicken.removeChicken();
            Giant.removeGiant();
            Bullet.removeBullet();

            System.out.println("stars:" + stars.size());

            if (gun.lives < 1) {

                DataBase.AddHighScore(score);

                game = false;
                lose = true;

            }

            if (chickens.size() == 0) {

                giant=true;

            }

            System.out.println("passed:" + passed);
            System.out.println("removed:" + removed);
            System.out.println("hit:" + hit);

            if (giant){
                Giant.showGiant(giants);
                Giant.moveGiant(1);
                gun.lose_for_giant();
                Bullet.remove_Bullet_and_giant();

            }

        }

        if (lose) {

            Background.loadBackgrounds3();
            Background.showBackground3();

            textSize(30);
            fill(255);
            text("score = " + (score + passed), 300, 400);
            textSize(60);
            fill(255);
            text("):G A M E  O V E R:(", 125, 200);
            textSize(50);

            if (mouseX < 300 && mouseX > 150 && mouseY > 250 && mouseY < 300) {
                fill(0, 0, 255);
            } else {
                fill(255);
            }
            text("replay", 150, 300);
            if (mouseX < 550 && mouseX > 500 && mouseY > 250 && mouseY < 300) {
                fill(255, 0, 0);
            } else {
                fill(255);
            }
            text("exit", 500, 300);
        }
        if (win) {

            Background.loadBackgrounds2();
            Background.showBackground2();

            textSize(30);
            fill(255);
            text("score = " + (score + passed), 300, 400);

            textSize(60);
            fill(255);
            text("(:Y O U  W I N:) ", 200, 200);

            textSize(50);

            if (mouseX < 300 && mouseX > 150 && mouseY > 250 && mouseY < 300) {
                fill(0, 0, 255);
            } else {
                fill(255);
            }
            text("replay", 150, 300);
            if (mouseX < 550 && mouseX > 500 && mouseY > 250 && mouseY < 300) {
                fill(0, 0, 255);
            } else {
                fill(255);
            }
            text("exit", 500, 300);
        }
    }

        @Override
        public void mousePressed() {
            if(start){
                if(mouseX<200 && mouseX>150 && mouseY>250 && mouseY<300){
                    start = false;
                    game = true;
                }
                if(mouseX<550 && mouseX>500 && mouseY>250 && mouseY<300){
                    exit();
                }
            }
            if (game){
                Bullet.makeBullet();
            }


            if(lose){
                if(mouseX<300 && mouseX>150 && mouseY>250 && mouseY<300){
                    lose = false;
                    giant=false;
                    hit=0;
                    speed=3;
                    score=0;
                    removed =0;
                    no =0;
                    passed=0;
                    chickens = new ArrayList<>();
                    stars = new ArrayList<>();
                    hearts = new ArrayList<>();
                    giants=new ArrayList<>();
                    bullets=new ArrayList<>();
                    Chicken.speedY=-100;
                    Heart.speedY=-1000;
                    Star.speedY=-300;
                    Chicken.makeChickens();
                    Star.makeStars();
                    Heart.makeHearts();
                    Giant.makeGiants();
                    Bullet.makeBullet();
                    gun = new Gun();
                    game = true;

                }
                if(mouseX<550 && mouseX>500 && mouseY>250 && mouseY<300){
                    exit();
                }
            }
            if(win){
                if(mouseX<300 && mouseX>150 && mouseY>250 && mouseY<300){
                    win = false;
                    giant=false;
                    hit=0;
                    speed=3;
                    removed =0;
                    no =0;
                    score=0;
                    passed=0;
                    chickens = new ArrayList<>();
                    stars = new ArrayList<>();
                    hearts = new ArrayList<>();
                    giants=new ArrayList<>();
                    bullets=new ArrayList<>();
                    Heart.speedY=-1000;
                    Star.speedY=-300;
                    Chicken.speedY=-100;
                    Chicken.makeChickens();
                    Star.makeStars();
                    Heart.makeHearts();
                    Giant.makeGiants();
                    Bullet.makeBullet();
                    gun = new Gun();
                    game = true;


                }
                if(mouseX<550 && mouseX>500 && mouseY>250 && mouseY<300){
                    exit();
                }
            }

        }
}