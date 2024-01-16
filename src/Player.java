public class Player {
    String name;
    int health;
    int gold;
    boolean healthPotStatus;
    Sword sword;

    public Player(String name) {
        this.name = name;
        health = 100;
        gold = 0;
        sword = new Sword(15, 20);
        healthPotStatus = false;
    }

    public int attack() {
        int damage = sword.getDamage();
        int rand1 = (int) (Math.random() * 2);
        int rand2 = (int) (Math.random() * 6);
        if (rand1 == 0) {
            damage += rand2;
        } else if (rand1 == 1) {
            damage -= rand2;
        }
        return damage;
    }

    public void takeDamage(int damage) {
        double chance = (double) Math.round(Math.random() * 100) / 100;
        if (chance > ((double) sword.getDodge() / 100)) {
            health -= damage;
            System.out.println("You took " + Colors.RED + damage + Colors.RESET + " damage!");
        } else {
            System.out.println(Colors.CYAN + "Lucky!" + Colors.RESET + " You dodged the attack!");
        }
    }

    public void usePot() {
        if (healthPotStatus) {
            health += 40;
            healthPotStatus = false;
            System.out.println("You healed for 35 health!");
        } else {
            System.out.println("You don't have a healing pot!");
        }
    }

    public void playerInfo() {
        String str = "";
        str += "Name: " + name;
        str += "\nHealth: " + health;
        str += "\nSword stats: " + sword.getDamage() + " damage" + ", " + sword.getDodge() + " dodge chance";
        str += "\nGold: " + gold;
        System.out.println(str);
    }

    public void gameOver() {
        System.out.println("Sorry player, you have died!");
        System.out.println("--------------------");
        System.out.println("|  ! GAME OVER !   |");
        System.out.println("--------------------");
        System.exit(0);
    }
}
