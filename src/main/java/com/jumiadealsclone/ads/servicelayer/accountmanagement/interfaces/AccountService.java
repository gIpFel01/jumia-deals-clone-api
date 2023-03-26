package com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces;

import com.jumiadealsclone.ads.dto.AccountDTO;
import com.jumiadealsclone.ads.modelelayer.Account;

public interface AccountService {
    AccountDTO findAccount(String username);
    void createAccount(Account account);
    void deleteAccount(String username);
    void updateAccountPassword(String username, String newPassword);
    void updateAccountProfilePhoto(String username, String photoPath);
    void deleteAccountProfilePhoto(String username);
}
