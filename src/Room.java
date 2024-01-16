public class Room {
    private static int ROOMS_CLEARED = 0;
    String name;
    Dragon[] dragons;
    boolean hasSearched;

    public Room(String name) {
        this.name = name;
        hasSearched = false;
    }

    public void createDragons() {
        int random = (int) (Math.random() * 3) + 1;
        dragons = new Dragon[random];
        for (int i = 0; i < random; i++) {
            dragons[i] = new Dragon();
        }
    }

    public Dragon[] getDragons() {
        return dragons;
    }

    public void searchRoom() {
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
                hasSearched = true;
                System.out.println(Colors.RED + " ooooh you have to remember to add rh code for the pot oohh" + Colors.RESET);
            } else {
                System.out.println("You found nothing...");
            }
        } else if(!canSearch) {
            System.out.println("You cannot search here in combat!");
        } else if (hasSearched) {
            System.out.println("You have already searched this room!");
        }
    }


    public void clearRoom() {
        ROOMS_CLEARED++;
    }

}
