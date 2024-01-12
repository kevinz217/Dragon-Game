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


    public void clearRoom() {
        ROOMS_CLEARED++;
    }

}
