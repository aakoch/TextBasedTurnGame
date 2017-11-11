package com.adamkoch.game;

/**
 * <p>Created by aakoch on 2017-11-11.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class Question {
    public static final Question END = new Question(0);
    static {
        END.setChoice1("The End");
        END.setChoice2("The End");
        END.setChoice1Response("The End");
        END.setChoice2Response("The End");
        END.setPrompt("The End");
        END.setChoice1("Restart");
        END.setChoice2("Restart");
        END.setChoice1NextId(1);
        END.setChoice2NextId(1);
    }

    private final int i;
    private String prompt;
    private String choice1;
    private String choice1Response;
    private String choice2;
    private String choice2Response;
    private Question choice1Next;
    private Question choice2Next;
    private int choice1NextId;
    private int choice2NextId;

    public Question(int i) {

        this.i = i;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice1Response(String choice1Response) {
        this.choice1Response = choice1Response;
    }

    public String getChoice1Response() {
        return choice1Response;
    }

    public void setChoice2Response(String choice2Response) {
        this.choice2Response = choice2Response;
    }

    public String getChoice2Response() {
        return choice2Response;
    }

    public void setChoice1Next(Question choice1Next) {
        this.choice1Next = choice1Next;
    }

    public Question getChoice1Next() {
        if (choice1Next == null) {
            choice1Next = QuestionReaderWriter.lookupQuestion(choice1NextId);
        }
        return choice1Next;
    }

    public void setChoice2Next(Question choice2Next) {
        this.choice2Next = choice2Next;
    }

    public Question getChoice2Next() {
        if (choice2Next == null) {
            choice2Next = QuestionReaderWriter.lookupQuestion(choice2NextId);
        }
        return choice2Next;
    }

    public String getId() {

        return String.valueOf(i);
    }

    public void setChoice1NextId(int choice1NextId) {
        this.choice1NextId = choice1NextId;
    }

    public int getChoice1NextId() {
        return choice1NextId;
    }

    public void setChoice2NextId(int choice2NextId) {
        this.choice2NextId = choice2NextId;
    }

    public int getChoice2NextId() {
        return choice2NextId;
    }

    @Override
    public String toString() {
        return "Question{" +
                "i=" + i +
                ", prompt='" + prompt + '\'' +
                ", choice1='" + choice1 + '\'' +
                ", choice1Response='" + choice1Response + '\'' +
                ", choice2='" + choice2 + '\'' +
                ", choice2Response='" + choice2Response + '\'' +
                ", choice1Next=" + choice1Next +
                ", choice2Next=" + choice2Next +
                ", choice1NextId=" + choice1NextId +
                ", choice2NextId=" + choice2NextId +
                '}';
    }
}
