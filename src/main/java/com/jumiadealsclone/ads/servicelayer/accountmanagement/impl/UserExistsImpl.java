package com.jumiadealsclone.ads.servicelayer.accountmanagement.impl;

import com.jumiadealsclone.ads.modelelayer.Account;
import com.jumiadealsclone.ads.repositorylayer.AccountRepository;
import com.jumiadealsclone.ads.servicelayer.accountmanagement.exception.UserExistsException;
import com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces.UserExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserExistsImpl implements UserExists {
    private final AccountRepository accountRepository;
    @Autowired
    public UserExistsImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account userFound(String username) {
        Account account = accountRepository.findAccountByAdvertiserUsername(username).orElse(null);
        if(account == null){
            throw new UserExistsException("User not found");
        }
        return account;
    }

    @Override
    public void userNotFound(String username) {
        Account account = accountRepository.findAccountByAdvertiserUsername(username).orElse(null);
        if(account != null){
            throw new UserExistsException("User already exists");
        }
    }
}
