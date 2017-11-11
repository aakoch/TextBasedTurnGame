package com.adamkoch.game;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by aakoch on 2017-11-11.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class QuestionReaderWriter {
private static final Logger LOGGER = LogManager.getLogger(QuestionReaderWriter.class);
    private static List<Question> questions;

    public static void main(String[] args) throws IOException {
new QuestionReaderWriter();
    }

    public QuestionReaderWriter() throws IOException {

        questions = readQuestions();
        for (Question question : questions) {
            LOGGER.debug("question = " + question);
        }
    }

    public static void write() throws IOException {

        Question question1 = new Question(1);
        Question question2 = new Question(2);
        question1.setPrompt("Would you like to play a game?");
        question1.setChoice1("Yes");
        question1.setChoice2("No");
        question1.setChoice1Response("Great!");
        question1.setChoice2Response("Awwww");
        question1.setChoice1Next(question2);
        question1.setChoice2Next(Question.END);

        question2.setPrompt("You are at a fork in the road. Do you go left or right?");
        question2.setChoice1("Left");
        question2.setChoice2("Right");
        question2.setChoice1Response("You fall off a cliff and die!");
        question2.setChoice2Response("It is a dead end");
        question2.setChoice1Next(Question.END);
        question2.setChoice2Next(Question.END);

        final List<String> lines = getLines(question1);
        lines.addAll(getLines(question2));
        writeQuestion(lines);
    }

    public static void writeQuestion(List<String> lines) throws IOException {
        FileUtils.writeLines(new File("question.txt"), lines);
    }

    private static List<String> getLines(Question question) {
        final List<String> lines = new ArrayList<>();

        lines.add(question.getId());
        lines.add("\t" + question.getPrompt());
        lines.add("\t" + question.getChoice1());
        lines.add("\t" + question.getChoice1Response());
        lines.add("\t" + question.getChoice1Next().getId());
        lines.add("\t" + question.getChoice2());
        lines.add("\t" + question.getChoice2Response());
        lines.add("\t" + question.getChoice2Next().getId());
        return lines;
    }

    public static List<Question> readQuestions() throws IOException {

        final List<String> lines = FileUtils.readLines(new File("question.txt"));

        int i = 0;
        List<Question> list = new ArrayList<>();

        while(i < lines.size()) {
            Question question = new Question(Integer.parseInt(lines.get(i++)));
            question.setPrompt(lines.get(i++).trim());

            question.setChoice1(lines.get(i++).trim());
            question.setChoice1Response(lines.get(i++).trim());
            question.setChoice1NextId(Integer.parseInt(lines.get(i++).trim()));
            question.setChoice2(lines.get(i++).trim());
            question.setChoice2Response(lines.get(i++).trim());
            question.setChoice2NextId(Integer.parseInt(lines.get(i++).trim()));
            list.add(question);
        }


        return list;
    }

    public static Question lookupQuestion(int id) {
        if (id <= 0) {
            return Question.END;
        }
        return questions.get(id - 1);
    }
}
