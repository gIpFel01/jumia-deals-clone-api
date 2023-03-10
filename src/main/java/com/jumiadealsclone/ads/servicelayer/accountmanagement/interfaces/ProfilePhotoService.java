package com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces;

public interface ProfilePhotoService {
    void updatePhotoProfile(String username,String photoPath);
    void deleteProfilePhoto(String username);
}
