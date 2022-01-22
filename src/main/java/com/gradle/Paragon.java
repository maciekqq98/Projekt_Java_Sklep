package com.gradle;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Paragon {

    private  int idParagonu;
    private String daneParagonu;
    private String dataParagonu;

    public Paragon(int idParagonu, String daneParagonu, String dataParagonu) {
        this.idParagonu = idParagonu;
        this.daneParagonu = daneParagonu;
        this.dataParagonu = dataParagonu;
    }

    public Paragon() {

    }

    public int getIdParagonu() {
        return idParagonu;
    }

    public void setIdParagonu(int idParagonu) {
        this.idParagonu = idParagonu;
    }

    public String getDaneParagonu() {
        return daneParagonu;
    }

    public void setDaneParagonu(String daneParagonu) {
        this.daneParagonu = daneParagonu;
    }

    public String getDataParagonu() {
        return dataParagonu;
    }

    public void setDataParagonu(String dataParagonu) {
        this.dataParagonu = dataParagonu;
    }


    @Override
    public String toString() {
        return
                "Nr Paragonu :" + idParagonu +
                "\n Dane " + daneParagonu +
                "\n\n dataParagonu " + dataParagonu ;

    }
}
