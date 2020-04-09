package com.enquiry.pro.controller;

import java.io.IOException;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "check")
public class PhotoRestController {

	@Autowired
	IPhotoRepository photoRepository;

	@PostMapping("/upload")
	public Photo uploadImage(@RequestParam("myFile") MultipartFile file,
			@RequestParam("registrationId") String registrationId) throws IOException {

		//To convert data from JSON format
		ObjectMapper objectMapper = new ObjectMapper();

		//create JsonNode
		JsonNode rootNode = objectMapper.readTree(registrationId);
		//converting string as int
		int id = rootNode.asInt();
		System.out.println("===" +id);

		Photo img = new Photo(file.getOriginalFilename(), file.getContentType(), file.getBytes(), id);

		final Photo savedImage = photoRepository.save(img);

		System.out.println("Image saved");

		return savedImage;

	}

	

}
