package com.jumiadealsclone.ads.repositorylayer;

import com.jumiadealsclone.ads.modelelayer.Advertiser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertiserRepository extends JpaRepository<Advertiser, Long> {
}
