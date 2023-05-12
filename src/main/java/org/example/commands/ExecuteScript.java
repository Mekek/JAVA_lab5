package org.example.commands;

import org.example.CommandResult;
import org.example.Factory;
import org.example.file.Collection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Vector;

/**
 * @author Mikhail Kadilov
 * The 'execute_script' command.
 * Execute the script from the file.
 */
public class ExecuteScript extends Command{
    private Collection collection;
    private Factory factory;
    private static Vector<String> filenames;
    public ExecuteScript(Collection collection, Factory factory) {
        this.factory = factory;
        this.collection = collection;
        filenames = new Vector<>();
    }
    /**
     * Execute a script
     * @param args the arguments passed to the command.
     */
    @Override
    public void execute(String[] args) {
       String filename = args[0];
       if (filenames.contains(filename)){
           filenames.clear();
           throw new IllegalArgumentException("бесконечный рекурсивный вызов файлов");
       }
       if (!new File(filename).exists()){
           filenames.clear();
           throw new IllegalArgumentException("файла с таким названием не существует");
       }
       if (! new File(filename).isFile()){
           filenames.clear();
           throw new IllegalArgumentException("это директория, а не файл");
       }
       filenames.add(filename);
       ArrayList<String> arrayListLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line=reader.readLine())!=null){
                if (!line.trim().isEmpty()) {
                    arrayListLines.add(line);
                }
            }
        } catch (Exception e) {
            filenames.clear();
            throw new RuntimeException(e);
        }
        try {
            for (int i = 0; i < arrayListLines.size(); i++){
                CommandResult command = factory.create(arrayListLines.get(i));
                boolean flag = true;
                if (command.getCommand() instanceof Add && command.getArgs().length == 0){
                    if ((flag && Factory.checkCommand(arrayListLines.get(i + 1)))) throw new RuntimeException("в add не хватает данных");
                    flag = false;
                    if (i < arrayListLines.size()-1 && !Factory.checkCommand(arrayListLines.get(i+1))){
                        flag = false;
                        String addTicket = "";
                        for (int j = 0; j < 9; j++){
                            i++;
                            addTicket += arrayListLines.get(i) + ";";
                        }
                        String[] strings = {addTicket};
                        command.setArgs(strings);
                    }
                }
                command.getCommand().execute(command.getArgs());
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        filenames.remove(0);
    }
}
