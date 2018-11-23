package main.java.string16.page477;

/*
Тут происходит преобразование строки в байты и наоборот!
 */

public class GetBytesShow {
    public static void main(String[] args) {
        String string = "HELLO WORLD";
        byte[] bytes = string.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        // А теперь выведем байты как строку;
        String strOut = new String(bytes);
        System.out.println(strOut);
    }
}

class ToCharArray {
    public static void main(String[] args) {
        String strIn = "Дратути!";
        char[] arrChar;
        arrChar = strIn.toCharArray();
        int i = 0;
        while (i < arrChar.length) {
            System.out.println(arrChar[i]);
            i++;
        }
        //Character[] character = (Character)arrChar;
    }
}

class EqualsShow {
    public static void main(String[] args) {
        String str = "QWERTY";
        switch (str) {
            case "QWERTY" :
                System.out.println(true);
                break;
            default:
                System.out.println(false);
        }
        // альтернатива
        System.out.println("QWERTY".equals(new String("QWERTY")));
    }
}

class RegionMatchesShow {
    public static void main(String[] args) {
        String strOne = new String("qwertyuiop[]");
        String strTwo = new String("qwertmvmspo0063mbdm;l");
        System.out.println(strOne.regionMatches(0, strTwo, 0, 8));
    }
}
