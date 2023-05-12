package org.example;

import org.example.file.Collection;
import org.example.file.FileManager;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * @author Mikhail Kadilov
 * This is main class.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0){
            System.err.println("передайте название файла");
            System.exit(1);
        }
        String fileName = args[0];
        Collection collection = null;

        try {
            FileManager fileManager = new FileManager(fileName);
            collection = new Collection(fileManager);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(2);
        }

        System.out.println("Let's start");

        System.out.println("__________*********____________________________");
        System.out.println("________***………… ****__________________________");
        System.out.println("______****……О…….… ****_______________________");
        System.out.println("__(/////////// …………………***_____________________");
        System.out.println("___(/////////// .....***____________________");
        System.out.println("_________**………………... **______________________");
        System.out.println("___________****)…………. **______________________");
        System.out.println("________________)……….. **______________________");
        System.out.println("_________________)……… ** ______________________");
        System.out.println("_________________)……….. **_____________________");
        System.out.println("_________________)…………… UU_______________ )))__");
        System.out.println("________________))……………. UUUU________ ((….)))___");
        System.out.println("_______________))…………….UUUUUUUU__ ((…… )))____");
        System.out.println("______________))………………… UUUUUUU ((………)))____");
        System.out.println("_____________)…………………………………………… )))_____");
        System.out.println("____________).……………………………………………. )))_____");
        System.out.println("___________))……………………………………………….)))_____");
        System.out.println("___________))……………………………………………… )))_____");
        System.out.println("____________))……………………………………………...)))____");
        System.out.println("_____________))……………………………………………)))_____");
        System.out.println("______________))……………………………………… )))_______");
        System.out.println("_______________))<<<<<<<<<<<<<<<<__________");
        System.out.println("________________________________________________");
        System.out.println("Введите команду:");

        Scanner scanner = new Scanner(in);
        Factory factory = new Factory(collection);
        boolean workingProcess = true;
        while (workingProcess) {
            try {
                if (scanner.hasNextLine()){
                    String s = scanner.nextLine();
                    CommandResult command = factory.create(s);
                    command.getCommand().execute(command.getArgs());
                    workingProcess = command.getCommand().getFlag();
                }
                else {
                    workingProcess = false;
                    System.err.println("не надо вводить ctrl + D, это не поможет");
                }
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
}
