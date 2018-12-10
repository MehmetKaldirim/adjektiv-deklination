package Adjektiv.Deklination;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Homework {



    ReadDatabase rd= new ReadDatabase();
    WriteDatabase wr= new WriteDatabase();


    ///read data from file
   // and add them to array for creating homework and answering questions

    ArrayList<String> akkusativ= rd.akkusativ();
    ArrayList<String> dativ= rd.dativ();
    ArrayList<String> genetiv= rd.genetiv();

    //  random words iot creat homework

    String randomWordMaskulin= getRandomWord(rd.maskulinNouns());
    String randomWordFeminin= getRandomWord(rd.femininNouns());
    String randomWordNeutral= getRandomWord(rd.neutralNouns());
    String adjektiv1= getRandomWord(rd.adjektiv());
    String adjektiv2= getRandomWord(rd.adjektiv());
    String adjektiv3= getRandomWord(rd.adjektiv());
    String proposition1= getRandomWord(rd.proposition());
    String proposition2= getRandomWord(rd.proposition());
    String proposition3= getRandomWord(rd.proposition());


    public Homework()throws IOException {

    }


    public  String maskulinDefiniteHomework()  {

        //  creat a  simple homework  for maskulin
        return " 1. Question=  " + "-"+ proposition1+"-"+adjektiv1 +"-" +  randomWordMaskulin ;
    }

    public  String femininDefiniteHomework()  {

        //  creat a  simple homework  for maskulin
        return " 2. Question =  " + "-"+proposition2+"-"+adjektiv2 +"-" +  randomWordFeminin ;
    }

    public  String neutralDefiniteHomework()  {

        //  creat a  simple homework  for maskulin
        return " 3. Question =  " + "-"+proposition3+"-"+adjektiv3 +"-" +  randomWordNeutral ;
    }

    public  String maskulinUndefiniteHomework()  {

        //  creat a  simple homework  for maskulin
        return " 4. Question=  " + "-"+ proposition1+"-"+adjektiv1 +"-" +  randomWordMaskulin ;
    }

    public  String femininUndefiniteHomework()  {

        //  creat a  simple homework  for maskulin
        return " 5. Question =  " + "-"+proposition2+"-"+adjektiv2 +"-" +  randomWordFeminin ;
    }

    public  String neutralUndefiniteHomework()  {

        //  creat a  simple homework  for maskulin
        return " 6. Question =  " + "-"+proposition3+"-"+adjektiv3 +"-" +  randomWordNeutral ;
    }


    public void creatHomework() throws IOException{
         //write to homework to file
         //

        wr.creatFile(wr.homeworkAdr);
        String answer="Write your answer here=";

        String homework= maskulinDefiniteHomework();
        wr.writeStringToFile(wr.homeworkAdr,homework);
        wr.writeStringToFile(wr.homeworkAdr,answer);

        homework= femininDefiniteHomework();
        wr.writeStringToFile(wr.homeworkAdr,homework);
        wr.writeStringToFile(wr.homeworkAdr,answer);

        homework= neutralDefiniteHomework();
        wr.writeStringToFile(wr.homeworkAdr,homework);
        wr.writeStringToFile(wr.homeworkAdr,answer);

        homework= maskulinUndefiniteHomework();
        wr.writeStringToFile(wr.homeworkAdr,homework);
        wr.writeStringToFile(wr.homeworkAdr,answer);

        homework= femininUndefiniteHomework();
        wr.writeStringToFile(wr.homeworkAdr,homework);
        wr.writeStringToFile(wr.homeworkAdr,answer);

        homework= neutralUndefiniteHomework();
        wr.writeStringToFile(wr.homeworkAdr,homework);
        wr.writeStringToFile(wr.homeworkAdr,answer);



    }


    public String answerDefiniteMaskulin() throws IOException {

        //answers the question for maskulin nouns ( for every case akkusativ,dativ, genetiv )


        String proposition=splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,0),1,"-")  ;
        String adjektiv=splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,0),2,"-");
        String maskulinNoun=splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,0),3,"-");

        String answer = "";
        if (findWord(akkusativ, proposition) == true) {
            answer = proposition + " den " + adjektiv + "en " + maskulinNoun;
        } else if (findWord(dativ, proposition) == true) {
            answer = proposition + " dem " + adjektiv + "en " + maskulinNoun;
        } else if (findWord(genetiv, proposition) == true) {
            answer = proposition + " des " + adjektiv + "en " + maskulinNoun + "s";
        } else {
           // System.out.println("This proposition is not database, ask teacher");

        }

        return answer;
    }

    public String answerUndefiniteMaskulin() throws IOException {

        //answers the question for maskulin nouns ( for every case akkusativ,dativ, genetiv )


        String proposition=splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,6),1,"-")  ;
        String adjektiv=splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,6),2,"-");
        String maskulinNoun=splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,6),3,"-");

        String answer = "";
        if (findWord(akkusativ, proposition) == true) {
            answer = proposition + " einen " + adjektiv + "en " + maskulinNoun;
        } else if (findWord(dativ, proposition) == true) {
            answer = proposition + " einem " + adjektiv + "en " + maskulinNoun;
        } else if (findWord(genetiv, proposition) == true) {
            answer = proposition + " eines " + adjektiv + "en " + maskulinNoun + "s";
        } else {
            // System.out.println("This proposition is not database, ask teacher");

        }

        return answer;
    }




    public String answerDefiniteFemininin() throws IOException {

        //answers question for feminin nouns ( for every case akkusativ,dativ, genetiv )


        String proposition=splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,2),1,"-")  ;
        String adjektiv=splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,2),2,"-");
        String femininNoun=splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,2),3,"-");


        String answer = "";
        if (findWord(akkusativ, proposition) == true) {
            answer = proposition + " die " + adjektiv + "e " + femininNoun;
        } else if (findWord(dativ, proposition) == true) {
            answer = proposition + " der " + adjektiv + "en " + femininNoun;
        } else if (findWord(genetiv, proposition) == true) {
            answer = proposition + " der " + adjektiv + "en " + femininNoun;
        } else {


        }

        return answer;
    }

    public String answerUndefiniteFemininin() throws IOException {

        //answers question for feminin nouns ( for every case akkusativ,dativ, genetiv )


        String proposition=splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,8),1,"-")  ;
        String adjektiv=splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,8),2,"-");
        String femininNoun=splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,8),3,"-");


        String answer = "";
        if (findWord(akkusativ, proposition) == true) {
            answer = proposition + " eine " + adjektiv + "e " + femininNoun;
        } else if (findWord(dativ, proposition) == true) {
            answer = proposition + " einer " + adjektiv + "en " + femininNoun;
        } else if (findWord(genetiv, proposition) == true) {
            answer = proposition + " einer " + adjektiv + "en " + femininNoun;
        } else {


        }

        return answer;
    }

    public String answerDefiniteNeutral() throws IOException {

        //answers the question  for neutral nouns ( for every case akkusativ,dativ, genetiv )

        String proposition=splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,4),1,"-")  ;
        String adjektiv =splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,4),2,"-");
        String neutralNoun=splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,4),3,"-");


        String answer = "";
        if (findWord(akkusativ, proposition) == true) {
            answer = proposition + " das " + adjektiv + "e " + neutralNoun;
        } else if (findWord(dativ, proposition) == true) {
            answer = proposition + " dem " + adjektiv + "en " + neutralNoun;
        } else if (findWord(genetiv, proposition) == true) {
            answer = proposition + " des " + adjektiv + "en " + neutralNoun + "s";
        } else {


        }

        return answer;
    }

    public String answerUndefiniteNeutral() throws IOException {

        //answers the question  for neutral nouns ( for every case akkusativ,dativ, genetiv )

        String proposition=splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,10),1,"-")  ;
        String adjektiv =splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,10),2,"-");
        String neutralNoun=splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,10),3,"-");


        String answer = "";
        if (findWord(akkusativ, proposition) == true) {
            answer = proposition + " eines " + adjektiv + "e " + neutralNoun;
        } else if (findWord(dativ, proposition) == true) {
            answer = proposition + " einem " + adjektiv + "en " + neutralNoun;
        } else if (findWord(genetiv, proposition) == true) {
            answer = proposition + " eines " + adjektiv + "en " + neutralNoun + "s";
        } else {


        }

        return answer;
    }






    public void checkHomework() throws IOException{
        //write to homework to file
        //


        wr.creatFile(wr.checkHomeworkAdr);





        String firstAnswer= splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,1),1,"=");
         System.out.println(firstAnswer);
        System.out.println(answerDefiniteMaskulin());
        System.out.println(firstAnswer.equals(answerDefiniteMaskulin()));
         String secondAnswer=splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,3),1,"=");

        String thirdAnswer=splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,5),1,"=");

        String forthAnswer= splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,7),1,"=");

        String fifthAnswer=splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,9),1,"=");

        String sexthAnswer=splitLineOfAnswers(takeLineofAnswers(wr.homeworkAdr,11),1,"=");
        System.out.println(sexthAnswer);


        wr.writeStringToFile(wr.checkHomeworkAdr, rd.readLineFromFile(wr.homeworkAdr,0));
        if (firstAnswer.equals(answerDefiniteMaskulin())) {
            System.out.println(firstAnswer.equals(answerDefiniteMaskulin()));
            wr.writeStringToFile(wr.checkHomeworkAdr, "Your Answer = " + firstAnswer +  "--> Your answer is correct "  );
        }
        else
            wr.writeStringToFile(wr.checkHomeworkAdr, "Your Answer = " + firstAnswer +  "--> Your answer is false "+
                    "Correct answer = " + answerDefiniteMaskulin());



        wr.writeStringToFile(wr.checkHomeworkAdr, rd.readLineFromFile(wr.homeworkAdr,2));

        if (secondAnswer.equals(answerDefiniteFemininin())) {

            wr.writeStringToFile(wr.checkHomeworkAdr, "Your Answer = " + secondAnswer +  "--> Your answer is correct "  );
        }
        else
            wr.writeStringToFile(wr.checkHomeworkAdr, "Your Answer = " + secondAnswer +  "--> Your answer is false "+
                    "Correct answer = " + answerDefiniteFemininin());


        wr.writeStringToFile(wr.checkHomeworkAdr, rd.readLineFromFile(wr.homeworkAdr,4));

        if (thirdAnswer.equals(answerDefiniteNeutral())) {

            wr.writeStringToFile(wr.checkHomeworkAdr, "Your Answer = " + thirdAnswer +  "--> Your answer is correct "  );
        }
        else
            wr.writeStringToFile(wr.checkHomeworkAdr, "Your Answer = " + thirdAnswer +  "--> Your answer is false "+
                    "Correct answer = " + answerDefiniteNeutral());

        wr.writeStringToFile(wr.checkHomeworkAdr, rd.readLineFromFile(wr.homeworkAdr,6));
        if (forthAnswer.equals(answerUndefiniteMaskulin())) {

            wr.writeStringToFile(wr.checkHomeworkAdr, "Your Answer = " + forthAnswer +  "--> Your answer is correct "  );
        }
        else
            wr.writeStringToFile(wr.checkHomeworkAdr, "Your Answer = " + forthAnswer +  "--> Your answer is false "+
                    "Correct answer = " + answerUndefiniteMaskulin());



        wr.writeStringToFile(wr.checkHomeworkAdr, rd.readLineFromFile(wr.homeworkAdr,8));

        if (fifthAnswer.equals(answerUndefiniteFemininin())) {

            wr.writeStringToFile(wr.checkHomeworkAdr, "Your Answer = " + fifthAnswer +  "--> Your answer is correct "  );
        }
        else
            wr.writeStringToFile(wr.checkHomeworkAdr, "Your Answer = " + fifthAnswer +  "--> Your answer is false "+
                    "Correct answer = " + answerUndefiniteFemininin());


        wr.writeStringToFile(wr.checkHomeworkAdr, rd.readLineFromFile(wr.homeworkAdr,10));

        if (sexthAnswer.equals(answerUndefiniteNeutral())) {

            wr.writeStringToFile(wr.checkHomeworkAdr, "Your Answer = " + sexthAnswer +  "--> Your answer is correct "  );
        }
        else
            wr.writeStringToFile(wr.checkHomeworkAdr, "Your Answer = " + sexthAnswer +  "--> Your answer is false "+
                    "Correct answer = " + answerUndefiniteNeutral());




    }


    /**
     * @param pathAdress path adress of File
     * @param lineNumber indicate to line of file
     * @return it string in  LineNumber of File
     * @throws IOException
     */
    public String  takeLineofAnswers(String pathAdress,int lineNumber ) throws IOException{

        //read the line of answers
        //


        String lineOfAnswer=rd.readLineFromFile(pathAdress,lineNumber);
        if (lineOfAnswer.equals("Write your answer here="))
            lineOfAnswer = "Write your answer here= Theree is no answer";
    return lineOfAnswer;

    }


    /**
     * @param lineOfAnswer equal to line of file
     * @param i it is point which line is lineOfAnswer
     * @param a any kind of string to split line
     * @return  part of string after split a without a space
     */
    public String splitLineOfAnswers(String lineOfAnswer,int i,String a) {



            String[] words = lineOfAnswer.split(a);
            String studentsAnswer = words[i];

            studentsAnswer=studentsAnswer.trim();

        return studentsAnswer;
    }


    public  String getRandomWord(ArrayList<String> words) {
        //  choose random words from array
        //  iot creat random homework

        Random rand = new Random();
        String randomWord = words.get(rand.nextInt(words.size()));
        return randomWord;
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
