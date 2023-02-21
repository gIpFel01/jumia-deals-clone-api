package com.jumiadealsclone.ads.repositorylayer;

import com.jumiadealsclone.ads.modelelayer.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
}
