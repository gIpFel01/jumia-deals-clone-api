package com.jumiadealsclone.ads.controllerlayer;

import com.jumiadealsclone.ads.modelelayer.Account;
import com.jumiadealsclone.ads.modelelayer.Advertiser;
import com.jumiadealsclone.ads.servicelayer.accountmanagement.interfaces.AccountService;
import com.jumiadealsclone.ads.servicelayer.advertisermanagement.interfaces.AdvertiserService;
import com.jumiadealsclone.ads.dto.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    public void createAccount(@RequestBody Account account){
        Account account1 = account;
        /*Account account = dataWrapper.account();
        Advertiser advertiser = dataWrapper.advertiser();
        accountService.createAccount(account);
        advertiser.setAccount(account);
        advertiserService.createAdvertiser(advertiser);*/
    }

    @GetMapping("/findAccount/{username}")
    public ResponseEntity<Account> findAccount(@PathVariable("username") String username){
        Account account = accountService.findAccount(username);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAccount/{username}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@PathVariable("username") String username){
        accountService.deleteAccount(username);
    }
}
