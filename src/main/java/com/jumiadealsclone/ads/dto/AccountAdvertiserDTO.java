package com.jumiadealsclone.ads.dto;

import com.jumiadealsclone.ads.modelelayer.Account;
import com.jumiadealsclone.ads.modelelayer.Advertiser;

public record AccountAdvertiserDTO(
        Account account,
        Advertiser advertiser) {
}
