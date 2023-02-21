package com.jumiadealsclone.ads.servicelayer.accountmanagement.impl;

import com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces.ProfilePhotoService;
import com.jumiadealsclone.ads.modelelayer.Account;
import com.jumiadealsclone.ads.repositorylayer.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfilePhotoServiceImpl implements ProfilePhotoService {
    private AccountRepository accountRepository;

    @Autowired
    public ProfilePhotoServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void shiftProfilePhoto(String username,String photoPath) {
        Account account = accountRepository.findAccountByAdvertiserUsername(username);
        account.setAdvertiserPhotoProfile(photoPath);
        accountRepository.save(account);
    }

    @Override
    public void deleteProfilePhoto(String username) {
        Account account = accountRepository.findAccountByAdvertiserUsername(username);
        account.setAdvertiserPhotoProfile(null);
        accountRepository.save(account);
    }
}
