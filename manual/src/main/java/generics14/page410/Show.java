package main.java.generics14.page410;

class Show<T extends Two> {
    T[] coords;

    Show(T[] o) {
        coords = o;
    }

    void showXY(Show<? extends Two> show) {
        for (int i = 0; i < show.coords.length; i++) {
            System.out.println(show.coords[i].x + " " + show.coords[i].y);
        }
    }

    void showXYZ(Show<? extends Three> show) {
        for (int i = 0; i < show.coords.length; i++) {
            System.out.println(show.coords[i].x + " " + show.coords[i].y + " " + show.coords[i].z);
        }
    }

    void showXYZT(Show<? extends Four> show) {
        for (int i = 0; i < show.coords.length; i++) {
            System.out.println(show.coords[i].x + " " + show.coords[i].y + " " + show.coords[i].z + " " + show.coords[i].t);
        }
    }

    /*
    Нужно разобраться с этим методом, а точнее с ? super подкласс
     */
    void showS(Show<? super Four> show) {
        for (int i = 0; i < show.coords.length; i++) {
            //System.out.println(show.coords[i].x + " " + show.coords[i].y + " " + show.coords[i].z);
        }
    }

    public static void main(String[] args) {
        Two[] twos = {
                new Two(1,2),
                new Two(4,5),
                new Two(4,5),
                new Two(4,5)
        };
        Three[] threes = {
                new Three(1, 2, 3),
                new Three(3, 5, 2),
                new Three(4, 135, 23)
        };
        Four[] four = {
                new Four(1,2,3,4),
                new Four(1,2,3,4),
                new Four(1,2,3,4),
                new Four(1,2,3,4),
        };
        Show<Two> twoShow = new Show<Two>(twos);
        Show<Three> threeShow = new Show<>(threes);
        Show<Four> fourShow = new Show<>(four);
        //
        Show<Four> fourShow1 = new Show<Four>(four);
        fourShow1.showS(fourShow);
    }
}

class Two {
    int x,y;
    Two(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Three extends Two {
    int z;
    Three(int x, int y, int z) {
        super(x,y);
        this.z = z;
    }
}

class Four extends Three {
    int t;
    Four(int x, int y, int z, int t) {
        super(x, y, z);
        this.t = t;
    }
}
