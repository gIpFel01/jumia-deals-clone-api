package com.jumiadealsclone.ads.repositorylayer;

import com.jumiadealsclone.ads.modelelayer.Locality;
import com.jumiadealsclone.ads.modelelayer.LocalityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalityRepository extends JpaRepository<Locality, Long> {

    Optional<Locality> findLocalityByLocalityType(LocalityType localityType);
}
