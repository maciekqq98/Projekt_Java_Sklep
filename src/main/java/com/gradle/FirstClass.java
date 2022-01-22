package com.gradle;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.gradle.FileRider.readFile;

public class FirstClass {
    public static int liczbaParagonow=1;

    public static Paragon StworzParagon(String[] dane,BigDecimal kwota)
    {
       StringBuilder var = new StringBuilder();
        Paragon paragon= new Paragon();
        paragon.setIdParagonu(liczbaParagonow++);
        for (String s : dane) {

            var.append(s);
        }
        LocalDateTime now = LocalDateTime.now();
        paragon.setDaneParagonu(var.toString()+"\n SUMA: " +kwota);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatDateTime = now.format(formatter);
        paragon.setDataParagonu(formatDateTime);
        System.out.println(paragon);

        return paragon;
    }
    public static boolean saveToFile(Paragon paragon) throws IOException {

        String nazwaPliku = "paragon.txt";
        PrintWriter zapis = new PrintWriter(nazwaPliku);
            zapis.println(paragon);
        zapis.close();

        File file = new File(nazwaPliku);
        if (!Desktop.isDesktopSupported()) {

            return false;
        }
        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) desktop.open(file);
        return true;
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        StworzZamowienie();
        System.out.println("\n Czy chcesz dodac nowe zamówienie ? Wpisz \"next\" aby dodac");
        while(scanner.hasNextLine())
        {
            //System.out.println("\n Czy chcesz dodac nowe zamówienie ? Wpisz \"next\" aby dodac");
            if (scanner.next().equals("next")) {
                StworzZamowienie();
            }else {
                scanner.next();
            }
        }


    }

    private static void StworzZamowienie() throws IOException {
        Scanner scanner = new Scanner(System.in);

        List<Produkty> lista= new ArrayList<>(readFile("produkty1.csv") );
        List<Produkty>listaWybranych= new ArrayList<>();
        System.out.println("\n Podaj nr produktow, ktrore chcesz zamowic, jesli chcesz zakonczyc wybor wpisz \"end\"\n");
        for (Produkty pr: lista) {

            System.out.println(pr);
        }
        for (Produkty pr: lista) {

           // System.out.println(pr.SprawdzDateWaznosci(pr));
        }


        int number;
        for(int i=0; i<lista.size();i++)
        {
            System.out.println("Podaj nr produktu: ");
            if(scanner.hasNextInt())
            {
                number = scanner.nextInt();
                if(number>lista.size())
                {
                    break; // zle działa
                    //number = scanner.nextInt();
                }
                else {

                    listaWybranych.add(lista.get(number-1));
                }
            }else
            {
                if(scanner.next().equals("end")){
                    break;
                } //else scanner.next(); System.out.println("Podaj nr produktu: ");
            }
        }
        BigDecimal kwotaZamowienia =  BigDecimal.ZERO;
        String[] daneDoParagoonu = new String[listaWybranych.size()];

        System.out.println("Podsumowanie Zamóiwenia: \n");
        for (int i =0; i<listaWybranych.size();i++)
        {
           // kwotaZamowienia+=listaWybranych.get(i).getPrice();
            MathContext mc = new MathContext(4);

           kwotaZamowienia=kwotaZamowienia.add(BigDecimal.valueOf(listaWybranych.get(i).getPrice()), mc);
            System.out.println(listaWybranych.get(i).getName());
            daneDoParagoonu[i]=" \n"+listaWybranych.get(i).getName()
                    + "\n cena "+listaWybranych.get(i).getPrice()
                    + "\n "+listaWybranych.get(i).getAmount()+"g"
                    + "\n data produkcj "+listaWybranych.get(i).getDateProdukcji()
                    + "\n data spozycia "+listaWybranych.get(i).getDateSpozycia();
        }

        System.out.println(new StringBuilder().append("\nSuma: ").append(kwotaZamowienia).append("\n"));


        if(!kwotaZamowienia.equals(BigDecimal.ZERO))
        {
            saveToFile(StworzParagon(daneDoParagoonu,kwotaZamowienia));
        }
    }
}
