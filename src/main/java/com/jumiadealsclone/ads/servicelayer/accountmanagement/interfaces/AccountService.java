package com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces;

import com.jumiadealsclone.ads.modelelayer.Account;

public interface AccountService {
    Account findAccount(String username);
    void createAccount(Account account);
    void deleteAccount(String username);
    void updateAccountPassword(String username, String newPassword);
    void updateAccountProfilePhoto(String username, String photoPath);
    void deleteAccountProfilePhoto(String username);
}
