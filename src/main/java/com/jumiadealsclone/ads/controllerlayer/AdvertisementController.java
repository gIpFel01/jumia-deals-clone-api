package com.jumiadealsclone.ads.controllerlayer;

import com.jumiadealsclone.ads.modelelayer.Advertisement;
import com.jumiadealsclone.ads.servicelayer.advertisementmanagement.interfaces.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("advertisement")
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    public Advertisement create(){
        return null;
    }

    public void delete(){

    }

    public Advertisement findByAdvertiser(){
        return null;
    }

    public List<Advertisement> findLastThreeDaysPublish(){
        return null;
    }
}
