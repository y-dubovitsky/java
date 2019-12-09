package java_lessons.enums;

/**
 * Главное запомни, что Enum является классом самого себя!
 * DaysEnum day = DaysEnum.FRIDAY;
 */
public enum DaysEnum {

    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    int number;
    int value;

    DaysEnum() {

    }

    DaysEnum(int i) {
        this.number = i;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        DaysEnum day = DaysEnum.FRIDAY;
        day.setValue(157);
        day.setNumber(35); // we can set number
        System.out.println(day + " " + day.getNumber() + " " + day.getValue());
        //
        DaysEnum day1 = DaysEnum.SATURDAY;
        day1.setValue(123);
        System.out.println(day1 + " " + day1.getNumber() + " " + day1.getValue());
    }
}


