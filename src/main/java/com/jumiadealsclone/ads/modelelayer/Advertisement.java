package com.jumiadealsclone.ads.modelelayer;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "advertisement")
public class Advertisement {

    @Id
    @Column(name = "idadvertisement",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAdvertisement;

    @Column(name = "advertisementphoto")
    private String advertisementPhoto;

    @Column(name = "advertisementdescription")
    private String advertisementDescription;

    @Column(name = "advertisementpublishdate")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date advertisementPublishDate;

    @Column(name = "advertisementprice")
    private long advertisementPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idadvertiser")
    private Advertiser advertiser;

    @ManyToOne
    @JoinColumn(name = "idlocality")
    private Locality locality;

    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;

    public Advertisement() {
    }

    public Advertisement(String advertisementPhoto, String advertisementDescription, Date advertisementPublishDate,
                         long advertisementPrice, Advertiser advertiser, Locality locality, Category category) {
        this.advertisementPhoto = advertisementPhoto;
        this.advertisementDescription = advertisementDescription;
        this.advertisementPublishDate = advertisementPublishDate;
        this.advertisementPrice = advertisementPrice;
        this.advertiser = advertiser;
        this.locality = locality;
        this.category = category;
    }

    public long idadvertisement() {
        return idAdvertisement;
    }

    public void setIdadvertisement(long idAdvertisement) {
        this.idAdvertisement = idAdvertisement;
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
                "idadvertisement=" + idAdvertisement +
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
