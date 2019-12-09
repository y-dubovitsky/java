package java_lessons.enums;

public enum LevelsEnum implements InterfaceForEnum{

    BEGGINER(1),
//    Тут мы можем только переопределять методы!
    PROFESSIONAL(2) {
        int i;

//        we cant do this!
//        LevelsEnum(int i) {
//            super(i);
//            this.i = i;
//        }

        private String value = "Something new value";

        public void doAction() {
            System.out.println("Hello PROFESSIONAL =)");
        }
    },
    EXPERT(3) {
        @Override
        public void interfaceMethod() {
            System.out.println("EXPERT FROM INTERFACE METHOD!");
        }
    };

    private String value = "Constant";
    private int i;

    LevelsEnum(int i) {
        this.i = i;
    }

    /**
     * Overrided method from interface;
     */
    @Override
    public void interfaceMethod() {
        System.out.println("Method was Overriding!");
        // use Folk Enum!
        Folk bong = Folk.Bong;
        System.out.println(bong.name());
    }

    public void doAction() {
        System.out.println("Hello =)");
    }

    public static void main(String[] args) {
        LevelsEnum levelsEnum = LevelsEnum.BEGGINER;
        System.out.println(levelsEnum.name() + " " + levelsEnum.value);
        //
        LevelsEnum levelsEnum1 = LevelsEnum.PROFESSIONAL;
        levelsEnum1.doAction();
    }
}
