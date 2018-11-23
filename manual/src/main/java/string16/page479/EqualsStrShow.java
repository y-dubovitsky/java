package main.java.string16.page479;

public class EqualsStrShow {
    public static void main(String[] args) {
        String strOne = new String("QWERTY");
        String strTwo = new String();
        String strThree = new String(strOne);
        String strFour = "QWERTY";
        String strFive = strOne;
        System.out.println("strOne.equals(strFive) ? " + strOne.equals(strFive));
        System.out.println("strOne == (strFive) ? " + (strOne == (strFive)));
        System.out.println("strOne == (strThree) ? " + (strOne == (strThree)));
        System.out.println("strOne.equals(strThree) ? " + strOne.equals(strThree));
    }
}
