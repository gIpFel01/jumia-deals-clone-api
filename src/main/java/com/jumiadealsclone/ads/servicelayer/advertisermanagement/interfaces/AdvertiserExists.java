package com.jumiadealsclone.ads.servicelayer.advertisermanagement.interfaces;

import com.jumiadealsclone.ads.modelelayer.Advertiser;

public interface AdvertiserExists {
    Advertiser checkByEmail(String email);
    Advertiser checkByPhoneNumber(String phoneNumber);
    void phoneNumberAlreadyExists(String phoneNumber);
    void emailAlreadyExists(String email);
}
