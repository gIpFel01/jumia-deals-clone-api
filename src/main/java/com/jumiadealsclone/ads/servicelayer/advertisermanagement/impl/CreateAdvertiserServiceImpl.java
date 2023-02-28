package com.jumiadealsclone.ads.servicelayer.advertisermanagement.impl;

import com.jumiadealsclone.ads.modelelayer.Account;
import com.jumiadealsclone.ads.modelelayer.Advertiser;
import com.jumiadealsclone.ads.repositorylayer.AdvertiserRepository;
import com.jumiadealsclone.ads.servicelayer.advertisermanagement.interfaces.CreateAdvertiser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAdvertiserServiceImpl implements CreateAdvertiser {
    private final AdvertiserRepository advertiserRepository;

    @Autowired
    public CreateAdvertiserServiceImpl(AdvertiserRepository advertiserRepository) {
        this.advertiserRepository = advertiserRepository;
    }

    @Override
    public void createAdvertiser(String firstName, String name,
                                 String email, String phoneNumber,
                                 String location, Account account) {
        Advertiser advertiser = new Advertiser(firstName,name,email,phoneNumber,location, account);
        advertiserRepository.save(advertiser);
    }
}
