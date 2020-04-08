package com.enquiry.pro.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.enquiry.pro.model.Photo;
import com.enquiry.pro.repository.IPhotoRepository;
import com.enquiry.pro.service.IRegisterService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "check")
public class PhotoRestController {

	
	@Autowired
    IPhotoRepository photoRepository;

    @PostMapping("/upload")
    public Photo uplaodImage(@RequestParam("myFile") MultipartFile file) throws IOException {

    	Photo img = new Photo( file.getOriginalFilename(),file.getContentType(),file.getBytes());

        final Photo savedImage = photoRepository.save(img);

        System.out.println("Image saved");

        return savedImage;

    }
    
    @Autowired
    private IRegisterService regSer;
 // update status of registration
 	@PutMapping("/photo/{registrationId}")
 	public void updateStatus(@PathVariable("registrationId") int registrationId) {

 		regSer.updateRegId(registrationId);

 	}
    
    
    
    
}
