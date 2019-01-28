package Adjektiv.Deklination;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReadDatabase {



    public ReadDatabase() throws IOException {

    }


    public ArrayList<String> readFromFile(String pathAdress) throws IOException {

        //read from files and add to array word by word

        ArrayList<String> allData = new ArrayList<>();

        Scanner input = new Scanner(new File(pathAdress));

        while (input.hasNext()) {
            String word = input.next();

            allData.add(word);
        }
        input.close();

        allData=removeDuplicates(allData);

        Collections.sort(allData);
        return allData;
    }

    public String readLineFromFile(String pathAdress,int lineNumber) throws IOException{
        String line = Files.readAllLines(Paths.get(pathAdress)).get(lineNumber);
        return line;

    }

/*
    public ArrayList<String> maskulinNouns () throws IOException {
       // read maskulin nouns from file
        // iot creat hw and answer questions
        WriteDatabase wr= new WriteDatabase();


        return words;
    }

    public ArrayList<String> femininNouns () throws IOException {
        //read feminin nouns from file
        // iot creat hw and answer questions
        WriteDatabase wr= new WriteDatabase();
        ArrayList words=readFromFile(wr.femininAdr);
        return words;
    }
    public ArrayList<String> neutralNouns () throws IOException {
        //read neutral nouns from file
        // iot creat hw and answer questions
        WriteDatabase wr= new WriteDatabase();
        ArrayList words=readFromFile(wr.neutralAdr);
        return words;
    }

    public ArrayList<String> adjektiv () throws IOException {
       // read adjektivs from file
       //// iot creat hw and answer questions
        WriteDatabase wr= new WriteDatabase();
        ArrayList words=readFromFile(wr.adjektivAdr);
        return words;
    }

    public ArrayList<String> akkusativ () throws IOException {
        // read akkusativ proposition from file
        // iot creat hw and answer questions

        WriteDatabase wr= new WriteDatabase();
        ArrayList words=readFromFile(wr.akkusativAdr);
        return words;
    }

    public ArrayList<String> dativ () throws IOException {
       // read dativ proposition from file
        // iot creat hw and answer questions
        WriteDatabase wr= new WriteDatabase();
        ArrayList words=readFromFile(wr.dativAdr);
        return words;
    }

    public ArrayList<String> genetiv () throws IOException {
        // read genetiv proposition from file
        // iot creat hw and answer questions
        WriteDatabase wr= new WriteDatabase();
        ArrayList words=readFromFile(wr.genetivAdr);
        return words;
    }

    public ArrayList<String> proposition() throws IOException {

       //union all proposition

       ArrayList<String> propositionAll= union(akkusativ(),dativ());
       return  union(propositionAll,genetiv());
    }
*/
    public static ArrayList<String> union(
            ArrayList<String> values1,
            ArrayList<String> values2) {

        // Return the union of 'values1' and 'values2'
        // that is basically every element contained in
        // any of the two

        ArrayList<String> union = new ArrayList<>();

        for (String x : values1) {
            union.add(x);
        }
        for (String x : values2) {
            union.add(x);
        }

        return union;
    }





    public ArrayList<String> removeDuplicates(ArrayList<String> values) {
        // remove dublication in array
        // use it while read the data from files
        // useful later for rewrite files

        ArrayList<String> newValues = new ArrayList<>();
        for (String x : values) {
            if (findWord(newValues, x) == false) {
                newValues.add(x);
            }
        }
        return newValues;
    }

    public boolean findWord(List<String> values, String x) {
        // find a word in the array
        // useful by creating homework

        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).equals(x)) {
                return true;
            }
        }

        return false;
    }

}

