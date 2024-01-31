package Logs;

import java.io.*;
import java.time.LocalDateTime;

public class ReadAndWriteLog {
       static String  fileName = ".\\src\\Logs\\logs.txt";
    public static  void writeLog(String station , String location , String car , String message){
        String log  = String.format( "at : "+ LocalDateTime.now()  + " in {} in {} for {}   log  ->[ {} ]" , station , location , car , message);
        System.out.println(log);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            writer.append(log);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.err.println("Error : " + e.getMessage());
        }
    }
    public static void readLog() throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();

    }

    public static void deleteLog() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            writer.write(" ");
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.err.println("Error : " + e.getMessage());
        }
    }
}
