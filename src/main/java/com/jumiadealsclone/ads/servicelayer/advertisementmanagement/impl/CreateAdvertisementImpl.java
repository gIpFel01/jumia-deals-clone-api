package com.jumiadealsclone.ads.servicelayer.advertisementmanagement.impl;

import com.jumiadealsclone.ads.modelelayer.*;
import com.jumiadealsclone.ads.repositorylayer.AdvertisementRepository;
import com.jumiadealsclone.ads.servicelayer.advertisementmanagement.interfaces.CreateAdvertisement;
import com.jumiadealsclone.ads.servicelayer.advertisermanagement.interfaces.AdvertiserExists;
import com.jumiadealsclone.ads.servicelayer.categorymanagement.interfaces.CategoryExists;
import com.jumiadealsclone.ads.servicelayer.localitymanagement.interfaces.LocalityExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAdvertisementImpl implements CreateAdvertisement {
    private final AdvertisementRepository advertisementRepository;
    private final AdvertiserExists advertiserExists;
    private final LocalityExists localityExists;
    private final CategoryExists categoryExists;

    @Autowired
    public CreateAdvertisementImpl(AdvertisementRepository advertisementRepository,
                                   AdvertiserExists advertiserExists,
                                   LocalityExists localityExists,
                                   CategoryExists categoryExists) {
        this.advertisementRepository = advertisementRepository;
        this.advertiserExists = advertiserExists;
        this.localityExists = localityExists;
        this.categoryExists = categoryExists;
    }

    @Override
    public void createAdvertisement(Advertisement advertisement) {
        String email = advertisement.advertiser().advertiserEmail();
        Advertiser advertiser = this.advertiserExists.checkByEmail(email);
        LocalityType localityType = advertisement.locality().localityType();
        CategoryType categoryType = advertisement.category().categoryType();
        Locality locality = this.localityExists.localityExists(localityType);
        Category category = this.categoryExists.categoryExists(categoryType);
        advertisement.setAdvertiser(advertiser);
        advertisement.setLocality(locality);
        advertisement.setCategory(category);
        advertisementRepository.save(advertisement);
    }
}
