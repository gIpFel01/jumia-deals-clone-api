package com.jumiadealsclone.ads.servicelayer.advertisermanagement.interfaces;

import com.jumiadealsclone.ads.modelelayer.Advertiser;

public interface AdvertiserService {
    void createAdvertiser(Advertiser advertiser);
    void updateAdvertiserEmail(String email, String newEmail);
    void updateAdvertiserPhoneNumber(String phoneNumber, String newPhoneNumber);
    Advertiser findAdvertiser(String email);
}
