package com.mercedes.csrwebsite.service;
 
 
import com.mercedes.csrwebsite.dao.UserImagesDAO;
import com.mercedes.csrwebsite.model.UserImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Optional;
 
@Service
public class UserImagesService {
	 @Autowired
    private UserImagesDAO userImagesDAO;
 
    public List<UserImages> getAllUserImages() {
        return userImagesDAO.findAll();
    }
 
    public UserImages createUserImages(UserImages userImages) {
    	userImages.setCreatedAt(new Date());
    	userImages.setUpdatedAt(new Date());
    	userImages.setDeleted(false);
  
        return userImagesDAO.save(userImages);
    }

    //Author = Koushal - uploadImage
//    public void uploadImage(MultipartFile file) {
//        try {
//            // Ensure the file is not empty
//            if (file.isEmpty()) {
//            	//throw new ImageUploadException("Failed to upload image: Empty file");
//                throw new Exception("Failed to upload image: Empty file");
//            }
//
//            // Add logic to validate file type, size, etc.
//
//            // Get the file name
//            String fileName = file.getOriginalFilename();
//
//            // Set the file path where you want to store the uploaded image
//            Path filePath = Path.of("C:\\Users\\KOUSHAL\\Downloads\\MBRDI Proj" + fileName);
//
//            // Copy the file to the destination path
//            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//            // Example: Save relevant information in the database
//            UserImages userImage = new UserImages();
//            userImage.setFileName(fileName);
//            userImage.setFilePath(filePath.toString());
//            createUserImages(userImage);
//
//        } catch (IOException e) {
//            // Handle IO exception
//            //throw new Exception("Failed to upload image: " + e.getMessage());
//        	System.out.println(e);
//            
//        } /*catch (ImageUploadException e) {
//            // Handle custom image upload exception
//            throw e;
//        }*/ 
//        catch (Exception e) {
//            // Handle other exceptions
//            //throw new Exception("Failed to upload image: " + e.getMessage());
//        	System.out.println(e);
//        }
        
        //error
        /*public Optional<UserImages> getUserImagesById(Long id) {
            return userImagesDAO.findById(id);
        }*/
     
        //error
        /*public void deleteUserImages(Long id) {
             userImagesDAO.deleteById(id);
        }*/ 

    	/*public UserImages updateUserImages(UserImages userImages) {
    		return userImagesDAO.save(userImages);
    	}*/
    //}
 
    
    
    
    
    
 
}