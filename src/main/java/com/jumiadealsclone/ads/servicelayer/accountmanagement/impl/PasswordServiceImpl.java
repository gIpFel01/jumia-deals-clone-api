package com.jumiadealsclone.ads.servicelayer.accountmanagement.impl;

import com.jumiadealsclone.ads.modelelayer.Account;
import com.jumiadealsclone.ads.repositorylayer.AccountRepository;
import com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces.PasswordService;
import com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces.UserExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {
    private final AccountRepository accountRepository;
    private final UserExists userExists;

    @Autowired
    public PasswordServiceImpl(AccountRepository accountRepository,UserExists userExists) {
        this.accountRepository = accountRepository;
        this.userExists = userExists;
    }

    @Override
    public void updatePassword(String username, String newPassword) {
        Account account = userExists.userFound(username);
        account.setAdvertiserPassword(newPassword);
        accountRepository.save(account);
    }
}
