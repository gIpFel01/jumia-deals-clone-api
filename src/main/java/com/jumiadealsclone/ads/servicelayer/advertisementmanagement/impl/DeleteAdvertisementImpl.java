package com.jumiadealsclone.ads.servicelayer.advertisementmanagement.impl;

import com.jumiadealsclone.ads.modelelayer.Advertisement;
import com.jumiadealsclone.ads.modelelayer.Advertiser;
import com.jumiadealsclone.ads.repositorylayer.AdvertisementRepository;
import com.jumiadealsclone.ads.repositorylayer.AdvertiserRepository;
import com.jumiadealsclone.ads.servicelayer.advertisementmanagement.interfaces.DeleteAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteAdvertisementImpl implements DeleteAdvertisement {
    private final AdvertisementRepository advertisementRepository;
    private final AdvertiserRepository advertiserRepository;

    @Autowired
    public DeleteAdvertisementImpl(AdvertisementRepository advertisementRepository,
                                   AdvertiserRepository advertiserRepository) {
        this.advertisementRepository = advertisementRepository;
        this.advertiserRepository = advertiserRepository;
    }

    @Override
    public void deleteAdvertisement(long id) {
        Advertisement advertisement = advertisementRepository.findById(id).orElse(null);
        if(advertisement != null){
            Advertiser advertiser = advertisement.advertiser();
            advertiser.advertisements().removeIf(advertisement1 -> advertisement == advertisement1);
            advertisementRepository.delete(advertisement);
            advertiserRepository.save(advertiser);
        }
    }
}
