public class Room {
    private static int NUM_ROOMS_CLEARED = 0;
    private static int TOTAL_DRAGONS_KILLED = 0;
    private boolean roomCleared;
    private final String name;
    private Dragon[] dragons;
    private boolean hasSearched;
    private Player player;

    public Room(String name) {
        this.name = name;
        hasSearched = false;
        roomCleared = false;
        // creates a array of dragons and assigns random dragons to that array
        int random = (int) (Math.random() * 3) + 1;
        dragons = new Dragon[random];
        for (int i = 0; i < random; i++) {
            dragons[i] = new Dragon();
        }
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public String getName() {
        return name;
    }

    public String getDragons() {
        if (dragons.length == 1) {
            return "one";
        }
        if (dragons.length == 2) {
            return "two";
        }
        if (dragons.length == 3) {
            return "three";
        }
        return null;
    }

    public Dragon currentDragon() {
        return dragons[0];
    }

    public void changeDragons(Dragon[] newDragons) {
        dragons = newDragons;
    }

    public static int getRoomsCleared() {
        return NUM_ROOMS_CLEARED;
    }

    public static int getTotalDragonsKilled() {
        return TOTAL_DRAGONS_KILLED;
    }

    public boolean isRoomClear() {
        return roomCleared;
    }


    public void searchRoom() {
        // checks if the player can search a room and searches it
        boolean canSearch = true;
        for (Dragon beast : dragons) {
            if (beast.alive) {
                canSearch = false;
                break;
            }
        }
        if (canSearch && !hasSearched) {
            double chance = (double) Math.round(Math.random() * 100) / 100;
            if (chance > 0.5) {
                System.out.println("You found a health pot!");
                if (player.getHealthPotStatus()) {
                    System.out.println("but... you already have one so you don't take it");
                } else {
                    player.gainPot();
                }
                hasSearched = true;
            } else {
                System.out.println("You found nothing...");
                hasSearched = true;
            }
        } else if(!canSearch) {
            System.out.println("You cannot search here in combat!");
        } else if (hasSearched) {
            System.out.println("You have already searched this room!");
        }
    }

    public void nextDragon() {
        // makes the array go to the next dragon by creating a new array
        if (!dragons[0].alive) {
            TOTAL_DRAGONS_KILLED++;
            if (dragons.length != 1) {
                Dragon[] temp = new Dragon[dragons.length - 1];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = dragons[i + 1];
                    System.out.println("Challenging next dragon!");
                }
                dragons = temp;
            } else if (dragons.length == 1 && !dragons[0].alive) {
                System.out.println(Colors.GREEN + "\nThere are no more dragons in this room!" + Colors.RESET);
                roomCleared = true;
                NUM_ROOMS_CLEARED++;
            }
        }
    }

    public boolean checkAllDragons() {
        for (Dragon dragon : dragons) {
            if (dragon.isAlive()) {
                // if one is alive it will be false
                return false;
            }
        }
        // all dragons are dead;
        roomCleared = true;
        return true;
    }

}
