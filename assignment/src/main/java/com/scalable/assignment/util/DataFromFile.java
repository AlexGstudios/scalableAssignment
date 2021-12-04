package com.scalable.assignment.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.scalable.assignment.model.Theme;

public class DataFromFile {

    public static Map<String, Theme> getData() {
        File file = new File("E:/skalbaratjanster/assignment/assignment/themes.csv");
        Map<String, Theme> themes = new HashMap<>();
        try {

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] line = str.split(",");

                if (line.length < 3) {
                    Theme theme = new Theme(line[0], line[1], "");
                    themes.put(line[0], theme);

                } else {
                    Theme theme = new Theme(line[0], line[1], line[2]);
                    themes.put(line[0], theme);
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return themes;
    }
}