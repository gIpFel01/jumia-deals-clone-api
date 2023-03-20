package com.jumiadealsclone.ads.dto.mapper;

import com.jumiadealsclone.ads.dto.AdvertisementDTO;
import com.jumiadealsclone.ads.dto.AdvertiserDTO;
import com.jumiadealsclone.ads.modelelayer.Advertisement;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AdvertisementDTOMapper implements Function<Advertisement, AdvertisementDTO> {
    @Override
    public AdvertisementDTO apply(Advertisement advertisement) {
        AdvertiserDTOMapper advertiserDTOMapper = new AdvertiserDTOMapper();
        return new AdvertisementDTO(
                advertisement.idadvertisement(),
                advertisement.advertisementPhoto(),
                advertisement.advertisementDescription(),
                advertisement.advertisementPublishDate(),
                advertisement.advertisementPrice(),
                advertiserDTOMapper.apply(advertisement.advertiser()),
                advertisement.locality().localityType(),
                advertisement.category().categoryType()
        );
    }
}
