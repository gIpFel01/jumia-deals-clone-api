package com.jumiadealsclone.ads.repositorylayer;

import com.jumiadealsclone.ads.modelelayer.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalityRepository extends JpaRepository<Locality, Long> {
}
