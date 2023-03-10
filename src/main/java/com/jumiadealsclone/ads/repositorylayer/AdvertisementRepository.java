package com.jumiadealsclone.ads.repositorylayer;

import com.jumiadealsclone.ads.modelelayer.Advertisement;
import com.jumiadealsclone.ads.modelelayer.Advertiser;
import com.jumiadealsclone.ads.modelelayer.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    Optional<List<Advertisement>> findAdvertisementByLocality(Locality locality);

    Optional<Set<Advertisement>>findAdvertisementByAdvertisementPublishDate(Date date);

    Optional<Set<Advertisement>> findAdvertisementByAdvertiser(Advertiser advertiser);

    @Query(value = "SELECT * FROM advertisement WHERE advertisementpublishdate >= " +
            ": recentDate ORDER BY advertisementpublishdate DESC",
            nativeQuery = true)
    Optional<Set<Advertisement>> findRecentAdvertisement(Date recentDate);
}
