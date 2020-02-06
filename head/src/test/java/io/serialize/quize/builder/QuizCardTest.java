package io.serialize.quize.builder;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuizCardTest {

    QuizCard quizCard;

    @BeforeEach
    void init() {
        quizCard = new QuizCard("answers.txt");
    }

    @Test
    void getAnswer() {
        //TODO Метод возвращает случайную фразу, так что как тут проверить нужно подумать.
        Assert.assertEquals("Information:java: Errors occurred while compiling module 'other'",
                quizCard.getAnswer());
    }
}