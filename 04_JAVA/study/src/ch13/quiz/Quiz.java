package ch13.quiz;

public class Quiz extends Content{
    private String answer;

    public Quiz(String question, String answer) {
        super(question);
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
