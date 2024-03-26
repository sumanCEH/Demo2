//Author : Koushal
package com.mercedes.csrwebsite.controller;

import com.mercedes.csrwebsite.model.Spoc;
import com.mercedes.csrwebsite.model.User;
import com.mercedes.csrwebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.mercedes.csrwebsite.service.SpocService;
import com.mercedes.csrwebsite.service.UserImagesService;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserImagesService imageService;

	@Autowired
	private SpocService spocService;

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/addGeneralUser")
	public User createGeneralUser(@RequestBody User user) {
		user.setRole("USER");
		return userService.createUser(user);
	}

	@PostMapping("/addAdminUser")
	public User createAdminUser(@RequestBody User adminUser) {
		adminUser.setRole("ADMIN");
		return userService.createUser(adminUser);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id) {
		Optional<User> userOptional = userService.getUserById(id);
		if (userOptional.isPresent()) {
			return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + id + " does not exist");
		}
	}

	// Instead of delete user, we can use Boolean - Active user & Non- Active user
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		try {
			// Validate if the user exists
			Optional<User> userOptional = userService.getUserById(id);
			if (!userOptional.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + id + " not found");
			}

			// Delete the user
			userService.deleteUser(id);

			return ResponseEntity.ok("User deleted successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to delete user: " + e.getMessage());
		}
	}

	// update profile only for admin
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
	    try {
	        // Validate if the user exists
	        Optional<User> userOptional = userService.getUserById(id);
	        if (!userOptional.isPresent()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                    .body("User with ID " + id + " not found");
	        }

	        // Update the user information
	        User existingUser = userOptional.get();
	        existingUser.setName(updatedUser.getName()); // Update other fields as needed
	        existingUser.setType(updatedUser.getType()); // Update type
	        existingUser.setEmail(updatedUser.getEmail()); // Update email
	        existingUser.setRole(updatedUser.getRole()); // Update role
	        
	        // Save the updated user to the database
	        userService.updateUser(existingUser);

	        return ResponseEntity.ok("User updated successfully");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body("Failed to update user: " + e.getMessage());
	    }
	}


	// user story // relationship ? one to one or many to many ?
	@PostMapping("/identifySpoc")
	public ResponseEntity<String> identifySpoc(@RequestBody Spoc spoc) {
		try {
			// Add logic to identify SPOCs
			spocService.identifySpoc(spoc);
			return new ResponseEntity<>("SPOC identified successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to identify SPOC: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	   // Endpoint to handle image uploads using byte code, getting stored in database
//	@PostMapping("/uploadImage/{userId}")
//	public ResponseEntity<String> uploadImage(@PathVariable Long userId, @RequestParam("file") MultipartFile file) {
//	    try {
//	        // Check if the file is empty
//	        if (file.isEmpty()) {
//	            return ResponseEntity.badRequest().body("Please select a file to upload");
//	        }
//
//	        // Get the filename and file data
//	        String fileName = file.getOriginalFilename();
//	        byte[] fileData = file.getBytes();
//
//	        // Call the service method to upload the image
//	        userService.uploadImage(userId, fileName, fileData);
//
//	        return ResponseEntity.ok("Image uploaded successfully");
//	    } catch (IOException e) {
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//	                .body("Failed to upload image: " + e.getMessage());
//	    }
//	}
	
	
	// Endpoint to retreive image uploaded in database using byte code.
//	@GetMapping("/getImageById/{userId}")
//	public ResponseEntity<?> getImageById(@PathVariable Long userId) {
//	    byte[] imageData = userService.getUserImageById(userId);
//	    if (imageData != null) {
//	        // You may need to set appropriate content type based on your image format
//	        HttpHeaders headers = new HttpHeaders();
//	        headers.setContentType(MediaType.IMAGE_JPEG); // Assuming the image format is JPEG
//
//	        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
//	    } else {
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found for user ID: " + userId);
//	    }
//	}
	

    
	@PostMapping("/uploadImage/{userId}")
	public ResponseEntity<String> uploadImage(@PathVariable Long userId, @RequestParam("file") MultipartFile file) {
	    try {
	        // Check if the file is empty
	        if (file.isEmpty()) {
	            return ResponseEntity.badRequest().body("Please select a file to upload");
	        }

	        // Get the filename
	        String fileName = file.getOriginalFilename();
	        
	        // Define the directory path to store the image
	        String directory = "C:\\Users\\KOUSHAL\\Downloads\\csr-website\\target";
	        
	        // Create the directory if it doesn't exist
	        File uploadDirectory = new File(directory);
	        if (!uploadDirectory.exists()) {
	            uploadDirectory.mkdirs();
	        }

	        // Create a Path object with the directory path and filename
	        Path filePath = Paths.get(directory, fileName);
	        
	        // Save the file to the specified path
	        Files.write(filePath, file.getBytes());

	        // Update the image path in the user entity
	        String imagePath = filePath.toString();
	        userService.uploadImage(userId, fileName, imagePath);

	        return ResponseEntity.ok("Image uploaded successfully");
	    } catch (IOException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Failed to upload image: " + e.getMessage());
	    }
	}

	
    
	@GetMapping("/getImageById/{userId}")
	public ResponseEntity<?> getImageById(@PathVariable Long userId) {
	    byte[] imageData = userService.getUserImageById(userId);
	    if (imageData != null) {
	        // Set the appropriate content type based on your image format
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.IMAGE_JPEG); // Assuming the image format is JPEG

	        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found for user ID: " + userId);
	    }
	}
	
	
	
	
	
	
	// Other controller methods if needed   
}
	

