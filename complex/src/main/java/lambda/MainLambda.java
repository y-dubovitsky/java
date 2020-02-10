package lambda;

public class MainLambda {

    String[] strings = {"a", "b", "123", "A", "Hello", "d"};
    Player[] players = {new Player("Matthey", 12), new Player("Jam", 35), new Player("Viktor", 56),};

    public static void main(String[] args) {
        new Comparable<>() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }

    private class Player {
        private String name;
        private int age;

        public Player(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
