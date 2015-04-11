package com.labas.bozidar.foi.codebox.mvp.models;

/**
 * Created by bozidar on 08.04.15..
 */
public class Question {
    private int id;
    private String pitanje;
    private String odgovor_a;
    private String odgovor_b;
    private String odgovor_c;
    private String odgovor_d;
    private String tocan_odgovor;

    public String getTocan_odgovor() {
        return tocan_odgovor;
    }

    public void setTocan_odgovor(String tocan_odgovor) {
        this.tocan_odgovor = tocan_odgovor;
    }

    public String getOdgovor_a() {
        return odgovor_a;
    }

    public void setOdgovor_a(String odgovor_a) {
        this.odgovor_a = odgovor_a;
    }

    public String getOdgovor_b() {
        return odgovor_b;
    }

    public void setOdgovor_b(String odgovor_b) {
        this.odgovor_b = odgovor_b;
    }

    public String getOdgovor_c() {
        return odgovor_c;
    }

    public void setOdgovor_c(String odgovor_c) {
        this.odgovor_c = odgovor_c;
    }

    public String getOdgovor_d() {
        return odgovor_d;
    }

    public void setOdgovor_d(String odgovor_d) {
        this.odgovor_d = odgovor_d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPitanje() {
        return pitanje;
    }

    public void setPitanje(String pitanje) {
        this.pitanje = pitanje;
    }
}
