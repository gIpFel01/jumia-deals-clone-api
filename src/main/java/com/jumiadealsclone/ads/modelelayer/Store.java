package com.jumiadealsclone.ads.modelelayer;

import jakarta.persistence.*;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @Column(name = "idstore")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idStore;

    @Column(name = "storename")
    private String storeName;

    @Column(name = "storeaddress")
    private String storeAddress;

    @Column(name = "storephoto")
    private String storePhoto;

    @Column(name = "storedescription")
    private String storeDescription;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Advertiser advertiser;

    public Store() {
    }

    public long idStore() {
        return idStore;
    }

    public void setIdStore(long idStore) {
        this.idStore = idStore;
    }

    public String storeName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String storeAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String storePhoto() {
        return storePhoto;
    }

    public void setStorePhoto(String storePhoto) {
        this.storePhoto = storePhoto;
    }

    public String storeDescription() {
        return storeDescription;
    }

    public void setStoreDescription(String storeDescription) {
        this.storeDescription = storeDescription;
    }

    public Advertiser advertiser() {
        return advertiser;
    }

    public void setAdvertiser(Advertiser advertiser) {
        this.advertiser = advertiser;
    }

    @Override
    public String toString() {
        return "Store{" +
                "idStore=" + idStore +
                ", storeName='" + storeName + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storePhoto='" + storePhoto + '\'' +
                ", storeDescription='" + storeDescription + '\'' +
                ", advertiser=" + advertiser +
                '}';
    }
}
