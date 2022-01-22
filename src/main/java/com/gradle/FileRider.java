package com.gradle;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FileRider {

    public static List<Produkty> readFile(String nazwaPliku) {
        List<Produkty> listaProduktów= new ArrayList<>();

        try {
            Scanner scanFile = new Scanner(new File(nazwaPliku));
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            scanFile.nextLine();
            while (scanFile.hasNextLine()) {
                String[] linia = scanFile.nextLine().split(";");
                listaProduktów.add(new Produkty(
                        Integer.parseInt(linia[0]),
                        linia[1],
                        Double.parseDouble(linia[2].replace(',','.')),
                        Double.parseDouble(linia[3]),
                        Integer.parseInt(linia[4]),
                        LocalDate.parse(linia[5],df),
                        LocalDate.parse(linia[6],df),
                        Boolean.parseBoolean(Integer.parseInt(linia[7])==1?"true":"false")
                ));

            }
            scanFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("Brak Pliku do odczytania!");
        }

        return listaProduktów;
    }

}
