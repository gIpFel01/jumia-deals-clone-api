package com.jumiadealsclone.ads.servicelayer.advertisementmanagement.impl;

import com.jumiadealsclone.ads.modelelayer.Advertisement;
import com.jumiadealsclone.ads.repositorylayer.AdvertisementRepository;
import com.jumiadealsclone.ads.servicelayer.advertisementmanagement.interfaces.CreateAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAdvertisementImpl implements CreateAdvertisement {
    private final AdvertisementRepository advertisementRepository;

    @Autowired
    public CreateAdvertisementImpl(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    @Override
    public void createAdvertisement(Advertisement advertisement) {
        advertisementRepository.save(advertisement);
    }
}
