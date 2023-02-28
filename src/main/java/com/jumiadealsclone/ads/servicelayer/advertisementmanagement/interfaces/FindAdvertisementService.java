package com.jumiadealsclone.ads.servicelayer.advertisementmanagement.interfaces;

import com.jumiadealsclone.ads.modelelayer.Advertisement;
import com.jumiadealsclone.ads.modelelayer.Advertiser;

import java.util.Set;

public interface FindAdvertisementService {
    Set<Advertisement> findAdvertisementByAdvertiser(Advertiser advertiser);

    Set<Advertisement> findRecentAdvertisement();
}
