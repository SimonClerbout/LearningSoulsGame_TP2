package lsg.characters;

import lsg.helpers.Dice;
import lsg.weapons.Weapon;

/**
 * Created by sclerbou on 12/10/17.
 */
public class Character {

    private String name;
    private int life, maxLife, stamina, maxStamina;
    private Dice dice;
    private Weapon weapon;

    public String getName() {

        return name;

    }

    protected void setName(String name) {

        this.name = name;

    }

    public int getLife() {

        return life;

    }

    protected void setLife(int life) {

        this.life = life;

    }

    public int getMaxLife() {
        return maxLife;
    }

    protected void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getStamina() {
        return stamina;
    }

    protected void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    protected void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }

    public Weapon getWeapon(){

        return weapon;

    }

    public void setWeapon(Weapon w){

        this.weapon = w;

    }

    public Character(){

        name = "";
        life = 0;
        maxLife = 0;
        stamina = 0;
        maxStamina = 0;
        dice = new Dice(101);

    }

    public Character(String name){
        this.setName(name);
        dice = new Dice(101);

    }

    public void printStats(){

        System.out.println(this.toString());

    }

    public boolean isAlive(){

        return this.getLife()>0;


    }

    private int attackWith(Weapon weapon){
        int damage;

        if(weapon.isBroken()){

            damage = 0;

        }
        else{

            int accurate = dice.roll();
            weapon.use();
            /* différence entre l'attaque max et l'attaque min */
            int diff = weapon.getMaxDamage() - weapon.getMinDamage();
            damage = (int)(weapon.getMinDamage()+(accurate*diff/100.0));
            /* différence entre le stamina du personnage et le coup engendré par l'attaque*/

            /* conséquence s'appliquant si le personnage n'a pas assez de stamina pour lancer l'attaque. */
            if(this.getStamina() < weapon.getStamCost()){

                damage = damage*this.getStamina()/weapon.getStamCost();
                this.setStamina(0);/* sa stamina tombe donc à 0*/

            }else{

                this.setStamina(this.getStamina() - weapon.getStamCost());

            }

        }

        return damage;

    }

    public int attack(){

        return this.attackWith(weapon);

    }

    public int getHitWith(int value){

        int health = (this.life > value) ? value : life;
        life = life - health;
        return health;

    }

    @Override
    public String toString() {
        String alive = (this.isAlive())? "(ALIVE)" : "(DEAD)";
        return (String.format("%-20s %-20s LIFE:%-10s STAMINA:%-10s",("[ "+getClass().getSimpleName()+" ]"), getName(), String.format("%5d",life), String.format("%5d",stamina)) + alive );
        /*return ("[ characters.Hero ]" + name + "LIFE: " + life + "STAMINA: " + stamina + ((this.isAlive())? "(ALIVE)" : "(DEAD)"));*/
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

}
