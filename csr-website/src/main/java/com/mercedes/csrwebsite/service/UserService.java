//Author : Koushal
package com.mercedes.csrwebsite.service;

import com.mercedes.csrwebsite.model.User;
import com.mercedes.csrwebsite.dao.UserRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

	@Autowired
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User createUser(User user) {
		/*
		 * if ("ADMIN".equals(user.getRole())) { // Additional logic for admin user }
		 * else { // Additional logic for general user }
		 */
		return userRepository.save(user);
	}

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public void deleteUser(Long id) {
		// Implement the logic to delete the user by ID
		// Example:
		userRepository.deleteById(id);
	}

	public void updateUser(User existingUser) {
		// Update the user in the database
		userRepository.save(existingUser);
	}
	
	
	
	
	
//	public User uploadImage(Long userId, String imageName, byte[] imageData) {
//        Optional<User> userOptional = userRepository.findById(userId);
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            user.setImageName(imageName);
//            user.setImageData(imageData);
//            return userRepository.save(user);
//        } else {
//            throw new IllegalArgumentException("User with ID " + userId + " not found");
//        }
//    }
	
	
//	public byte[] getUserImageById(Long userId) {
//	    Optional<User> userOptional = userRepository.findById(userId);
//	    if (userOptional.isPresent()) {
//	        User user = userOptional.get();
//	        return user.getImageData();
//	    } else {
//	        return null;
//	    }
//	}
	
	
	
	
//	public User uploadImage(Long userId, String imageName, String imagePath) {
//	    Optional<User> userOptional = userRepository.findById(userId);
//	    if (userOptional.isPresent()) {
//	        User user = userOptional.get();
//	        user.setImageName(imageName);
//	        user.setImagePath(imagePath); // Update the image path
//	        return userRepository.save(user);
//	    } else {
//	        throw new IllegalArgumentException("User with ID " + userId + " not found");
//	    }
//	}
//	
//
//	
//	
//	public byte[] getUserImageById(Long userId) {
//	    Optional<User> userOptional = userRepository.findById(userId);
//	    if (userOptional.isPresent()) {
//	        User user = userOptional.get();
//	        String imagePath = user.getImagePath();
//	        try {
//	            // Read the image file and convert it to byte array
//	            Path filePath = Paths.get(imagePath);
//	            return Files.readAllBytes(filePath);
//	        } catch (IOException e) {
//	            // Handle any exceptions that occur during file reading
//	            e.printStackTrace();
//	            return null;
//	        }
//	    } else {
//	        return null;
//	    }
//	}

	/*public User uploadImage(Long userId, String imageName, String imagePath) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            
            // Generate a UUID
            String uuid = UUID.randomUUID().toString();
            
            // Append the UUID to the image filename
            String modifiedImageName = uuid + "_" + imageName;
            
            // Update the image name and path in the user entity
            user.setImageName(modifiedImageName);
            user.setImagePath(imagePath);
            
            // Save the user to the database
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User with ID " + userId + " not found");
        }
    }*/
	
	
	
	public User uploadImage(Long userId, String imageName, String imagePath) {
	    Optional<User> userOptional = userRepository.findById(userId);
	    if (userOptional.isPresent()) {
	        User user = userOptional.get();
	        
	        // Generate a UUID
	        String uuid = UUID.randomUUID().toString();
	        
	        // Generate a timestamp
	        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ssSSS"));
	        
	        // Append the timestamp, UUID, and image name
	        String modifiedImageName = timestamp + "_" + uuid + "_" + imageName;
	        
	        // Update the image name and path in the user entity
	        user.setImageName(modifiedImageName);
	        user.setImagePath(imagePath);
	        
	        // Save the user to the database
	        return userRepository.save(user);
	    } else {
	        throw new IllegalArgumentException("User with ID " + userId + " not found");
	    }
	}

	
	
	
	
	
	
	
	

    public byte[] getUserImageById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String imagePath = user.getImagePath();
            String imageName = user.getImageName();
            
            // Extract the UUID from the image filename
            String[] parts = imageName.split("_");
            String uuid = parts[0];
            
            // Print the UUID along with the image name
            System.out.println("UUID: " + uuid);
            System.out.println("Image Name: " + imageName);
            
            try {
                // Read the image file and convert it to byte array
                Path filePath = Paths.get(imagePath);
                return Files.readAllBytes(filePath);
            } catch (IOException e) {
                // Handle any exceptions that occur during file reading
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }


	
	
	
	
	
	
	
	
	
	// other service methods

}
