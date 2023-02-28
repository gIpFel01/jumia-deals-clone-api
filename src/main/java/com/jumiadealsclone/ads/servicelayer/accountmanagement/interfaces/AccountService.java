package com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces;

import com.jumiadealsclone.ads.modelelayer.Account;

import java.util.Date;

public interface AccountService {
    Account findAccount(String username);
    Account createAccount(String username, String password,
                       String photoProfile, Date lastLoginDate);
    void deleteAccount(String username);
    void updateAccountPassword(String username, String newPassword);
    void updateAccountProfilePhoto(String username, String photoPath);
    void deleteAccountProfilePhoto(String username);
}
