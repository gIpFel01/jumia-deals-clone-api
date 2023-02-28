package com.jumiadealsclone.ads.servicelayer.advertisementmanagement.impl;

import com.jumiadealsclone.ads.modelelayer.Advertisement;
import com.jumiadealsclone.ads.modelelayer.Advertiser;
import com.jumiadealsclone.ads.modelelayer.Category;
import com.jumiadealsclone.ads.modelelayer.Locality;
import com.jumiadealsclone.ads.repositorylayer.AdvertisementRepository;
import com.jumiadealsclone.ads.servicelayer.advertisementmanagement.interfaces.CreateAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class CreateAdvertisementImpl implements CreateAdvertisement {
    private final AdvertisementRepository advertisementRepository;

    @Autowired
    public CreateAdvertisementImpl(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    @Override
    public void createAdvertisement(String photo,String description,Date date,long price, Advertiser advertiser,
                                    Locality locality, Category category) {
        Advertisement advertisement = new Advertisement(photo, description,date,price,advertiser,locality,category);
        advertisementRepository.save(advertisement);
    }
}
