package lsg.characters;

public class Hero extends Character{


    public Hero(){

        this("Gregooninator");

    }

    public Hero(String name){

        super(name);
        this.setLife(100);
        this.setMaxLife(100);
        this.setStamina(50);
        this.setMaxStamina(50);

    }


}
