public class Sword {
    int damage;
    int dodge;

    public Sword(int damage, int dodge) {
        this.damage = damage;
        this.dodge = dodge;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public int smallDamageUp() {
        return (int) (Math.random() * 6) + 5;
    }

    public int dodgeUp() {
        return (int) (Math.random() * 6) + 1;
    }

    public int largeDamageUp() {
        return (int) (Math.random() * 10) + 12;
    }
}
