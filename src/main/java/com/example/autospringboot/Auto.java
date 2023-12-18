package com.example.autospringboot;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marka;
    private String model;
    private String nalichie;
    private String sena;
    public Auto() {
    }

    public Auto(String marka, String model, String nalichie, String sena) {
        this.marka = marka;
        this.model = model;
        this.nalichie = nalichie;
        this.sena = sena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNalichie() {
        return nalichie;
    }

    public void setNalichie(String nalichie) {
        this.nalichie = nalichie;
    }

    public String getSena() {
        return sena;
    }

    public void setSena(String sena) {
        this.sena = sena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return Objects.equals(id, auto.id) &&
                Objects.equals(marka, auto.marka) &&
                Objects.equals(model, auto.model) &&
                Objects.equals(nalichie, auto.nalichie) &&
                Objects.equals(sena, auto.sena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marka, model, nalichie, sena);
    }
}
