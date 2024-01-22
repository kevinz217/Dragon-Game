public class Sword {
    private int damage;
    private int dodge;

    public Sword(int damage, int dodge) {
        this.damage = damage;
        this.dodge = dodge;
    }

    public int getDamage() {
        return damage;
    }

    public int getDodge() {
        return dodge;
    }

    //upgrades for the sword
    public void smallDamageUp() {
        int dmgUp = (int) (Math.random() * 6) + 5;
        damage += dmgUp;
        System.out.println("Your sword does " + Colors.BLUE + dmgUp + Colors.RESET + " more damage!");
    }

    public void largeDamageUp() {
        int dmgUp = (int) (Math.random() * 10) + 12;
        damage += dmgUp;
        System.out.println("Your sword does " + Colors.BLUE + dmgUp + Colors.RESET + " more damage!");
    }

    public void dodgeUp() {
        int dodgeUp = (int) (Math.random() * 6) + 1;
        dodge += dodgeUp;
        System.out.println("Your sword has " + Colors.BLUE + dodgeUp + Colors.RESET + " more dodge!");
    }

}
