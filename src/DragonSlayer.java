import java.util.Scanner;
public class DragonSlayer {

    private static final Scanner SCANNER = new Scanner(System.in);
    private int highestScore = 0;
    private Player player;
    private Room currentRoom;
    private boolean something;

    private boolean fightBool;

    public DragonSlayer() {
        this.player = null;
        currentRoom = null;
        something = true;
        fightBool = true;
    }

    public void play() {
        createPlayer();
        while (Room.getRoomsCleared() != 5) {
            makeRoom();
            while (something) {
                if (fightBool) {
                    fightMenu();
                } else if (!fightBool) {
                    afterFightMenu();
                }
            }
        }
            calculateScore();
        askReplay();
    }

    public void createPlayer() {
        System.out.println("Welcome to Extremely Rudimentary Dragon Killing Game! (that is probably broken)");
        System.out.print("Type in your name! ");
        String name = SCANNER.nextLine().toLowerCase();
        this.player = new Player(name);
    }

    public void makeRoom() {
        if (Room.getRoomsCleared() == 0) {
            Room room = new Room("The Beginning");
            Dragon dragon1 = new Dragon(1);
            Dragon[] firstDragon = {dragon1};
            room.changeDragons(firstDragon);
            currentRoom = room;
        } else if (Room.getRoomsCleared() == 1) {
            currentRoom = new Room("The Throne Room");
        } else if (Room.getRoomsCleared() == 2) {
            currentRoom = new Room("The Dungeon");
        } else if (Room.getRoomsCleared() == 3) {
            currentRoom = new Room("The Hollow Halls");
        } else if (Room.getRoomsCleared() == 4) {
            Room room = new Room("The Throne Room");
            Dragon dragonFinal = new Dragon(4);
            Dragon[] lastDragon = {dragonFinal};
            room.changeDragons(lastDragon);
            currentRoom = room;
        }
        System.out.println("You are entering " + Colors.PURPLE + currentRoom.getName() + Colors.RESET);
    }

    public void fightMenu() {
        String choice = "";

        while (!choice.equals("l")) {
            System.out.println();
            currentRoom.currentDragon().dragonInfo();
            System.out.println("~~~~~~~~~~~~~");
            System.out.println("(C)heck your stats");
            System.out.println("(F)ight back and attack!");
            System.out.println("(S)earch the room!");
            System.out.println("(M)ove on to the next room.");
            System.out.println("(H)eal with a pot!");
            System.out.println("Give up and (L)eave.");
            System.out.println();
            System.out.print("What's your next move? ");
            choice = SCANNER.nextLine().toLowerCase();
            processChoice1(choice);
        }
    }
    public void afterFightMenu() {
        String choice = "";

        while (!choice.equals("l")) {
            System.out.println();
            System.out.println("~~~~~~~~~~~~~");
            System.out.println("(C)heck your stats");
            System.out.println("(S)earch the room!");
            System.out.println("(M)ove on to the next room.");
            System.out.println("(H)eal with a pot!");
            System.out.println("(U)pgrade your sword!");
            System.out.println("Give up and (L)eave.");
            System.out.println();
            System.out.print("What's your next move? ");
            choice = SCANNER.nextLine().toLowerCase();
            processChoice2(choice);
        }
    }

    // processes the attacking phase
    public void processChoice1(String choice) {
        Dragon dragon = currentRoom.currentDragon();
        if (choice.equals("c")) {
        player.playerInfo();
        } else if (choice.equals("f")) {
            int damage = player.attack();
            System.out.println("You deal " + Colors.RED + damage + Colors.RESET + " to the dragon!");
            dragon.takeDamage(damage);
        } else if (choice.equals("s")) {
            System.out.println("You cannot search here in combat!");
        } else if (choice.equals("m")) {
            System.out.println("You can't do that there are still dragons!");
        } else if (choice.equals("h")) {
            player.usePot();
        } else if (choice.equals("l")) {
            System.out.println("You leave and give up. Goodbye dragon slayer.");
            System.exit(0);
        } else {
            System.out.println("That's an invalid option! Try again.");
        }

        if (dragon.isAlive()) {
            int takeDamage = dragon.attack();
            System.out.println("You take " + Colors.RED + takeDamage + Colors.RESET + " damage!");
        } else {
            player.gainGold((dragon.getLevel() * 3) + 7);
            currentRoom.nextDragon();
            if (currentRoom.checkAllDragons()) {
                fightBool = false;
            }
        }
    }

    //processes the post-battle phase
    public void processChoice2(String choice) {
        Dragon dragon = currentRoom.currentDragon();
        if (choice.equals("c")) {
            player.playerInfo();
        } else if (choice.equals("s")) {
            currentRoom.searchRoom();
        } else if (choice.equals("m")) {
            something = false;
        } else if (choice.equals("h")) {
            player.usePot();
        } else if (choice.equals("u")) {
            player.upgrade();
        } else if (choice.equals("l")) {
            System.out.println("You leave and give up. Goodbye dragon slayer.");
            System.exit(0);
        } else {
            System.out.println("That's an invalid option! Try again.");
        }
    }


    public void calculateScore() {
        int score = 0;

        score += (player.getGold() * 10);
        System.out.println("Score + " + Colors.GREEN + score + Colors.RESET + " (from gold)");
        score += (Room.getTotalDragonsKilled() * 20);
        System.out.println("Score + " + Colors.GREEN + (Room.getTotalDragonsKilled() * 20) + Colors.RESET + " (from total dragons killed)");

        if (player.getHealthPotStatus()) {
            score += 50;
            System.out.println("Score + " + Colors.GREEN + 50 + Colors.RESET + " (from leftover pot)");
        }

        System.out.println("You got a score of " + Colors.GREEN + score + Colors.RESET + "!");

        if (score > highestScore) {
            highestScore = score;
            System.out.println("That's a new high score!");
        } else {
            System.out.println("Your highest score was " + Colors.GREEN + highestScore + Colors.RESET + "!");
        }
    }

    public void askReplay() {
        String ans = "";

        while (!ans.equals("y") || !ans.equals("n"))
        System.out.println("Would you like to play again? (y/n)");
        ans = SCANNER.nextLine().toLowerCase();
        if (ans.equals("y")) {
            play();
        } else if (ans.equals("n")) {
            System.out.println("Goodbye then!");
        } else {
            System.out.println("Invalid input try again!");
        }
    }
}
