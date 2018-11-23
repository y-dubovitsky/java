package main.java.enums12.page325;

import java.util.Random;

enum Answers {
    No, Yes, Maybe, Later, Soon, Never;
}

public class Question {
    Random random = new Random();
    protected Answers ask() {
        int prob = (int) (100 * random.nextDouble());
        if (prob < 15)
            return Answers.Never;
        if (prob < 30)
            return Answers.Maybe;
        if (prob < 60)
            return Answers.Soon;
        else
            return Answers.No;
    }
}

class AskMe {
    static void answer(Answers result) {
        switch(result) {
            case No:
                System.out.println("Нет");
            case Soon:
                System.out.println("Скоро");
            case Never:
                System.out.println("Никогда");
            default:
                System.out.println("Потом допишу");
        }
    }
}

class Demo {
    public static void main(String[] args) {
        Question question = new Question();
        AskMe.answer(question.ask());
        AskMe.answer(question.ask());
        AskMe.answer(question.ask());
        AskMe.answer(question.ask());
    }
}


