package ch13.quiz;

public class Content {
    protected String question;

    public Content(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Content) {
            Content other = (Content) obj;
            if (this.question.equals(other.getQuestion())) {
                return true;
            }
        }
        return false;
    }
}
