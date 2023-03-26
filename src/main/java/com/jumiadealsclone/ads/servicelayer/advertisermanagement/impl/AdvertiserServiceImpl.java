package com.jumiadealsclone.ads.servicelayer.advertisermanagement.impl;

import com.jumiadealsclone.ads.controllerlayer.AuthenticationRequest;
import com.jumiadealsclone.ads.controllerlayer.AuthenticationResponse;
import com.jumiadealsclone.ads.modelelayer.Advertiser;
import com.jumiadealsclone.ads.security.JwtUtil;
import com.jumiadealsclone.ads.servicelayer.advertisermanagement.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class AdvertiserServiceImpl implements AdvertiserService {

    private final CreateAdvertiser createAdvertiser;
    private final UpdateAdvertiserEmail updateAdvertiserEmail;
    private final UpdateAdvertiserPhoneNumber updateAdvertiserPhoneNumber;
    private final AdvertiserExists advertiserExists;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AdvertiserServiceImpl(CreateAdvertiser createAdvertiser, UpdateAdvertiserEmail updateAdvertiserEmail,
                                 UpdateAdvertiserPhoneNumber updateAdvertiserPhoneNumber, AdvertiserExists advertiserExists,
                                 JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.createAdvertiser = createAdvertiser;
        this.updateAdvertiserEmail = updateAdvertiserEmail;
        this.updateAdvertiserPhoneNumber = updateAdvertiserPhoneNumber;
        this.advertiserExists = advertiserExists;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthenticationResponse createAdvertiser(Advertiser advertiser) throws NoSuchAlgorithmException {
        createAdvertiser.createAdvertiser(advertiser);
        String jwtToken = jwtUtil.generateToken(advertiser);
        System.out.println(jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public void updateAdvertiserEmail(String email, String newEmail) {
        updateAdvertiserEmail.updateAdvertiserEmail(email,newEmail);
    }

    @Override
    public void updateAdvertiserPhoneNumber(String phoneNumber, String newPhoneNumber) {
        updateAdvertiserPhoneNumber.updateAdvertiserPhoneNumber(phoneNumber, newPhoneNumber);
    }


    @Override
    public Advertiser findAdvertiser(String email) {
    return advertiserExists.checkByEmail(email);
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) throws NoSuchAlgorithmException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var advertiser = this.findAdvertiser(request.getEmail());
        var jwtToken = jwtUtil.generateToken(advertiser);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
