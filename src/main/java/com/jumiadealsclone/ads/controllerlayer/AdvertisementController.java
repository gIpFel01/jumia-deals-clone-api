package com.jumiadealsclone.ads.controllerlayer;

import com.jumiadealsclone.ads.dto.AdvertisementDTO;
import com.jumiadealsclone.ads.modelelayer.Advertisement;
import com.jumiadealsclone.ads.modelelayer.Advertiser;
import com.jumiadealsclone.ads.servicelayer.advertisementmanagement.interfaces.AdvertisementService;
import com.jumiadealsclone.ads.servicelayer.advertisermanagement.interfaces.AdvertiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {

    private final AdvertisementService advertisementService;
    private final AdvertiserService advertiserService;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService,
                                   AdvertiserService advertiserService) {
        this.advertisementService = advertisementService;
        this.advertiserService = advertiserService;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/create")
    public void create(@RequestBody Advertisement advertisement){
        advertisementService.createAdvertisement(advertisement);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id){
        advertisementService.deleteAdvertisement(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findByAdvertiser/{email}")
    public Set<AdvertisementDTO> findByAdvertiser(@PathVariable("email") String email){
        Advertiser advertiser = advertiserService.findAdvertiser(email);
        return advertisementService.findAdvertisementByAdvertiser(advertiser);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/recentAdvertisement")
    public List<AdvertisementDTO> findRecentAdvertisement(){
        return advertisementService.findRecentAdvertisement();
    }
}
