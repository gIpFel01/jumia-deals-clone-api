package com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces;
import com.jumiadealsclone.ads.modelelayer.Account;

import java.util.Date;

public interface CreateAccount{
    Account createAccount(String username, String password,
                          String photoProfile, Date lastLoginDate);
}
