package com.jumiadealsclone.ads.servicelayer.advertisermanagement.impl;

import com.jumiadealsclone.ads.modelelayer.Advertiser;
import com.jumiadealsclone.ads.servicelayer.advertisermanagement.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertiserServiceImpl implements AdvertiserService {

    private final CreateAdvertiser createAdvertiser;
    private final UpdateAdvertiserEmail updateAdvertiserEmail;
    private final UpdateAdvertiserPhoneNumber updateAdvertiserPhoneNumber;
    private final AdvertiserExists advertiserExists;

    @Autowired
    public AdvertiserServiceImpl(CreateAdvertiser createAdvertiser, UpdateAdvertiserEmail updateAdvertiserEmail,
                                 UpdateAdvertiserPhoneNumber updateAdvertiserPhoneNumber, AdvertiserExists advertiserExists) {
        this.createAdvertiser = createAdvertiser;
        this.updateAdvertiserEmail = updateAdvertiserEmail;
        this.updateAdvertiserPhoneNumber = updateAdvertiserPhoneNumber;
        this.advertiserExists = advertiserExists;
    }

    @Override
    public void createAdvertiser(Advertiser advertiser) {
        createAdvertiser.createAdvertiser(advertiser);
    }

    @Override
    public void updateAdvertiserEmail(String email, String newEmail) {
        updateAdvertiserEmail.updateAdvertiserEmail(email,newEmail);
    }

    @Override
    public void updateAdvertiserPhoneNumber(String phoneNumber, String newPhoneNumber) {
        updateAdvertiserPhoneNumber.updateAdvertiserPhoneNumber(phoneNumber, newPhoneNumber);
    }


    @Override
    public Advertiser findAdvertiser(String email) {
    return advertiserExists.checkByEmail(email);
    }
}
