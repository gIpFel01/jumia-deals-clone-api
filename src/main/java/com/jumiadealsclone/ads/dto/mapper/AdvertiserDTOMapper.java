package com.jumiadealsclone.ads.dto.mapper;

import com.jumiadealsclone.ads.dto.AdvertiserDTO;
import com.jumiadealsclone.ads.modelelayer.Advertiser;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AdvertiserDTOMapper implements Function<Advertiser, AdvertiserDTO> {
    @Override
    public AdvertiserDTO apply(Advertiser advertiser) {
        return new AdvertiserDTO(
                advertiser.idAdvertiser(),
                advertiser.advertiserFirstName(),
                advertiser.advertiserName(),
                advertiser.advertiserEmail(),
                advertiser.advertiserPhoneNumber()
        );
    }
}
