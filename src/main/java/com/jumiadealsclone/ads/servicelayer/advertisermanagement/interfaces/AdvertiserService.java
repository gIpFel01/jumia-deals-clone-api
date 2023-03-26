package com.jumiadealsclone.ads.servicelayer.advertisermanagement.interfaces;

import com.jumiadealsclone.ads.controllerlayer.AuthenticationRequest;
import com.jumiadealsclone.ads.controllerlayer.AuthenticationResponse;
import com.jumiadealsclone.ads.modelelayer.Advertiser;

import java.security.NoSuchAlgorithmException;

public interface AdvertiserService {
    AuthenticationResponse createAdvertiser(Advertiser advertiser) throws NoSuchAlgorithmException;
    void updateAdvertiserEmail(String email, String newEmail);
    void updateAdvertiserPhoneNumber(String phoneNumber, String newPhoneNumber);
    Advertiser findAdvertiser(String email);
    AuthenticationResponse authenticate(AuthenticationRequest request) throws NoSuchAlgorithmException;
    }
