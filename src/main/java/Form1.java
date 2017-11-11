import com.adamkoch.game.Question;
import com.adamkoch.game.QuestionReaderWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

/**
 * <p>Created by aakoch on 2017-11-10.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class Form1 {
    private static final Logger LOGGER = LogManager.getLogger(Form1.class);

    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JTextArea textArea1;
    private JScrollPane scrollPane;
    private JLabel goldLabel;
    private JLabel foodLabel;
    private Question question;

    public Form1(Question question) throws IOException {

        panel1.setSize(400, 400);
        scrollPane.setAutoscrolls(true);

        QuestionReaderWriter questionReaderWriter = new QuestionReaderWriter();


////        LinkedHashMap questions = null;
//        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        try {
////                mapper.writeValue(new File("questions.yaml"), question1);
//            question = mapper.readValue(new File("questions.yaml"), Question.class);
//        }
//        catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }


        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button1Pressed(e);
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button2Pressed(e);
            }
        });


        askQuestion(QuestionReaderWriter.lookupQuestion(1));

    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Dragon");
        frame.setSize(400, 400);
        final List<Question> questions = QuestionReaderWriter.readQuestions();


        Question question = questions.get(0);

        frame.setContentPane(new Form1(question).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void button2Pressed(ActionEvent e) {
//        LOGGER.debug("e = " + e);
        textArea1.setText(question.getChoice2Response());
        askQuestion(question.getChoice2Next());
    }

    private void button1Pressed(ActionEvent e) {
//        LOGGER.debug("e = " + e);
        textArea1.setText(question.getChoice1Response());
        askQuestion(question.getChoice1Next());
    }

    private void askQuestion(final Question question) {
        this.question = question;
//        if (question == Question.END) {
//            textArea1.append("\nThe End");
//            button1.setVisible(false);
//            button2.setVisible(false);
//        }
//        else {
            textArea1.append("\n" + question.getPrompt());
            button1.setText(question.getChoice1());
            button2.setText(question.getChoice2());

//            textArea1.addPropertyChangeListener(new PropertyChangeListener() {
//                public void propertyChange(PropertyChangeEvent evt) {
//                    LOGGER.debug("evt = " + evt);
//                }
//            });
//        }
    }

    private void removeListeners() {
        final ActionListener[] actionListeners = button1.getActionListeners();
        button1.removeActionListener(actionListeners[0]);
        final ActionListener[] actionListeners2 = button2.getActionListeners();
        button2.removeActionListener(actionListeners2[0]);
    }

    public void setData(Question data) {
    }

    public void getData(Question data) {
    }

    public boolean isModified(Question data) {
        return false;
    }
}
