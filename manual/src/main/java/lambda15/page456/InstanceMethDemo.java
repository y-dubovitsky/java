package lambda15.page456;

interface MyFunc<T> {
    boolean func(T v1, T v2);
}

class HighTemp {
    private int hTemp;

    HighTemp(int ht) {
        hTemp = ht;
    }

    boolean sameTemp(HighTemp ht2) {
        return hTemp == ht2.hTemp;
    }

    boolean lessThanTemp(HighTemp ht2) {
        return  hTemp < ht2.hTemp;
    }
}

public class InstanceMethDemo {
    static  <T> int counter(T[] vals ,MyFunc<T> f, T v) {
        int count = 0;
        for (int i = 0; i < vals.length; i++) {
            if(f.func(vals[i], v)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int count;
        HighTemp[] weekDayHighs = { new HighTemp(56), new HighTemp(123), new HighTemp(53)};
        count = counter(weekDayHighs, HighTemp::lessThanTemp, new HighTemp(123));
        System.out.println("Дней когда макс температура была меньше 123 - " + count);
        count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(56));
        System.out.println("Дней когда макс температура была меньше 56 - " + count);
    }
}
