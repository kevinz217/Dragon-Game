public class Dragon {
    int health;
    int level;
    boolean alive;

    public Dragon() {
        level = (int) (Math.random() * 3)  + 1;
        health = ((int) (Math.random() * 70) + 150) * level;
        alive = true;
    }

    public Dragon(int level) {
        if (level == 1) {
            health = 130;
            alive = true;
        }
        if (level == 4) {
            health = 1000;
            alive = true;
        }
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAlive(boolean bool) {
        alive = bool;
    }


    public int attack() {
        return level * (int) ((Math.random() * 9) + 1);
    }

}
