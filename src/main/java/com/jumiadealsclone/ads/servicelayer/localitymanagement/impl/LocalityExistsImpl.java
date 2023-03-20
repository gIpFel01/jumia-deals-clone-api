package com.jumiadealsclone.ads.servicelayer.localitymanagement.impl;

import com.jumiadealsclone.ads.modelelayer.Locality;
import com.jumiadealsclone.ads.modelelayer.LocalityType;
import com.jumiadealsclone.ads.repositorylayer.LocalityRepository;
import com.jumiadealsclone.ads.servicelayer.localitymanagement.exception.LocalityExistsException;
import com.jumiadealsclone.ads.servicelayer.localitymanagement.interfaces.LocalityExists;
import org.springframework.stereotype.Service;

@Service
public class LocalityExistsImpl implements LocalityExists {

    private final LocalityRepository localityRepository;

    public LocalityExistsImpl(LocalityRepository localityRepository) {
        this.localityRepository = localityRepository;
    }

    @Override
    public Locality localityExists(LocalityType localityType) {
        Locality locality = localityRepository.findLocalityByLocalityType(localityType).orElse(null);
        if(locality == null){
            throw new LocalityExistsException("Locality not found");
        }
        return locality;
    }
}
