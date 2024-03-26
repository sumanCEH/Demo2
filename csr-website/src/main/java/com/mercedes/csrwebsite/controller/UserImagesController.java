package com.mercedes.csrwebsite.controller;
 
 
import com.mercedes.csrwebsite.model.UserImages;
import com.mercedes.csrwebsite.service.UserImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@RequestMapping("/api/userImages")
public class UserImagesController {
	 @Autowired
    private UserImagesService userImagesService;

 
	 //common
    @GetMapping("/getAllUserImages")
    public List<UserImages> getAllUserImages() {
        return userImagesService.getAllUserImages();
    }
 
    @PostMapping("/createUserImages")
    public UserImages createUserImages(@RequestBody UserImages userImages) {
        return userImagesService.createUserImages(userImages);
    }
    
    //error
    //@GetMapping("/deleteUserImage/{id}") 
	/*public void getDelEvent(Long id) {  
    	userImagesService.deleteUserImages(id);
	  } */ 
    
    //error
    /*@PutMapping("/UpdateUserImages/{id}") 
	 public UserImages UpdateUserImages(@RequestBody UserImages userImages) {  
		  return userImagesService.updateUserImages(userImages);
	  }*/
 
}
 