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
        health -= damage;
        System.out.println("You took " + damage + "!");
    }

    public void usePot() {
        if (healthPotStatus) {
            health += 35;
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

}
