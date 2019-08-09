package battleship.book;

public class SimpleDotCom {
    int[] locationCells;
    int numberOfHits = 0;

    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }

    public String checkYourSelf(String userGuess) {
        int guess = Integer.parseInt(userGuess);
        String result = "Мимо";
        for (int cell : locationCells) {
            if (guess == cell) {
                System.out.println("Попал");
                numberOfHits++;
                break;
            }
            if (numberOfHits == locationCells.length) {
                result = "Потопил";
            }
        }
        System.out.println(result);
        return result;
    }
}
