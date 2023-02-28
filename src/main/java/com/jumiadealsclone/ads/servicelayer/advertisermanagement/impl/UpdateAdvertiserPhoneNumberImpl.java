package com.jumiadealsclone.ads.servicelayer.advertisermanagement.impl;

import com.jumiadealsclone.ads.modelelayer.Advertiser;
import com.jumiadealsclone.ads.repositorylayer.AdvertiserRepository;
import com.jumiadealsclone.ads.servicelayer.advertisermanagement.interfaces.AdvertiserExists;
import com.jumiadealsclone.ads.servicelayer.advertisermanagement.interfaces.UpdateAdvertiserPhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateAdvertiserPhoneNumberImpl implements UpdateAdvertiserPhoneNumber {
    private final AdvertiserRepository advertiserRepository;
    private final AdvertiserExists advertiserExists;

    @Autowired
    public UpdateAdvertiserPhoneNumberImpl(AdvertiserRepository advertiserRepository, AdvertiserExists advertiserExists) {
        this.advertiserRepository = advertiserRepository;
        this.advertiserExists = advertiserExists;
    }

    @Override
    public void updateAdvertiserPhoneNumber(String phoneNumber, String newPhoneNumber) {
        advertiserExists.phoneNumberAlreadyExists(newPhoneNumber);
        Advertiser advertiser = advertiserExists.checkByPhoneNumber(phoneNumber);
        advertiser.setAdvertiserPhoneNumber(newPhoneNumber);
        advertiserRepository.save(advertiser);
    }
}
