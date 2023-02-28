package com.jumiadealsclone.ads.servicelayer.accountmanagement.impl;

import com.jumiadealsclone.ads.modelelayer.Account;
import com.jumiadealsclone.ads.modelelayer.Advertiser;
import com.jumiadealsclone.ads.repositorylayer.AccountRepository;
import com.jumiadealsclone.ads.repositorylayer.AdvertiserRepository;
import com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces.CreateAccount;
import com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces.UserExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CreateAccountImpl implements CreateAccount {
    private final AccountRepository accountRepository;
    private final UserExists userExists;

    @Autowired
    public CreateAccountImpl(AccountRepository accountRepository, UserExists userExists) {
        this.accountRepository = accountRepository;
        this.userExists = userExists;
    }

    @Override
    public Account createAccount(String username, String password,
                              String photoProfile, Date lastLoginDate) {
            userExists.userNotFound(username);
            Account account = new Account(username, password, photoProfile, lastLoginDate);
            accountRepository.save(account);
            return account;
    }
}
