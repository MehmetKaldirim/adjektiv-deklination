package Adjektiv.Deklination;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GetInput {
    WriteDatabase wr = new WriteDatabase();

    public GetInput() {
    }

    public void creatFirstDatas(String nameOfData) throws IOException {

        //  choose which file you wanna use
        //  and add data by using array


        ArrayList<String> words = new ArrayList<>();

        if (nameOfData.equals("maskulin")) {
            System.out.println("How many Data do you wanna enter to the File of Maskulin?");
            words = askData();
            wr.writeToFile(wr.maskulinAdr, words);
        }

        if (nameOfData.equals("feminin")) {
            System.out.println("How many Data do you wanna enter to the File of Feminin?");
            words = askData();
            wr.writeToFile(wr.femininAdr, words);
        }

        if (nameOfData.equals("neutral")) {
            System.out.println("How many Data do you wanna enter to the File of Neutral?");
            words = askData();
            wr.writeToFile(wr.neutralAdr, words);
        }

        if (nameOfData.equals("adjektiv")) {
            System.out.println("How many Data do you wanna enter to the File of Adjektiv?");
            words = askData();
            wr.writeToFile(wr.adjektivAdr, words);
        }

        if (nameOfData.equals("akkusativ")) {
            System.out.println("How many Data do you wanna enter to the File of akkusativ proposition?");
            words = askData();
            wr.writeToFile(wr.akkusativAdr, words);
        }

        if (nameOfData.equals("dativ")) {
            System.out.println("How many Data do you wanna enter to the File of dativ proposition?");
            words = askData();
            wr.writeToFile(wr.dativAdr, words);
        }

        if (nameOfData.equals("genetiv")) {
            System.out.println("How many Data do you wanna enter to the File of genetiv proposition?");
            words = askData();
            wr.writeToFile(wr.genetivAdr, words);
        }



        wr.rewriteToFiles();

    }
    public void addMoreData() throws IOException {

        //  choose which file you wanna use
        //  and add data by using array


        do {
            System.out.println("PLEASE WRITE WHICH DATA ,DO YOU WANNA ADD \n" +
                    "maskulin,feminin,neutral,adjektiv,akkusativ,dativ or genetiv");

            String nameOfData = askString();

            while (!nameOfData.equals("maskulin") && !nameOfData.equals("feminin") && !nameOfData.equals("neutral") &&
                    !nameOfData.equals("adjektiv") && !nameOfData.equals("akkusativ") && !nameOfData.equals("dativ")
                    && !nameOfData.equals("genetiv")) {

                System.out.println(" has to be written\n" +
                        "maskulin,feminin,neutral,adjektiv,akkusativ,dativ or genetiv" + " try again:");

                nameOfData = askString();

            }


            ArrayList<String> words = new ArrayList<>();

            if (nameOfData.equals("maskulin")) {
                System.out.println("How many Data do you wanna enter to the File of Maskulin?");
                words = askData();
                wr.writeToFile(wr.maskulinAdr, words);
            }

            if (nameOfData.equals("feminin")) {
                System.out.println("How many Data do you wanna enter to the File of Feminin?");
                words = askData();
                wr.writeToFile(wr.femininAdr, words);
            }

            if (nameOfData.equals("neutral")) {
                System.out.println("How many Data do you wanna enter to the File of Neutral?");
                words = askData();
                wr.writeToFile(wr.neutralAdr, words);
            }

            if (nameOfData.equals("adjektiv")) {
                System.out.println("How many Data do you wanna enter to the File of Adjektiv?");
                words = askData();
                wr.writeToFile(wr.adjektivAdr, words);
            }

            if (nameOfData.equals("akkusativ")) {
                System.out.println("How many Data do you wanna enter to the File of akkusativ proposition?");
                words = askData();
                wr.writeToFile(wr.akkusativAdr, words);
            }

            if (nameOfData.equals("dativ")) {
                System.out.println("How many Data do you wanna enter to the File of dativ proposition?");
                words = askData();
                wr.writeToFile(wr.dativAdr, words);
            }

            if (nameOfData.equals("genetiv")) {
                System.out.println("How many Data do you wanna enter to the File of genetiv proposition?");
                words = askData();
                wr.writeToFile(wr.genetivAdr, words);
            }



            System.out.println("Do you wanna add data to the  other files");

        } while (yesOrNo().equals("Yes"));

        wr.rewriteToFiles();

    }

    public ArrayList<String> askData() {

        // add to datas to array
        //  use this array iot write files

        ArrayList<String> values = new ArrayList<String>();


        int a = askint();
        System.out.println(" write the datas");
        for (int i = 0; i < a; i++) {
            values.add(askString());

        }
        return values;
    }


    public String yesOrNo() {

        // use it anycase of your "yes no" questions

        String yesOrNo = "";

        System.out.println("Yes or No");
        yesOrNo = askString();

        while (!yesOrNo.equals("Yes") && !yesOrNo.equals("No")) {

            System.out.println(" has to be written  Yes or No, try again:");

            yesOrNo = askString();

        }

        return yesOrNo;

    }


    public String askString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    public int askint() throws InputMismatchException
    {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();///ask here

        while (input != (int)input) {

            System.out.println( " has to be numeric, try again:");

            input = scanner.nextInt();

        }
        return input;
    }
    public static boolean isInteger(String s, int radix) {
        Scanner sc = new Scanner(s.trim());
        if(!sc.hasNextInt(radix)) return false;
        // we know it starts with a valid int, now make sure
        // there's nothing left!
        sc.nextInt(radix);
        return !sc.hasNext();
    }


}
