package com.jumiadealsclone.ads.repositorylayer;

import com.jumiadealsclone.ads.modelelayer.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountByAdvertiserUsername(String username);
}
