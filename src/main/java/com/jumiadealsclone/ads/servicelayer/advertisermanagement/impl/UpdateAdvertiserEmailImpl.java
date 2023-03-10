package com.jumiadealsclone.ads.servicelayer.advertisermanagement.impl;

import com.jumiadealsclone.ads.modelelayer.Advertiser;
import com.jumiadealsclone.ads.repositorylayer.AdvertiserRepository;
import com.jumiadealsclone.ads.servicelayer.advertisermanagement.interfaces.AdvertiserExists;
import com.jumiadealsclone.ads.servicelayer.advertisermanagement.interfaces.UpdateAdvertiserEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateAdvertiserEmailImpl implements UpdateAdvertiserEmail {

    private final AdvertiserRepository advertiserRepository;
    private final AdvertiserExists advertiserExists;

    @Autowired
    public UpdateAdvertiserEmailImpl(AdvertiserRepository advertiserRepository, AdvertiserExists advertiserExists) {
        this.advertiserRepository = advertiserRepository;
        this.advertiserExists = advertiserExists;
    }

    @Override
    public void updateAdvertiserEmail(String email, String newEmail) {
        advertiserExists.emailAlreadyExists(newEmail);
        Advertiser advertiser = advertiserExists.checkByEmail(email);
        advertiser.setAdvertiserEmail(newEmail);
        advertiserRepository.save(advertiser);
    }
}
