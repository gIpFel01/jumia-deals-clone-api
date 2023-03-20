package com.jumiadealsclone.ads.servicelayer.accountmanagement.impl;

import com.jumiadealsclone.ads.dto.AccountDTO;
import com.jumiadealsclone.ads.dto.mapper.AccountDTOMapper;
import com.jumiadealsclone.ads.modelelayer.Account;
import com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final ProfilePhotoService profilePhotoService;
    private final PasswordService passwordService;
    private final CreateAccount createAccount;
    private final DeleteAccount deleteAccount;
    private final UserExists userExists;
    private final AccountDTOMapper accountDTOMapper;

    @Autowired
    public AccountServiceImpl(ProfilePhotoService profilePhotoService, PasswordService passwordService,
                              CreateAccount createAccount, DeleteAccount deleteAccount,
                              UserExists userExists, AccountDTOMapper accountDTOMapper) {
        this.profilePhotoService = profilePhotoService;
        this.passwordService = passwordService;
        this.createAccount = createAccount;
        this.deleteAccount = deleteAccount;
        this.userExists = userExists;
        this.accountDTOMapper = accountDTOMapper;
    }

    @Override
    public AccountDTO findAccount(String username) {
        Account account = userExists.userFound(username);
        return this.accountDTOMapper.apply(account);
    }

    @Override
    public void createAccount(Account account) {
        createAccount.createAccount(account);
    }

    @Override
    public void deleteAccount(String username) {
        deleteAccount.deleteAccount(username);
    }

    @Override
    public void updateAccountPassword(String username, String newPassword) {
        passwordService.updatePassword(username, newPassword);
    }

    @Override
    public void updateAccountProfilePhoto(String username, String photoPath) {
        profilePhotoService.updatePhotoProfile(username, photoPath);
    }

    @Override
    public void deleteAccountProfilePhoto(String username) {
        profilePhotoService.deleteProfilePhoto(username);
    }
}
