package com.jumiadealsclone.ads.servicelayer.accountmanagement.impl;

import com.jumiadealsclone.ads.modelelayer.Account;
import com.jumiadealsclone.ads.repositorylayer.AccountRepository;
import com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces.DeleteAccount;
import com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces.UserExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteAccountImpl implements DeleteAccount {
    private final AccountRepository accountRepository;
    private final UserExists userExists;

    @Autowired
    public DeleteAccountImpl(AccountRepository accountRepository, UserExists userExists) {
        this.accountRepository = accountRepository;
        this.userExists = userExists;
    }

    @Override
    public void deleteAccount(String username) {
        Account account = userExists.userFound(username);
        accountRepository.delete(account);
    }
}
