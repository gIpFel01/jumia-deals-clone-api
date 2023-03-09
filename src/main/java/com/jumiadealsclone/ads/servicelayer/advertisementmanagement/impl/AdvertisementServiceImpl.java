package com.jumiadealsclone.ads.servicelayer.advertisementmanagement.impl;

import com.jumiadealsclone.ads.modelelayer.Advertisement;
import com.jumiadealsclone.ads.modelelayer.Advertiser;
import com.jumiadealsclone.ads.servicelayer.advertisementmanagement.interfaces.AdvertisementService;
import com.jumiadealsclone.ads.servicelayer.advertisementmanagement.interfaces.CreateAdvertisement;
import com.jumiadealsclone.ads.servicelayer.advertisementmanagement.interfaces.DeleteAdvertisement;
import com.jumiadealsclone.ads.servicelayer.advertisementmanagement.interfaces.FindAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {
    private final DeleteAdvertisement deleteAdvertisement;
    private final CreateAdvertisement createAdvertisement;
    private final FindAdvertisementService findAdvertisementService;

    @Autowired
    public AdvertisementServiceImpl(DeleteAdvertisement deleteAdvertisement,
                                    CreateAdvertisement createAdvertisement,
                                    FindAdvertisementService findAdvertisementService) {
        this.deleteAdvertisement = deleteAdvertisement;
        this.createAdvertisement = createAdvertisement;
        this.findAdvertisementService = findAdvertisementService;
    }

    @Override
    public void createAdvertisement(Advertisement advertisement) {
        createAdvertisement.createAdvertisement(advertisement);
    }

    @Override
    public void deleteAdvertisement(long id) {
        deleteAdvertisement.deleteAdvertisement(id);
    }

    @Override
    public Set<Advertisement> findAdvertisementByAdvertiser(Advertiser advertiser) {
        return findAdvertisementService.findAdvertisementByAdvertiser(advertiser) ;
    }

    @Override
    public Set<Advertisement> findRecentAdvertisement() {
        return findAdvertisementService.findRecentAdvertisement();
    }
}
