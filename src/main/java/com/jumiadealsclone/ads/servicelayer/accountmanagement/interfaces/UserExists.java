package com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces;

import com.jumiadealsclone.ads.modelelayer.Account;

public interface UserExists {
     Account userFound(String username);
     void userNotFound(String username);
}
