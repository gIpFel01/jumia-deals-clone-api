package com.jumiadealsclone.ads.servicelayer.localitymanagement.impl;

import com.jumiadealsclone.ads.modelelayer.Locality;
import com.jumiadealsclone.ads.modelelayer.LocalityType;
import com.jumiadealsclone.ads.repositorylayer.LocalityRepository;
import com.jumiadealsclone.ads.servicelayer.localitymanagement.interfaces.LocalityExists;
import com.jumiadealsclone.ads.servicelayer.localitymanagement.interfaces.LocalityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalityServiceImpl implements LocalityService {

    private final LocalityExists localityExists;
    private final LocalityRepository localityRepository;

    public LocalityServiceImpl(LocalityExists localityExists,
                               LocalityRepository localityRepository) {
        this.localityExists = localityExists;
        this.localityRepository = localityRepository;
    }

    @Override
    public Locality findLocalityByLocalityType(LocalityType localityType) {
        return localityExists.localityExists(localityType);
    }

    @Override
    public List<Locality> findAll() {
        return localityRepository.findAll();
    }
}
