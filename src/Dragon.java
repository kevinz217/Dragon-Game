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
        level = 4;
        health = 1000;
        alive = true;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }
}
