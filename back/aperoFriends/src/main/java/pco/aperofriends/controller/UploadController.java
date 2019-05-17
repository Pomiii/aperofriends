package pco.aperofriends.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import pco.aperofriends.service.StorageService;
 
 
@RestController
@CrossOrigin("http://localhost:4200")
public class UploadController {
 
  @Autowired
  StorageService storageService;
 
  List<String> files = new ArrayList<String>();
 
  @PostMapping("/item/uploadimg")
  public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
      String message = "";
      try {
          storageService.store(file);
          message = "You successfully uploaded " + file.getOriginalFilename() + "!";
          return ResponseEntity.status(HttpStatus.OK).body(message);
      } catch (Exception e) {
          message = "Fail to upload Profile Picture" + file.getOriginalFilename() + "!";
          return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
      }
  }
}
