package com.jumiadealsclone.ads.servicelayer.advertisementmanagement.impl;

import com.jumiadealsclone.ads.modelelayer.Advertisement;
import com.jumiadealsclone.ads.modelelayer.Advertiser;
import com.jumiadealsclone.ads.repositorylayer.AdvertisementRepository;
import com.jumiadealsclone.ads.servicelayer.advertisementmanagement.interfaces.FindAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Service
public class FindAdvertisementImpl implements FindAdvertisementService {
    private final AdvertisementRepository advertisementRepository;
    private final int RECENT_DATE = 3;

    @Autowired
    public FindAdvertisementImpl(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    @Override
    public Set<Advertisement> findAdvertisementByAdvertiser(Advertiser advertiser) {
        return advertisementRepository.findAdvertisementByAdvertiser(advertiser).orElse(null);
    }

    @Override
    public Set<Advertisement> findRecentAdvertisement() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -RECENT_DATE);
        Date threeDaysAgo = calendar.getTime();
        return advertisementRepository.findRecentAdvertisement(threeDaysAgo).orElse(null);
        }
}
