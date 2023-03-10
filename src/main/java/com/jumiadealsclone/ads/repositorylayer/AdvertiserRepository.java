package com.jumiadealsclone.ads.repositorylayer;

import com.jumiadealsclone.ads.modelelayer.Advertiser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdvertiserRepository extends JpaRepository<Advertiser, Long> {
    Optional<Advertiser> findAdvertiserByAdvertiserEmail(String email);

    Optional<Advertiser> findAdvertiserByAdvertiserPhoneNumber(String phoneNumber);
}
