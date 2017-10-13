package lsg.characters;

public class Monster extends Character {


    private static int INSTANCES_COUNT = 0;


    public Monster() {

        this("Monster_" + INSTANCES_COUNT);
        INSTANCES_COUNT++;

    }

    public Monster(String name) {

        super(name);
        INSTANCES_COUNT++;
        this.setLife(10);
        this.setMaxLife(10);
        this.setStamina(10);
        this.setMaxStamina(10);



    }


}
