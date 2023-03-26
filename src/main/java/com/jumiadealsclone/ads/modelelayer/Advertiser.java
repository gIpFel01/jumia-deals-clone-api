package com.jumiadealsclone.ads.modelelayer;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "advertiser")
public class Advertiser implements UserDetails {

    @Id
    @Column(name = "idadvertiser",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAdvertiser;

    @Column(name = "advertiserfirstname")
    private String advertiserFirstName;

    @Column(name = "advertisername")
    private String advertiserName;

    @Column(name = "advertiseremail")
    private String advertiserEmail;

    @Column(name = "advertiserphonenumber")
    private String advertiserPhoneNumber;

    @Column(name = "advertiserlocation")
    private String advertiserLocation;

    @OneToMany(mappedBy = "advertiser", cascade = CascadeType.ALL)
    Set<Advertisement> advertisements;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idaccount")
    private Account account;

    public Advertiser(String advertiserFirstName, String advertiserName,
                      String advertiserEmail, String advertiserPhoneNumber,
                      String advertiserLocation, Account account) {
        this.advertiserFirstName = advertiserFirstName;
        this.advertiserName = advertiserName;
        this.advertiserEmail = advertiserEmail;
        this.advertiserPhoneNumber = advertiserPhoneNumber;
        this.advertiserLocation = advertiserLocation;
        this.account = account;
    }

    public Account account() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Advertiser() {
    }

    public long idAdvertiser() {
        return idAdvertiser;
    }

    public void setIdAdvertiser(long idAdvertiser) {
        this.idAdvertiser = idAdvertiser;
    }

    public String advertiserFirstName() {
        return advertiserFirstName;
    }

    public void setAdvertiserFirstName(String advertiserFirstName) {
        this.advertiserFirstName = advertiserFirstName;
    }

    public String advertiserName() {
        return advertiserName;
    }

    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName;
    }

    public String advertiserEmail() {
        return advertiserEmail;
    }

    public void setAdvertiserEmail(String advertiserEmail) {
        this.advertiserEmail = advertiserEmail;
    }

    public String advertiserPhoneNumber() {
        return advertiserPhoneNumber;
    }

    public void setAdvertiserPhoneNumber(String advertiserPhoneNumber) {
        this.advertiserPhoneNumber = advertiserPhoneNumber;
    }

    public String advertiserLocation() {
        return advertiserLocation;
    }

    public void setAdvertiserLocation(String advertiserLocation) {
        this.advertiserLocation = advertiserLocation;
    }

    public Set<Advertisement> advertisements() {
        return advertisements;
    }

    public void setAdvertisements(Set<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    @Override
    public String toString() {
        return "Advertiser{" +
                "idAdvertiser=" + idAdvertiser +
                ", advertiserFirstName='" + advertiserFirstName + '\'' +
                ", advertiserName='" + advertiserName + '\'' +
                ", advertiserEmail='" + advertiserEmail + '\'' +
                ", advertiserPhoneNumber='" + advertiserPhoneNumber + '\'' +
                ", advertiserLocation='" + advertiserLocation + '\'' +
                ", advertisements=" + advertisements +
                ", account=" + account +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return account().advertiserPassword();
    }

    @Override
    public String getUsername() {
        return advertiserEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
