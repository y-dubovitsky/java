package io.serialize.quize.player;

/**
 * Simple flashCard
 */
public class QuizeCard {

    private String answer;
    private String question;

    public QuizeCard(String answer, String question) {
        this.answer = answer;
        this.question = question;
    }


    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }
}
