public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 64; i++) {
            Dragon da = new Dragon();
            Player okla = new Player("gab");
            System.out.println("hi hi Level : " + da.getLevel());
            System.out.println(da.getHealth());
            System.out.println("Daorp Glog test damage: " + da.attack());
            okla.takeDamage(da.attack());
        }
        DragonSlayer game = new DragonSlayer();
        game.play();
    }
}

