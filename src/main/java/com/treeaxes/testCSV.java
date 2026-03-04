package com.treeaxes;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class testCSV {

    public static void main(String[] args) throws Exception {

        CSVReader csvReader = new CSVReader(new FileReader("lang.csv"));

        List<String> traduccion = new ArrayList<>();

        String[] record = null;

        while ((record = csvReader.readNext()) != null) {

            traduccion.add(record[0]);
            traduccion.add(record[1]);

        }
            csvReader.close();

        System.out.println(traduccion);
    }
}
