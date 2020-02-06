package io.serialize.saver;

import java.io.*;

public class Saver {

    public static void main(String[] args) {
        Saver saver = new Saver();
        saver.save();
        saver.load();
    }

    public void save() {
        Character elf = new Character("Elf", "Elf-warior", 300,
                new String[]{"Bow", "War Mace"});
        Character orc = new Character("Urukhai", "Orc-leader", 30,
                new String[]{"Mace", "Sword", "dagger"});
        Character human = new Character("Atilla", "Human", 19,
                new String[]{"katana", "smith"});
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("Character.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(elf);
            objectOutputStream.writeObject(orc);
            objectOutputStream.writeObject(human);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        Character elf = null;
        Character orc = null;
        Character human = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("Character.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            elf = (Character) objectInputStream.readObject();
            orc = (Character) objectInputStream.readObject();
            human = (Character) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(elf.name);
        System.out.println(orc.name);
        System.out.println(human.name);
    }

    public void stringToFile() {
        try {
            FileWriter fileWriter = new FileWriter("output.txt");
            fileWriter.write("Hello");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
