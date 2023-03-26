package com.jumiadealsclone.ads.mapper;

import com.jumiadealsclone.ads.dto.AccountDTO;
import com.jumiadealsclone.ads.modelelayer.Account;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AccountDTOMapper implements Function<Account, AccountDTO> {
    @Override
    public AccountDTO apply(Account account) {
        return new AccountDTO(
                account.idAccount(),
                account.advertiserUsername(),
                account.advertiserPhotoProfile()
        );
    }
}
