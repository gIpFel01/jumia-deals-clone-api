package com.jumiadealsclone.ads.servicelayer.advertisermanagement.impl;

import com.jumiadealsclone.ads.modelelayer.Advertiser;
import com.jumiadealsclone.ads.repositorylayer.AdvertiserRepository;
import com.jumiadealsclone.ads.servicelayer.advertisermanagement.interfaces.AdvertiserExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertiserExistsImpl implements AdvertiserExists {
    private final AdvertiserRepository advertiserRepository;

    @Autowired
    public AdvertiserExistsImpl(AdvertiserRepository advertiserRepository) {
        this.advertiserRepository = advertiserRepository;
    }

    @Override
    public Advertiser checkByEmail(String email) {
        Advertiser advertiser = advertiserRepository.findAdvertiserByAdvertiserEmail(email).orElse(null);
        if(advertiser == null){
            throw new IllegalStateException("User not found");
        }
        return advertiser;
    }

    @Override
    public Advertiser checkByPhoneNumber(String phoneNumber) {
        Advertiser advertiser = advertiserRepository.findAdvertiserByAdvertiserPhoneNumber(phoneNumber).orElse(null);
        if(advertiser == null){
            throw new IllegalStateException("User not found");
        }
        return advertiser;
    }

    @Override
    public void phoneNumberAlreadyExists(String phoneNumber){
        Advertiser advertiser = advertiserRepository.findAdvertiserByAdvertiserPhoneNumber(phoneNumber).orElse(null);
        if(advertiser != null){
            throw new IllegalStateException("User already exists");
        }
    }

    @Override
    public void emailAlreadyExists(String email) {
        Advertiser advertiser = advertiserRepository.findAdvertiserByAdvertiserEmail(email).orElse(null);
        if(advertiser != null){
            throw new IllegalStateException("User already exists");
        }
    }
}
