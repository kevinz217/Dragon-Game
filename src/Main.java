public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 64; i++) {
            System.out.println((int) (Math.random()*6));
        }

        DragonSlayer game = new DragonSlayer();
        game.play();
    }
}

