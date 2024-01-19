public class Main {
    public static void main(String[] args) {
        Room llll = new Room("DARK  ENNES");
        System.out.println(llll.getDragons().length);
        llll.currentDragon().dragonInfo();
        llll.nextDragon();
        llll.currentDragon().dragonInfo();
        llll.currentDragon().setHealth(0);
        llll.currentDragon().dragonInfo();
        llll.searchRoom();
        llll.nextDragon();
        llll.currentDragon().dragonInfo();
        llll.currentDragon().setHealth(0);
        llll.currentDragon().dragonInfo();
        llll.nextDragon();
        llll.currentDragon().dragonInfo();
        llll.searchRoom();

        for (int i = 0; i < 64; i++) {
            System.out.println((int) (Math.random()*6));
            Dragon da = new Dragon(3);
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

