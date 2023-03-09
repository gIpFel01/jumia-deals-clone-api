package com.jumiadealsclone.ads.servicelayer.accountmanagement.impl;

import com.jumiadealsclone.ads.modelelayer.Account;
import com.jumiadealsclone.ads.repositorylayer.AccountRepository;
import com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces.CreateAccount;
import com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces.UserExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void createAccount(Account account) {
            String username = account.advertiserUsername();
            userExists.userNotFound(username);
            accountRepository.save(account);
    }
}
