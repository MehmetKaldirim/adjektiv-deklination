package Homework;

import Adjektiv.Deklination.GetInput;
import Adjektiv.Deklination.ReadDatabase;
import Adjektiv.Deklination.WriteDatabase;

import java.io.IOException;
import java.util.ArrayList;

public class CheckAnswers {


    ReadDatabase rd = new ReadDatabase();
    WriteDatabase wr = new WriteDatabase();
    GetInput input = new GetInput();
    CreateHomework ch = new CreateHomework();

    String checkHomeworkAdr = wr.getRelativPathAdr("Check homework.txt");


    public CheckAnswers() throws IOException {
    }
    /**
     * @throws IOException
     * chose topic of homework iot answer
     */
    public void choseHomework() throws IOException {
        //write to homework to file
        //

        wr.creatFile(checkHomeworkAdr);

        ArrayList<String> nameOfTopic = rd.readFromFile(ch.homeworkAdr);

        if (findWord(nameOfTopic, "DEFINITE")) {
            resultOfDefiniteHomework();
        }

        if (findWord(nameOfTopic, "INDEFINITE")) {
            resultOdIndefiniteHomework();
        }

    }

    /**
     * @throws IOException read the answer of student from the files
     *                     check the answers
     *                     write to all result a new file
     */
    public void resultOfDefiniteHomework() throws IOException {

        /**
         read the user answers from the line after "="
         */
        String firstAnswer = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 2), 1, "=");
        String secondAnswer = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 4), 1, "=");
        String thirdAnswer = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 6), 1, "=");

        /**
         check the user answers
         and write the result
         */

        wr.writeStringToFile(checkHomeworkAdr, rd.readLineFromFile(ch.homeworkAdr, 1));
        if (firstAnswer.equals(answerDefiniteMaskulin())) {

            wr.writeStringToFile(checkHomeworkAdr, "Your Answer = " + firstAnswer +
                    "--> Your answer is correct. ");
        } else
            wr.writeStringToFile(checkHomeworkAdr, "Your Answer = " + firstAnswer +
                    "--> Your answer is false, " + "correct answer =" + answerDefiniteMaskulin());


        wr.writeStringToFile(checkHomeworkAdr, rd.readLineFromFile(ch.homeworkAdr, 3));
        if (secondAnswer.equals(answerDefiniteFemininin())) {
            wr.writeStringToFile(checkHomeworkAdr, "Your Answer = " + secondAnswer +
                    "--> Your answer is correct ");
        } else
            wr.writeStringToFile(checkHomeworkAdr, "Your Answer = " + secondAnswer +
                    "--> Your answer is false, " + "Correct answer = " + answerDefiniteFemininin());


        wr.writeStringToFile(checkHomeworkAdr, rd.readLineFromFile(ch.homeworkAdr, 5));
        if (thirdAnswer.equals(answerDefiniteNeutral())) {

            wr.writeStringToFile(checkHomeworkAdr, "Your Answer = " + thirdAnswer +
                    "--> Your answer is correct ");
        } else
            wr.writeStringToFile(checkHomeworkAdr, "Your Answer = " + thirdAnswer +
                    "--> Your answer is false, " + "Correct answer = " + answerDefiniteNeutral());
    }


    /**
     * @throws IOException read the answer of student from the files
     *                     check the answers
     *                     write to all result a new file
     */
    public void resultOdIndefiniteHomework() throws IOException {

        /**
         read the user answers
         */
        String firstAnswer = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 2), 1, "=");
        String secondAnswer = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 4), 1, "=");
        String thirdAnswer = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 6), 1, "=");

        /**
         check the user answers
         and write the result
         */
        wr.writeStringToFile(checkHomeworkAdr, rd.readLineFromFile(ch.homeworkAdr, 1));
        if (firstAnswer.equals(answerUndefiniteMaskulin())) {

            wr.writeStringToFile(checkHomeworkAdr, "Your Answer = " + firstAnswer +
                    "--> Your answer is correct ");
        } else
            wr.writeStringToFile(checkHomeworkAdr, "Your Answer = " + firstAnswer +
                    "--> Your answer is false, " + "Correct answer = " + answerUndefiniteMaskulin());

        wr.writeStringToFile(checkHomeworkAdr, rd.readLineFromFile(ch.homeworkAdr, 3));
        if (secondAnswer.equals(answerUndefiniteFemininin())) {

            wr.writeStringToFile(checkHomeworkAdr, "Your Answer = " + secondAnswer +
                    "--> Your answer is correct ");
        } else
            wr.writeStringToFile(checkHomeworkAdr, "Your Answer = " + secondAnswer +
                    "--> Your answer is false, " + "Correct answer = " + answerUndefiniteFemininin());


        wr.writeStringToFile(checkHomeworkAdr, rd.readLineFromFile(ch.homeworkAdr, 5));
        if (thirdAnswer.equals(answerUndefiniteNeutral())) {
            wr.writeStringToFile(checkHomeworkAdr, "Your Answer = " + thirdAnswer + "--> Your answer is correct ");
        } else

            wr.writeStringToFile(checkHomeworkAdr, "Your Answer = " + thirdAnswer +
                    "--> Your answer is false, " + "Correct answer = " + answerUndefiniteNeutral());
    }

    /**
     * read homework from file
     * find the answer
     * @return answer
     */
    public String answerDefiniteMaskulin() throws IOException {

        //answers the question for maskulin nouns ( for every case akkusativ,dativ, genetiv )


        String proposition = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 1), 1, "-");
        String adjektiv = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 1), 2, "-");
        String maskulinNoun = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 1), 3, "-");

        String answer = "";

        if (findWord(rd.readFromFile(ch.akkusativAdr), proposition) == true) {
            answer = proposition + " den " + adjektiv + "en " + maskulinNoun;
        } else if (findWord(rd.readFromFile(ch.dativAdr), proposition) == true) {
            answer = proposition + " dem " + adjektiv + "en " + maskulinNoun;
        } else if (findWord(rd.readFromFile(ch.genetivAdr), proposition) == true) {
            answer = proposition + " des " + adjektiv + "en " + maskulinNoun + "s";
        }

        return answer;
    }

    /**
     * read homework from file
     * find the answer
     * @return answer
     */
    public String answerUndefiniteMaskulin() throws IOException {

        //answers the question for maskulin nouns ( for every case akkusativ,dativ, genetiv )


        String proposition = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 1), 1, "-");
        String adjektiv = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 1), 2, "-");
        String maskulinNoun = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 1), 3, "-");

        String answer = "";
        if (findWord(rd.readFromFile(ch.akkusativAdr), proposition) == true) {
            answer = proposition + " einen " + adjektiv + "en " + maskulinNoun;
        } else if (findWord(rd.readFromFile(ch.dativAdr), proposition) == true) {
            answer = proposition + " einem " + adjektiv + "en " + maskulinNoun;
        } else if (findWord(rd.readFromFile(ch.genetivAdr), proposition) == true) {
            answer = proposition + " eines " + adjektiv + "en " + maskulinNoun + "s";
        }

        return answer;
    }

    /**
     * read homework from file
     * find the answer
     * @return answer
     */
    public String answerDefiniteFemininin() throws IOException {

        //answers question for feminin nouns ( for every case akkusativ,dativ, genetiv )


        String proposition = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 3), 1, "-");
        String adjektiv = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 3), 2, "-");
        String femininNoun = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 3), 3, "-");


        String answer = "";
        if (findWord(rd.readFromFile(ch.akkusativAdr), proposition) == true) {
            answer = proposition + " die " + adjektiv + "e " + femininNoun;
        } else if (findWord(rd.readFromFile(ch.dativAdr), proposition) == true) {
            answer = proposition + " der " + adjektiv + "en " + femininNoun;
        } else if (findWord(rd.readFromFile(ch.genetivAdr), proposition) == true) {
            answer = proposition + " der " + adjektiv + "en " + femininNoun;
        }

        return answer;
    }

    /**
     * read homework from file
     * find the answer
     * @return answer
     */
    public String answerUndefiniteFemininin() throws IOException {

        //answers question for feminin nouns ( for every case akkusativ,dativ, genetiv )


        String proposition = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 3), 1, "-");
        String adjektiv = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 3), 2, "-");
        String femininNoun = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 3), 3, "-");


        String answer = "";
        if (findWord(rd.readFromFile(ch.akkusativAdr), proposition) == true) {
            answer = proposition + " eine " + adjektiv + "e " + femininNoun;
        } else if (findWord(rd.readFromFile(ch.dativAdr), proposition) == true) {
            answer = proposition + " einer " + adjektiv + "en " + femininNoun;
        } else if (findWord(rd.readFromFile(ch.genetivAdr), proposition) == true) {
            answer = proposition + " einer " + adjektiv + "en " + femininNoun;
        }

        return answer;
    }


    /**
     * read homework from file
     * find the answer
     * @return answer
     */
    public String answerDefiniteNeutral() throws IOException {

        //answers the question  for neutral nouns ( for every case akkusativ,dativ, genetiv )

        String proposition = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 5), 1, "-");
        String adjektiv = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 5), 2, "-");
        String neutralNoun = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 5), 3, "-");


        String answer = "";
        if (findWord(rd.readFromFile(ch.akkusativAdr), proposition) == true) {
            answer = proposition + " das " + adjektiv + "e " + neutralNoun;
        } else if (findWord(rd.readFromFile(ch.dativAdr), proposition) == true) {
            answer = proposition + " dem " + adjektiv + "en " + neutralNoun;
        } else if (findWord(rd.readFromFile(ch.genetivAdr), proposition) == true) {
            answer = proposition + " des " + adjektiv + "en " + neutralNoun + "s";
        }

        return answer;
    }


    /**
     * read homework
     * find the answer
     * @return answer of neeural nouns
     */
    public String answerUndefiniteNeutral() throws IOException {

        //answers the question  for neutral nouns ( for every case akkusativ,dativ, genetiv )

        String proposition = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 5), 1, "-");
        String adjektiv = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 5), 2, "-");
        String neutralNoun = splitLineOfAnswers(takeLineofAnswers(ch.homeworkAdr, 5), 3, "-");


        String answer = "";
        if (findWord(rd.readFromFile(ch.akkusativAdr), proposition) == true) {
            answer = proposition + " ein " + adjektiv + "es " + neutralNoun;
        } else if (findWord(rd.readFromFile(ch.dativAdr), proposition) == true) {
            answer = proposition + " einem " + adjektiv + "en " + neutralNoun;
        } else if (findWord(rd.readFromFile(ch.genetivAdr), proposition) == true) {
            answer = proposition + " eines " + adjektiv + "en " + neutralNoun + "s";
        }

        return answer;
    }




    /**
     * @param pathAdress path adress of File
     * @param lineNumber indicate to line of file
     * @return it string in  LineNumber of File
     * @throws IOException
     */
    public String takeLineofAnswers(String pathAdress, int lineNumber) throws IOException {

        //read the line of answers
        //


        String lineOfAnswer = rd.readLineFromFile(pathAdress, lineNumber);
        if (lineOfAnswer.equals("Write your answer here="))
            lineOfAnswer = "Write your answer here= Theree is no answer";
        return lineOfAnswer;

    }


    /**
     * @param lineOfAnswer equal to line of file
     * @param i            it is point which line is lineOfAnswer
     * @param a            any kind of string to split line
     * @return part of string after split a without a space
     */

    public String splitLineOfAnswers(String lineOfAnswer, int i, String a) {

        String[] words = lineOfAnswer.split(a);
        String studentsAnswer = words[i];
        studentsAnswer = studentsAnswer.trim();

        return studentsAnswer;
    }


    public boolean findWord(ArrayList<String> values, String x) {
        // find a word in the array
        // iot creat homework and find answers

        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).equals(x)) {
                return true;
            }
        }

        return false;
    }
}