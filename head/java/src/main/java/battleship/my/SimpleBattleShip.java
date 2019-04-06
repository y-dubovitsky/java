package battleship.my;

import java.util.Scanner;

/**
 * This is main method of game;
 */
public class SimpleBattleShip {

    private Area area;

    private Ship ship;

    // hit count
    private int count = 0;

    public SimpleBattleShip(Area area, Ship ship) {
        this.area = area;
        this.ship = ship;
    }

    /**
     * Place ship on area
     */
    private void placeShimOnArea() {
        int start = area.size.length - ship.size;
        for (int i = start; i < area.size.length; i = area.size.length) {
            area.size[i] = 1;
        }
    }

    /**
     * Simple Validation;
     */
    private boolean validationUserChoice(int choice) {
        boolean result = choice < this.area.size.length;
        return result;
    }

    /**
     * Getting user value from console
     * @return
     */
    private int getUserValue() {
        int result = 0;
        boolean check = false;
        while (!check) {
            System.out.println("Choose a point! And hit!");
            Scanner in = new Scanner(System.in);
            result = Integer.parseInt(in.next());
            // need to add check
            check = this.validationUserChoice(result);
        }
        return result;
    }

    /**
     * Game engine method
     */
    private void gameEngine() {
        while (this.count < ship.size) {
            int choice = this.getUserValue();
            if (area.size[choice] == 1) {
                System.out.println("You hit! Well done");
                this.count++;
            } else {
                System.out.println("You miss!");
            }
        }
    }

    public static void main(String[] args) {
        // Create battle area;
        Area area = new Area(10);

        // Create size of ship;
        Ship ship = new Ship(5);

        SimpleBattleShip s = new SimpleBattleShip(area, ship);

        // start game
        s.gameEngine();
    }
}
