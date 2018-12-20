package Homework;


import Adjektiv.Deklination.GetInput;
import Adjektiv.Deklination.ReadDatabase;
import Adjektiv.Deklination.WriteDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class CreateHomework {


    ReadDatabase rd = new ReadDatabase();
    WriteDatabase wr = new WriteDatabase();
    GetInput input = new GetInput();

    String maskulinAdr = wr.getRelativPathAdr("DER.txt");
    String femininAdr = wr.getRelativPathAdr("DIE.txt");
    String neutralAdr = wr.getRelativPathAdr("DAS.txt");
    String adjektivAdr = wr.getRelativPathAdr("ADJ.txt");
    String akkusativAdr = wr.getRelativPathAdr("AKK.txt");
    String dativAdr = wr.getRelativPathAdr("DAT.txt");
    String genetivAdr = wr.getRelativPathAdr("GEN.txt");
    String homeworkAdr = wr.getRelativPathAdr("homework.txt");

    String randomWordMaskulin = getRandomWord(rd.readFromFile(maskulinAdr));
    String randomWordFeminin = getRandomWord(rd.readFromFile(femininAdr));
    String randomWordNeutral = getRandomWord(rd.readFromFile(neutralAdr));
    String adjektiv1 = getRandomWord(rd.readFromFile(adjektivAdr));
    String adjektiv2 = getRandomWord(rd.readFromFile(adjektivAdr));
    String adjektiv3 = getRandomWord(rd.readFromFile(adjektivAdr));
    String akkusativ = getRandomWord(rd.readFromFile(akkusativAdr));
    String dativ = getRandomWord(rd.readFromFile(dativAdr));
    String genetiv = getRandomWord(rd.readFromFile(genetivAdr));


    public CreateHomework() throws IOException {

    }


    /**
     * write homework lines for every cases with random words files*/

    public String maskulinDefiniteHomework() {

        //  creat a  simple homework  for maskulin
        return " 1. Question for definite artikel=  " + "-" +
                akkusativ + "-" + adjektiv1 + "-" + randomWordMaskulin;
    }

    public String femininDefiniteHomework() {

        //  creat a  simple homework  for maskulin
        return " 2. Question for definite artikel=  " + "-" +
                dativ + "-" + adjektiv2 + "-" + randomWordFeminin;
    }

    public String neutralDefiniteHomework() {

        //  creat a  simple homework  for maskulin
        return " 3. Question for definite artikel=  " + "-" +
                genetiv + "-" + adjektiv3 + "-" + randomWordNeutral;
    }

    public String maskulinIndefiniteHomework() {

        //  creat a  simple homework  for maskulin
        return " 1. Question for undefinite artikel=  " + "-" + dativ + "-" + adjektiv1 + "-" + randomWordMaskulin;
    }

    public String femininIndefiniteHomework() {

        //  creat a  simple homework  for maskulin
        return " 2. Question for undefinite artikel=  " + "-" + genetiv + "-" + adjektiv2 + "-" + randomWordFeminin;
    }

    public String neutralIndefiniteHomework() {

        //  creat a  simple homework  for maskulin
        return " 3. Question undefinite=  " + "-" + akkusativ + "-" + adjektiv3 + "-" + randomWordNeutral;
    }

    /**
     * write homework to files
     */
    public void createDefiniteHomework() throws IOException {
        //write to homework to file
        //

        wr.creatFile(homeworkAdr);
        String answer = "Write your answer here=";
        String homework = "HOMEWORK FOR DEFINITE ARTIKEL";
        wr.writeStringToFile(homeworkAdr, homework);

        homework = maskulinDefiniteHomework();
        wr.writeStringToFile(homeworkAdr, homework);
        wr.writeStringToFile(homeworkAdr, answer);

        homework = femininDefiniteHomework();
        wr.writeStringToFile(homeworkAdr, homework);
        wr.writeStringToFile(homeworkAdr, answer);

        homework = neutralDefiniteHomework();
        wr.writeStringToFile(homeworkAdr, homework);
        wr.writeStringToFile(homeworkAdr, answer);
    }

    /**
     * write homework to files
     */

    public void createIndefiniteHomework() throws IOException {
        //write to homework to file
        //

        wr.creatFile(homeworkAdr);
        String answer = "Write your answer here=";
        String homework = "HOMEWORK FOR INDEFINITE ARTIKEL";
        wr.writeStringToFile(homeworkAdr, homework);


        homework = maskulinIndefiniteHomework();
        wr.writeStringToFile(homeworkAdr, homework);
        wr.writeStringToFile(homeworkAdr, answer);

        homework = femininIndefiniteHomework();
        wr.writeStringToFile(homeworkAdr, homework);
        wr.writeStringToFile(homeworkAdr, answer);

        homework = neutralIndefiniteHomework();
        wr.writeStringToFile(homeworkAdr, homework);
        wr.writeStringToFile(homeworkAdr, answer);

    }

    /**
     * chose  the topics of homework
     */


    public void choseHomework() throws IOException {

        //  choose which file you wanna use
        //  and add data by using array


        System.out.println("\"Which topic do you wanna ? (definite,indefinite)");

        String topicOfData = input.askString();

        while (!topicOfData.equals("definite") && !topicOfData.equals("indefinite")) {

            System.out.println(" has to be written\n" +
                    "definite or indefinite" + " try again:");

            topicOfData = input.askString();

        }


        if (topicOfData.equals("definite")) {
            createDefiniteHomework();
        }

        if (topicOfData.equals("indefinite")) {
            createIndefiniteHomework();
        }


    }


    /**
     * @param words strings array
     * @return chose any word from the index of array
     */

    public String getRandomWord(ArrayList<String> words) {
        //  choose random words from array
        //  iot creat random homework

        Random rand = new Random();
        String randomWord = words.get(rand.nextInt(words.size()));
        return randomWord;
    }
}
