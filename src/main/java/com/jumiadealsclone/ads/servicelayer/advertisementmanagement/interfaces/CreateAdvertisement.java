package com.jumiadealsclone.ads.servicelayer.advertisementmanagement.interfaces;

import com.jumiadealsclone.ads.modelelayer.Advertiser;
import com.jumiadealsclone.ads.modelelayer.Category;
import com.jumiadealsclone.ads.modelelayer.Locality;

import java.util.Date;

public interface CreateAdvertisement {
    void createAdvertisement(String photo, String description,Date date, long price, Advertiser advertiser,
                             Locality locality, Category category);
}
