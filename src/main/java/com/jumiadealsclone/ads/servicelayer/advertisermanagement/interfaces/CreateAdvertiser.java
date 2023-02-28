package com.jumiadealsclone.ads.servicelayer.advertisermanagement.interfaces;

import com.jumiadealsclone.ads.modelelayer.Account;

public interface CreateAdvertiser {
    void createAdvertiser(String firstName, String name,
                          String email, String phoneNumber,
                          String location, Account account);
}
