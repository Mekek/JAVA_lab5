package commandExecutor;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandExecutor {

    public void start() {
        boolean execution = true;
        Scanner console = new Scanner(System.in);

        // �������� ��������������� ������ ����  ����������� ���������

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
            put("help", ": ������� ������� �� ��������� ��������");
            put("info", ": ������� � ����������� ����� ������ ���������� � ��������� (���, ���� �������������, ���������� ��������� � �.�.)");
            put("show", ": ������� � ����������� ����� ������ ��� �������� ��������� � ��������� �������������");
            put("insert null {element}", ": �������� ����� ������� � �������� ������");
            put("update id {element}", ": �������� �������� �������� ���������, id �������� ����� ���������");
            put("remove_key null", ": ������� ������� �� ��������� �� ��� �����");
            put("clear",  ": �������� ���������");
            put("save", ": ��������� ��������� � ����");
            put("execute_script file_name", ": ������� � ��������� ������ �� ���������� �����. � ������� ���������� ������� � ����� �� ����, � ������� �� ������ ������������ � ������������� ������.");
            put("exit", ": ��������� ��������� (��� ���������� � ����)");
            put("remove_lower {element}", ": ������� �� ��������� ��� ��������, �������, ��� ��������");
            put("history", ": ������� ��������� 7 ������ (��� �� ����������)");
            put("replace_if_greater null {element}", ": �������� �������� �� �����, ���� ����� �������� ������ �������");
            put("count_by_event event", ": ������� ���������� ���������, �������� ���� event ������� ����� ���������");
            put("filter_contains_name name", ": ������� ��������, �������� ���� name ������� �������� �������� ���������");
            put("print_field_descending_event", ": ������� �������� ���� event ���� ��������� � ������� ��������");
        }};

        for (String name: commandMap.keySet()) {
            String key = name;
            String value = commandMap.get(name);
            System.out.println(key + " " + value);
        }


    }
}
