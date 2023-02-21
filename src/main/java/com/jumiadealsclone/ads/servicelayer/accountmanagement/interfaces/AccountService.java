package com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces;

public interface AccountService {
    void shiftUsername(String currentUsername, String newUsername);
    void shiftPassword(String username, String newPassword);
    void shiftProfilePhoto(String username, String photoPath);
    void deleteProfilePhoto(String username);
}
