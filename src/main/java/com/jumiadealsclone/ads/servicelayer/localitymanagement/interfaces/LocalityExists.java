package com.jumiadealsclone.ads.servicelayer.localitymanagement.interfaces;

import com.jumiadealsclone.ads.modelelayer.Locality;
import com.jumiadealsclone.ads.modelelayer.LocalityType;

public interface LocalityExists {
    Locality localityExists(LocalityType localityType);
}
