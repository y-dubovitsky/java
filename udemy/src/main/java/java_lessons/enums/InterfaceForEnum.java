package java_lessons.enums;

public interface InterfaceForEnum {

    enum Folk{
        Song(1),
        Pong(2),
        Bong(3);

        private int i;

        Folk(int i) {
            this.i = i;
        }
    };

    void interfaceMethod();
}
