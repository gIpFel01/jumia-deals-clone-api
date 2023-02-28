package com.jumiadealsclone.ads.modelelayer;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "locality")
public class Locality implements Serializable {

    @Id
    @Column(name = "idlocality")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idLocality;

    @Enumerated(EnumType.STRING)
    private LocalityType localityType;

    public long idLocality() {
        return idLocality;
    }

    public void setIdLocality(long idLocality) {
        this.idLocality = idLocality;
    }

    public LocalityType localityType() {
        return localityType;
    }

    public void setLocalityType(LocalityType localityType) {
        this.localityType = localityType;
    }

    @Override
    public String toString() {
        return "Locality{" +
                "idLocality=" + idLocality +
                ", localityType=" + localityType +
                '}';
    }
}
