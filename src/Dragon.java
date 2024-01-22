public class Dragon {
    int health;
    int level;
    boolean alive;

    public Dragon() {
        level = (int) (Math.random() * 3) + 1;
        health = ((int) (Math.random() * 70) + 150) * level;
        alive = true;
    }

    public Dragon(int level) {
        //specific levels added for first and last dragon
        if (level == 1) {
            this.level = level;
            health = 130;
            alive = true;
        }
        if (level == 4) {
            this.level = level;
            health = 1000;
            alive = true;
        }
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return alive;
    }

    public void takeDamage(int health) {
        this.health -= health;
        if (0 >= this.health) {
            this.alive = false;
        }
    }

    public int attack() {
        return (int) ((level * 0.85)  * (int) ((Math.random() * 9) + 1));
    }

    public void dragonInfo() {
        String str = "Dragon Stats";
        str += "\n~~~~~~~~~~~~~";
        str += "\nLevel " + level;
        str += "\nHealth: " + health;
        str += "\nAlive status: " + alive;
        System.out.println(str);
    }

}
