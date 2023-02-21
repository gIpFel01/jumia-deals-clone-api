package com.jumiadealsclone.ads.modelelayer;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "advertisement")
public class Advertisement {

    @Id
    @Column(name = "idadvertisement",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idadvertisement;

    @Column(name = "advertisementphoto")
    private String advertisementPhoto;

    @Column(name = "advertisementdescription")
    private String advertisementDescription;

    @Column(name = "advertisementpublishdate")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date advertisementPublishDate;

    @Column(name = "advertisementprice")
    private long advertisementPrice;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idavertiser")
    private Advertiser advertiser;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idlocality")
    private Locality locality;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idcategory")
    private Category category;

    public Advertisement() {
    }

    public long idadvertisement() {
        return idadvertisement;
    }

    public void setIdadvertisement(long idadvertisement) {
        this.idadvertisement = idadvertisement;
    }

    public String advertisementPhoto() {
        return advertisementPhoto;
    }

    public void setAdvertisementPhoto(String advertisementPhoto) {
        this.advertisementPhoto = advertisementPhoto;
    }

    public String advertisementDescription() {
        return advertisementDescription;
    }

    public void setAdvertisementDescription(String advertisementDescription) {
        this.advertisementDescription = advertisementDescription;
    }

    public Date advertisementPublishDate() {
        return advertisementPublishDate;
    }

    public void setAdvertisementPublishDate(Date advertisementPublishDate) {
        this.advertisementPublishDate = advertisementPublishDate;
    }

    public long advertisementPrice() {
        return advertisementPrice;
    }

    public void setAdvertisementPrice(long advertisementPrice) {
        this.advertisementPrice = advertisementPrice;
    }

    public Advertiser advertiser() {
        return advertiser;
    }

    public void setAdvertiser(Advertiser advertiser) {
        this.advertiser = advertiser;
    }

    public Locality locality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public Category category() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "idadvertisement=" + idadvertisement +
                ", advertisementPhoto='" + advertisementPhoto + '\'' +
                ", advertisementDescription='" + advertisementDescription + '\'' +
                ", advertisementPublishDate=" + advertisementPublishDate +
                ", advertisementPrice=" + advertisementPrice +
                ", advertiser=" + advertiser +
                ", locality=" + locality +
                ", category=" + category +
                '}';
    }
}
