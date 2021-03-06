package lsg;

import lsg.characters.Hero;
import lsg.characters.Monster;
import lsg.weapons.Claw;
import lsg.weapons.ShotGun;
import lsg.weapons.Sword;

import java.util.Scanner;

public class LearningSoulsGame {

    private Hero hero = new Hero();
    private Monster monster = new Monster();
    private Scanner scanner = new Scanner(System.in);

    private void refresh(){

        hero.printStats();
        monster.printStats();

    }

    private void fight1v1(){

        this.refresh();

        boolean hturn = true;

        do{

            System.out.println("\nHit enter  key for next move >\n");
            String str = scanner.nextLine();

            if(hturn) {

                int damage = monster.getHitWith(hero.attack());
                System.out.println(hero.getName() + " attacks " + monster.getName() + " with " + hero.getWeapon() + " ATTACKS:" + damage + " | " + "DMG : " + damage);
                this.refresh();
                hturn = false;

            }else {

                int damage2 = hero.getHitWith(monster.attack());
                System.out.println(monster.getName() + " attacks " + hero.getName() + " with " + monster.getWeapon() + " ATTACKS:" + damage2 + " | " + "DMG : " + damage2);
                this.refresh();
                hturn = true;

            }

        }while(hero.isAlive() && monster.isAlive());

        if(hero.isAlive()){

            System.out.println("--- " + hero.getName() + " WINS !!! ---");

        }else{

            System.out.println("--- " + hero.getName() + " WINS !!! ---");

        }


    }

    private void init(){

        hero = new Hero();
        hero.setWeapon(new Sword());
        monster = new Monster();
        monster.setWeapon(new Claw());


    }

    private void play_v1(){

        this.init();
        this.fight1v1();

    }


    public static void main(String[] args) {

        LearningSoulsGame game = new LearningSoulsGame();

        /*for(int i = 0; i < 5; i++){

            h1.printStats();
            System.out.println("attacks with " + sg.toString() + " > " + h1.attack());
            System.out.println("attacks with " + s2.toString() + " > " + m1.attack());

        }*/


        game.play_v1();


    }

}
