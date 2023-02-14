package commandExecutor;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandExecutor {

    public void start() {
        boolean execution = true;
        Scanner console = new Scanner(System.in);

        // ƒќЅј¬»“№ ѕ–≈ƒ¬ј–»“≈Ћ№Ќџ… «јѕ”—  ¬—≈’  Ќ≈ќЅ’ќƒ»ћџ’ ѕ–ќ÷≈——ќ¬

        while (execution) {
            String line = console.nextLine();
            execute(line);

        }
    }

    public void execute(String line) {
        if (line.equals("help")) {
            help();
        }
        else if (line.equals("info")) {
            ;
        }
        else if (line.equals("show")){
            ;
        }
        else if (line.indexOf("insert null ") == 0){
            ;
        }
        else if (line.indexOf("update id ") == 0){
            ;
        }
        else if (line.indexOf("remove_key ") == 0){
            ;
        }
        else if (line.equals("clear")){
            ;
        }
        else if (line.equals("save")){
            ;
        }
        else if (line.indexOf("execute_script ") == 0){
            ;
        }
        else if (line.equals("exit")){
            ;
        }
        else if (line.indexOf("remove_lower ") == 0){
            ;
        }
        else if (line.equals("history")){
            ;
        }
        else if (line.indexOf("replace_if_greater ") == 0){
            ;
        }
        else if (line.indexOf("count_by_event ") == 0){
            ;
        }
        else if (line.indexOf("filter_contains_name ") == 0){
            ;
        }
        else if (line.equals("print_field_descending_event")){
            ;
        }
    }

    public void help() {
        HashMap<Integer, String> passportsAndNames = new HashMap<>();

        HashMap<String, String> commandMap = new HashMap<String, String>() {{
            put("help", ": вывести справку по доступным командам");
            put("info", ": вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
            put("show", ": вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
            put("insert null {element}", ": добавить новый элемент с заданным ключом");
            put("update id {element}", ": обновить значение элемента коллекции, id которого равен заданному");
            put("remove_key null", ": удалить элемент из коллекции по его ключу");
            put("clear",  ": очистить коллекцию");
            put("save", ": сохранить коллекцию в файл");
            put("execute_script file_name", ": считать и исполнить скрипт из указанного файла. ¬ скрипте содержатс€ команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
            put("exit", ": завершить программу (без сохранени€ в файл)");
            put("remove_lower {element}", ": удалить из коллекции все элементы, меньшие, чем заданный");
            put("history", ": вывести последние 7 команд (без их аргументов)");
            put("replace_if_greater null {element}", ": заменить значение по ключу, если новое значение больше старого");
            put("count_by_event event", ": вывести количество элементов, значение пол€ event которых равно заданному");
            put("filter_contains_name name", ": вывести элементы, значение пол€ name которых содержит заданную подстроку");
            put("print_field_descending_event", ": вывести значени€ пол€ event всех элементов в пор€дке убывани€");
        }};

        for (String name: commandMap.keySet()) {
            String key = name;
            String value = commandMap.get(name);
            System.out.println(key + " " + value);
        }


    }
}
