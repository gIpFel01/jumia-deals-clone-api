package com.jumiadealsclone.ads.dto;

import com.jumiadealsclone.ads.modelelayer.Account;
import com.jumiadealsclone.ads.modelelayer.Advertiser;

public class DataWrapper {
    private Account account;
    private Advertiser advertiser;

    public Account account() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Advertiser advertiser() {
        return advertiser;
    }

    public void setAdvertiser(Advertiser advertiser) {
        this.advertiser = advertiser;
    }
}
