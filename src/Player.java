public class Player {
    private String name;
    private int health;
    private int gold;
    private boolean healthPotStatus;
    private Sword sword;

    public Player(String name) {
        this.name = name;
        health = 100;
        gold = 0;
        sword = new Sword(15, 25);
        healthPotStatus = false;
    }

    public int getGold() {
        return gold;
    }

    public boolean getHealthPotStatus() {
        return healthPotStatus;
    }

    public int attack() {
        // attacks will do 0-5 more or less damage
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

    public void gainGold(int goldGain) {
        System.out.println("You have gained " + Colors.YELLOW + goldGain + Colors.RESET + " gold!");
        gold += goldGain;
    }

    public void gainPot() {
        healthPotStatus = true;
    }


    public void takeDamage(int damage) {
        // calculates dodge chance and takes damage if the dodge does not happen
        double chance = (double) Math.round(Math.random() * 100) / 100;
        if (chance > ((double) sword.getDodge() / 100)) {
            health -= damage;
            System.out.println("You took " + Colors.RED + damage + Colors.RESET + " damage!");
            if (health <= 0) {
                gameOver();
            }
        } else {
            System.out.println(Colors.CYAN + "Lucky!" + Colors.RESET + " You dodged the attack!");
        }
    }

    public void usePot() {
        if (healthPotStatus) {
            int heal = (int) ((100 - health) / 1.5);
            health += heal;
            healthPotStatus = false;
            System.out.println("You healed for " + heal + " health!");
        } else {
            System.out.println("You don't have a healing pot!");
        }
    }

    public void upgrade() {
        if (gold >= 10) {
            gold -= 10;
            double chance = (double) Math.round(Math.random() * 100) / 100;
            // decides if the upgrade will be small or big
            if (chance < 0.66) {
                System.out.println("You got a small upgrade!");
                sword.smallDamageUp();
                sword.dodgeUp();
            } else {
                System.out.println("You got a large upgrade!");
                sword.largeDamageUp();
                sword.dodgeUp();
            }
        } else {
            System.out.println("You don't have enough gold! (requires 10)");
        }
    }

    public void heal() {
        if (gold >= 3) {
            gold -= 3;
            double chance = (double) Math.round(Math.random() * 100) / 100;
            // decides if the healing will be small or big
            if (chance < 0.66) {
                System.out.println("You healed a small amount! (+20)");
                health += 20;
            } else {
                System.out.println("You healed a large amount! (+40)");
                health += 40;
            }
        } else {
            System.out.println("You don't have enough gold! (requires 3)");
        }
    }

    public void playerInfo() {
        String str = "\n";
        str += "Name: " + name;
        str += "\nHealth: " + health;
        str += "\nSword stats: " + sword.getDamage() + " damage" + ", " + sword.getDodge() + " dodge chance";
        str += "\nGold: " + gold;
        str += "\nPotion status: " + healthPotStatus;
        System.out.println(str);
    }


    public void gameOver() {
        System.out.println("Sorry player, you have died!");
        System.out.println("--------------------");
        System.out.println("|  ! GAME OVER !   |");
        System.out.println("--------------------");
        System.out.println("Try again another time!");
        System.exit(0);
    }
}
