import java.util.ArrayList;

public class DotCom {
    private ArrayList<String> locationsCells;
    private String name;

    public void setLocationsCells(ArrayList<String> locations) {
        this.locationsCells = locations;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String checkYourself(String userInput) {
        String result = "Miss!";
        int index = locationsCells.indexOf(userInput);

        // need modify
        return "return";
    }
}
