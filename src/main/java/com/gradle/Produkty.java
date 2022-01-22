package com.gradle;

import java.time.LocalDate;
import java.time.LocalDateTime;

public  class Produkty {

    private int id;
    private String name;
    private double price;
    private double kcl;
    private int amount; //gramy
    private LocalDate dateProdukcji;
    private LocalDate dateSpozycia;
    private boolean vegetarian;



    public Produkty(int id, String name, double price, double kcl, int amount, LocalDate dateProdukcji, LocalDate dateSpozycia, boolean vegan) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.kcl = kcl;
        this.amount = amount;
        this.dateProdukcji = dateProdukcji;
        this.dateSpozycia = dateSpozycia;
        this.vegetarian = vegan;
    }

    public Produkty() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getKcl() {
        return kcl;
    }

    public void setKcl(double kcl) {
        this.kcl = kcl;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDateProdukcji() {
        return dateProdukcji;
    }

    public void setDateProdukcji(LocalDate dateProdukcji) {
        this.dateProdukcji = dateProdukcji;
    }

    public LocalDate getDateSpozycia() {
        return dateSpozycia;
    }

    public void setDateSpozycia(LocalDate dateSpozycia) {
        this.dateSpozycia = dateSpozycia;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public String szczegolyProduktu()
    {
        return  getName()+" "+ getPrice()+" "+ getKcl()+" "+ getAmount()+" "+getDateProdukcji()+" "+getDateSpozycia()+" "+ isVegetarian();

    }

    @Override
    public String toString() {
        return
                id +
                ", name=" + name  +
                ", price=" + price +
                ", amount=" + amount +
                ", dateProdukcji=" + dateProdukcji +
                ", dateSpozycia=" + dateSpozycia;


    }

    public boolean SprawdzDateWaznosci( Produkty produkty)
    {
        LocalDateTime now = LocalDateTime.now();
        LocalDate nowDate = now.toLocalDate();

            if(nowDate.getYear()==produkty.getDateSpozycia().getYear()
            &&  nowDate.getMonth() == produkty.getDateSpozycia().getMonth()
            && nowDate.getDayOfMonth() > produkty.getDateSpozycia().getDayOfMonth())
            {
                return true;

            }
            else
            {
                return false;
            }

    }


}
