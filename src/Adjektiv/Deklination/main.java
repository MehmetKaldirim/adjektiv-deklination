package Adjektiv.Deklination;

import Homework.CheckAnswers;
import Homework.CreateHomework;
import Person.MailBox;

import java.io.IOException;

public class main {


    public static void main(String[] args) throws IOException {
        WriteDatabase wr = new WriteDatabase();
        GetInput input = new GetInput();

        MailBox e = new MailBox("adjektivdeklination@gmail.com","Adjektiv2018-");


        System.out.println("Do you wanna creat a new database ?  ");

        if (input.yesOrNo().equals("Yes")) {
            wr.creatAllFiles();  // chose which file to add which words
            System.out.println("Then, you must add datas to all files iot creat database?  ");
            input.creatFirstDatas("maskulin");
            input.creatFirstDatas("feminin");
            input.creatFirstDatas("neutral");
            input.creatFirstDatas("adjektiv");
            input.creatFirstDatas("akkusativ");
            input.creatFirstDatas("dativ");
            input.creatFirstDatas("dativ");

        }

        // improving database
        // if answer Yes add new word to data base

        System.out.println("Do you wanna add new datas to database?   ");

        if (input.yesOrNo().equals("Yes")) {
            input.addMoreData();  // chose which file to add the words
        }



       ;
        System.out.println("Do you wanna creat a new homework ?   ");


        if (input.yesOrNo().equals("Yes"))

        {

            CreateHomework creat = new CreateHomework();
            creat.choseHomework();

         //creat  CreateHomework,in  "CreateHomework" file


                e.send("savaskaraupon1978@gmail.com",
                        wr.getRelativPathAdr("homework.txt"),
                   "Hello, Here is your new homework, good luck...:)   ");
        }

        System.out.println("Do you wanna check last homework ?   ");


        if (input.yesOrNo().equals("Yes")) {
            CheckAnswers check = new CheckAnswers();
            check.choseHomework();// result for Students

            e.send("semihkiziltan@gmail.com",
                        wr.getRelativPathAdr("Checkhomework.txt"),
                    "Hello, Here is your result, good job...:)   ");
        }

    }
}

