package com.jumiadealsclone.ads.servicelayer.advertisementmanagement.interfaces;

import com.jumiadealsclone.ads.modelelayer.Advertisement;
import com.jumiadealsclone.ads.modelelayer.Advertiser;
import com.jumiadealsclone.ads.modelelayer.Category;
import com.jumiadealsclone.ads.modelelayer.Locality;

import java.util.Date;
import java.util.Set;

public interface AdvertisementService {
    void createAdvertisement(String photo, String description, Date date, long price, Advertiser advertiser,
                             Locality locality, Category category);
    void deleteAdvertisement(long id);

    Set<Advertisement> findAdvertisementByAdvertiser(Advertiser advertiser);

    Set<Advertisement> findRecentAdvertisement();
}
