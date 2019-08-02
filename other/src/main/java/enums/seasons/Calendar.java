package enums.seasons;

public class Calendar {

    Season season;

    public Calendar(Season season) {
        this.season = season;
    }

    public static void main(String[] args) {

        Calendar calendar = new Calendar(Season.AUTUMN);

        switch (calendar.season) {
            case SUMMER:
                System.out.println("Лето");
            case WINTER:
                System.out.println("Зима");
            case AUTUMN:
                System.out.println("Осень");
                //break;
            case SPRING:
                System.out.println("Весна");
        }
    }
}
