package com.jumiadealsclone.ads.controllerlayer;

import com.jumiadealsclone.ads.dto.AccountAdvertiserDTO;
import com.jumiadealsclone.ads.dto.AccountDTO;
import com.jumiadealsclone.ads.modelelayer.Account;
import com.jumiadealsclone.ads.modelelayer.Advertiser;
import com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces.AccountService;
import com.jumiadealsclone.ads.servicelayer.advertisermanagement.interfaces.AdvertiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;
    private final AdvertiserService advertiserService;

    @Autowired
    public AccountController(AccountService accountService, AdvertiserService advertiserService) {
        this.accountService = accountService;
        this.advertiserService = advertiserService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void createAccount(@RequestBody AccountAdvertiserDTO accountAdvertiserDTO){
        Account account = accountAdvertiserDTO.account();
        Advertiser advertiser = accountAdvertiserDTO.advertiser();
        accountService.createAccount(account);
        advertiser.setAccount(account);
        advertiserService.createAdvertiser(advertiser);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findAccount/{username}")
    public AccountDTO findAccount(@PathVariable("username") String username){
        return accountService.findAccount(username);
    }

    @DeleteMapping("/deleteAccount/{username}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@PathVariable("username") String username){
        accountService.deleteAccount(username);
    }
}
