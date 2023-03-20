package com.jumiadealsclone.ads.servicelayer.advertisementmanagement.impl;

import com.jumiadealsclone.ads.dto.AdvertisementDTO;
import com.jumiadealsclone.ads.dto.mapper.AdvertisementDTOMapper;
import com.jumiadealsclone.ads.dto.mapper.AdvertiserDTOMapper;
import com.jumiadealsclone.ads.modelelayer.Advertisement;
import com.jumiadealsclone.ads.modelelayer.Advertiser;
import com.jumiadealsclone.ads.servicelayer.advertisementmanagement.interfaces.AdvertisementService;
import com.jumiadealsclone.ads.servicelayer.advertisementmanagement.interfaces.CreateAdvertisement;
import com.jumiadealsclone.ads.servicelayer.advertisementmanagement.interfaces.DeleteAdvertisement;
import com.jumiadealsclone.ads.servicelayer.advertisementmanagement.interfaces.FindAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {
    private final DeleteAdvertisement deleteAdvertisement;
    private final CreateAdvertisement createAdvertisement;
    private final FindAdvertisementService findAdvertisementService;
    private final AdvertisementDTOMapper advertisementDTOMapper;

    @Autowired
    public AdvertisementServiceImpl(DeleteAdvertisement deleteAdvertisement,
                                    CreateAdvertisement createAdvertisement,
                                    FindAdvertisementService findAdvertisementService,
                                    AdvertisementDTOMapper advertisementDTOMapper) {
        this.deleteAdvertisement = deleteAdvertisement;
        this.createAdvertisement = createAdvertisement;
        this.findAdvertisementService = findAdvertisementService;
        this.advertisementDTOMapper = advertisementDTOMapper;
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
    public Set<AdvertisementDTO> findAdvertisementByAdvertiser(Advertiser advertiser) {
        return findAdvertisementService.findAdvertisementByAdvertiser(advertiser)
                .stream()
                .map(advertisementDTOMapper)
                .collect(Collectors.toSet());
    }

    @Override
    public List<AdvertisementDTO> findRecentAdvertisement() {
        return findAdvertisementService.findRecentAdvertisement()
                .stream()
                .map(advertisementDTOMapper)
                .collect(Collectors.toList());
    }
}
