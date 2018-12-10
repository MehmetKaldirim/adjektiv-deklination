package Adjektiv.Deklination;

import Person.SendEmail;

import java.io.IOException;

public class main {


    public static void main(String[] args) throws IOException {
        WriteDatabase wr = new WriteDatabase();
        GetInput gi= new GetInput();


        SendEmail e = new SendEmail();

       System.out.println("Do you compile the code first time ?  ");

       if (gi.yesOrNo().equals("Yes")) {
           wr.creatAllFiles();  // chose which file to add which words
           System.out.println("Then, you must add datas to all files iot creat database?  ");
           gi.creatFirstDatas("maskulin");
           gi.creatFirstDatas("feminin");
           gi.creatFirstDatas("neutral");
           gi.creatFirstDatas("adjektiv");
           gi.creatFirstDatas("akkusativ");
           gi.creatFirstDatas("dativ");
           gi.creatFirstDatas("dativ");

              }

        // improving database
        // if answer Yes add new word to data base

        System.out.println("Do you wanna add more to database?   ");

        if (gi.yesOrNo().equals("Yes")) {
            gi.addMoreData();  // chose which file to add the words
        }


        System.out.println("Do you wanna creat a new homework ?   ");
            Homework hw = new Homework();
        if (gi.yesOrNo().equals("Yes")) {

            hw.creatHomework();// creat  Homework,in  "Homework" file
            e.send("savaskaraupon1978@gmail.com", "adjektivdeklination@gmail.com");
        }
            System.out.println("Do you wanna check last homework ?   ");


        if (gi.yesOrNo().equals("Yes")) {

            hw.checkHomework();// check   Homework, in  "Homework" file
        }

    }
    }

