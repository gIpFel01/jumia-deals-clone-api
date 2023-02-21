package com.jumiadealsclone.ads.modelelayer;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "locality")
public class Locality implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idLocality",nullable = false)
    private long idLocality;
    @Column(name = "labellocality")
    private String labelLocality;

    public Locality() {
    }

    public Locality(long idLocality, String labelLocality) {
        this.idLocality = idLocality;
        this.labelLocality = labelLocality;
    }

    public Locality(String labelLocality) {
        this.labelLocality = labelLocality;
    }

    public long idLocality() {
        return idLocality;
    }

    public void setIdLocality(long idLocality) {
        this.idLocality = idLocality;
    }

    public String labelLocality() {
        return labelLocality;
    }

    public void setLabelLocality(String labelLocality) {
        this.labelLocality = labelLocality;
    }

    @Override
    public String toString() {
        return "Locality{" +
                "idLocality=" + idLocality +
                ", labelLocality='" + labelLocality + '\'' +
                '}';
    }
}
