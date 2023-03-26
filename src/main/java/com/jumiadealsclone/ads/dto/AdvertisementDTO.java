package com.jumiadealsclone.ads.dto;

import com.jumiadealsclone.ads.modelelayer.Category;
import com.jumiadealsclone.ads.modelelayer.CategoryType;
import com.jumiadealsclone.ads.modelelayer.Locality;
import com.jumiadealsclone.ads.modelelayer.LocalityType;

import java.util.Date;

public record AdvertisementDTO(
        long idAdvertisement,
        String advertisementPhoto,
        String advertisementDescription,
        Date advertisementPublishDate,
        long advertisementPrice,
        AdvertiserDTO advertiserDTO,
        LocalityType localityType,
        CategoryType categoryType) {
}
