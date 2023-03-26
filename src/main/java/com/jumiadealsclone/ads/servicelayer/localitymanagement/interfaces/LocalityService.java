package com.jumiadealsclone.ads.servicelayer.localitymanagement.interfaces;

import com.jumiadealsclone.ads.modelelayer.Locality;
import com.jumiadealsclone.ads.modelelayer.LocalityType;

import java.util.List;
import java.util.Set;

public interface LocalityService {
    Locality findLocalityByLocalityType(LocalityType localityType);
    List<Locality> findAll();
}
