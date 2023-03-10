package com.jumiadealsclone.ads.modelelayer;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.*;

import java.util.Date;

@JsonPOJOBuilder
@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "idaccount",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAccount;

    @Column(name = "advertiserusername")
    private String advertiserUsername;

    @Column(name = "advertiserpassword")
    private String advertiserPassword;

    @Column(name = "advertiserphotoprofile")
    private String advertiserPhotoProfile;

    @Column(name = "advertiserlastlogindate")
    private Date advertiserLastLoginDate;

    public Account() {
    }

    public Account(String advertiserUsername, String advertiserPassword,
                   String advertiserPhotoProfile, Date advertiserLastLoginDate) {
        this.advertiserUsername = advertiserUsername;
        this.advertiserPassword = advertiserPassword;
        this.advertiserPhotoProfile = advertiserPhotoProfile;
        this.advertiserLastLoginDate = advertiserLastLoginDate;
    }

    public long idAccount() {
        return idAccount;
    }

    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
    }

    public String advertiserUsername() {
        return advertiserUsername;
    }

    public void setAdvertiserUsername(String advertiserUsername) {
        this.advertiserUsername = advertiserUsername;
    }

    public String advertiserPassword() {
        return advertiserPassword;
    }

    public void setAdvertiserPassword(String advertiserPassword) {
        this.advertiserPassword = advertiserPassword;
    }

    public String advertiserPhotoProfile() {
        return advertiserPhotoProfile;
    }

    public void setAdvertiserPhotoProfile(String advertiserPhotoProfile) {
        this.advertiserPhotoProfile = advertiserPhotoProfile;
    }

    public Date advertiserLastLoginDate() {
        return advertiserLastLoginDate;
    }

    public void setAdvertiserLastLoginDate(Date advertiserLastLoginDate) {
        this.advertiserLastLoginDate = advertiserLastLoginDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "idAccount=" + idAccount +
                ", advertiserUsername='" + advertiserUsername + '\'' +
                ", advertiserPassword='" + advertiserPassword + '\'' +
                ", advertiserPhotoProfile='" + advertiserPhotoProfile + '\'' +
                ", advertiserLastLoginDate=" + advertiserLastLoginDate +
                '}';
    }
}
