package com.jumiadealsclone.ads.servicelayer.accountmanagement.impl;

import com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces.ProfilePhotoService;
import com.jumiadealsclone.ads.modelelayer.Account;
import com.jumiadealsclone.ads.repositorylayer.AccountRepository;
import com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces.UserExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfilePhotoServiceImpl implements ProfilePhotoService {
    private final AccountRepository accountRepository;
    private final UserExists userExists;

    @Autowired
    public ProfilePhotoServiceImpl(AccountRepository accountRepository, UserExists userExists) {
        this.accountRepository = accountRepository;
        this.userExists = userExists;
    }

    @Override
    public void updatePhotoProfile(String username,String photoPath) {
        Account account = userExists.userFound(username);
        account.setAdvertiserPhotoProfile(photoPath);
        accountRepository.save(account);
    }

    @Override
    public void deleteProfilePhoto(String username) {
        Account account = userExists.userFound(username);
        account.setAdvertiserPhotoProfile("");
        accountRepository.save(account);
    }
}
