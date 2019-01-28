package Adjektiv.Deklination;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class WriteDatabase {


    /**creat a relativ path adress for files
     *C:\Users\m\IdeaProjects\adjektiv deklination\DER (relativ path adress)
     */
    String maskulinAdr =getRelativPathAdr("DER.txt");
    String femininAdr = getRelativPathAdr("DIE.txt");
    String neutralAdr = getRelativPathAdr("DAS.txt");
    String adjektivAdr = getRelativPathAdr("ADJ.txt");
    String akkusativAdr = getRelativPathAdr("AKK.txt");
    String dativAdr = getRelativPathAdr("DAT.txt");
    String genetivAdr = getRelativPathAdr("GEN.txt");

    public WriteDatabase()  {

    }

    public String getRelativPathAdr(String pathName){
        return new File(pathName).getAbsolutePath();
    }




    /**Creat the files for a small database
     * @throws IOException
     */

    public void creatAllFiles() throws IOException {

        creatFile(maskulinAdr);
        creatFile(femininAdr);
        creatFile(neutralAdr);
        creatFile(adjektivAdr);
        creatFile(akkusativAdr);
        creatFile(dativAdr);
        creatFile(genetivAdr);
    }
    /**Creat a file
     * @throws IOException
     * check if is exist or not
     */

    public void creatFile(String pathAdress) throws IOException {
        // creat a file
        File file = new File(pathAdress);

        if (!file.exists()) {
            System.out.println("There is no file");
            file.createNewFile();
            System.out.println("file created");

        }
    }

    /**
     * @param pathAdress = it is adress of file in which we wanna write
     * @param sentences= a sentence which we wanna add in to any file
     * @throws IOException
     */


   public void writeStringToFile(String pathAdress, String sentences) throws IOException {



        FileWriter fw = new FileWriter(pathAdress,true);
        BufferedWriter fileoutput = new BufferedWriter(fw);
        fileoutput.write(sentences);
        fileoutput.newLine();
        fileoutput.close();
        fw.close();

    }




    /**
     * @param pathAdress = it is adress of file in which we wanna write
     * @param words= am array which we use word by word  iot write in to the database file
     * @throws IOException
     */
    public void writeToFile(String pathAdress, ArrayList<String> words) throws IOException {



        FileWriter fw = new FileWriter(pathAdress, true); //append =  add new data to the files without dlete
        BufferedWriter fileoutput = new BufferedWriter(fw);
        for (int i = 0; i < words.size(); i++) {

            fileoutput.write("\t" + words.get(i));
        }
        fileoutput.close();
        fw.close();

    }

    /**
     * @param pathAdress = it is adress of file in which we wanna write
     * @param words= they are data which we wanna write in to the file
     * @throws IOException
     * it write a newline after every 8 words
     * it is not work to add new datas(delete all data and write new )
     */
    public void writeNewLineToFile(String pathAdress, ArrayList<String> words) throws IOException {

        FileWriter fw = new FileWriter(pathAdress);
        BufferedWriter fileoutput = new BufferedWriter(fw);
        for (int i = 0; i < words.size(); i++) {

            fileoutput.write("\t" + words.get(i));

            if ((i+1) % 8 == 0) {
                fileoutput.newLine();
            }
        }
        fileoutput.close();
        fw.close();
    }

    /**
     * @throws IOException
     * reading the database after adding new words
     * writing to all datas in to  files again in alfabethic sort without dublications
     */
    public void rewriteToFiles() throws IOException {
        ReadDatabase rd = new ReadDatabase();

        writeNewLineToFile(maskulinAdr,rd.readFromFile(maskulinAdr));
        writeNewLineToFile(femininAdr, rd.readFromFile(femininAdr));
        writeNewLineToFile(neutralAdr, rd.readFromFile(neutralAdr));
        writeNewLineToFile(adjektivAdr, rd.readFromFile(adjektivAdr));
        writeNewLineToFile(akkusativAdr, rd.readFromFile(akkusativAdr));
        writeNewLineToFile(dativAdr, rd.readFromFile(dativAdr));
        writeNewLineToFile(genetivAdr, rd.readFromFile(genetivAdr));
    }
}