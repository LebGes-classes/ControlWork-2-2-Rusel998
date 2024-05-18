package org.example;

import org.file_actions.XLSXActions;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] header = new String[]{"Канал","Время","Название"};
        ArrayList<Program> sortPrograms = SortingByTime.programsSortedByTime();
        String[][] answer = new String[sortPrograms.size()][3];
        int index = 0;
        for(Program program: sortPrograms){
            String str = program.toString();
            String[] cols = str.split(";");
            answer[index++] = cols;
        }

        FindingBy f = new FindingBy();
        f.findingByName("История вещей. Радиола");
        f.findingByName("Загадка Шаляпина");
        f.findingByName("Поедем, поедим! Выпуск от 23 марта");

        XLSXActions.writeFile(answer,"osel",header,"title");
    }
}
