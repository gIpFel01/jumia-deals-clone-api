package com.jumiadealsclone.ads.servicelayer.accountmanagement.impl;

import com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces.AccountService;
import com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces.ProfilePhotoService;
import com.jumiadealsclone.ads.modelelayer.Account;
import com.jumiadealsclone.ads.repositorylayer.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    private ProfilePhotoService profilePhotoService;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, ProfilePhotoService profilePhotoService) {
        this.accountRepository = accountRepository;
        this.profilePhotoService = profilePhotoService;
    }

    @Override
    public void shiftUsername(String currentUsername,String newUername) {
        Account account = accountRepository.findAccountByAdvertiserUsername(currentUsername);
        account.setAdvertiserUsername(newUername);
        accountRepository.save(account);
    }

    @Override
    public void shiftPassword(String username, String newPassword) {
        Account account = accountRepository.findAccountByAdvertiserUsername(username);
        account.setAdvertiserPassword(newPassword);
        accountRepository.save(account);
    }

    @Override
    public void shiftProfilePhoto(String username, String photoPath) {
        profilePhotoService.shiftProfilePhoto(username,photoPath);
    }

    @Override
    public void deleteProfilePhoto(String username) {
        profilePhotoService.deleteProfilePhoto(username);
    }
}
