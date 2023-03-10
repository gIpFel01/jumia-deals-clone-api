package com.jumiadealsclone.ads.servicelayer.advertisermanagement.impl;

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
    public void createAdvertiser(Advertiser advertiser) {
        advertiserRepository.save(advertiser);
    }
}
