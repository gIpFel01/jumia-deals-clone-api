package com.jumiadealsclone.ads.servicelayer.advertisermanagement.interfaces;

import com.jumiadealsclone.ads.modelelayer.Account;
import com.jumiadealsclone.ads.modelelayer.Advertiser;

public interface AdvertiserService {
    void createAdvertiser(String firstName, String name,
                          String email, String phoneNumber,
                          String location, Account account);
    void updateAdvertiserEmail(String email, String newEmail);
    void updateAdvertiserPhoneNumber(String phoneNumber, String newPhoneNumber);
    Advertiser findAdvertiser(String email);
}
