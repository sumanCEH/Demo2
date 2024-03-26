//Author : Koushal
package com.mercedes.csrwebsite.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;



@Entity
@Table(name="user_table")
public class User 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // to be changed to Active/Inactive User
    private String type; 
    
    //@NotNull it doesnt include spaces also, you need to give null directly 
    @NotEmpty(message = "Employee name may not be null") //it includes spaces also
    private String name;
    
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@mercedes-benz\\.com$", message = "Only Mercedes-Benz email addresses are allowed")
    private String email;
    
    //automatically its fetching using the API
    private String role; // User or Admin - To be fetched from Azure AD Dynamically
    
    // Add variables to store image path, filename, and image data
    private String imagePath;
    private String imageName;
    
    @Lob
    private byte[] imageData;
    
   
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<Certificate> certificates = new HashSet<>();

    
    
    
    //default constructor
	public User() {
		
	}

	public User(String type, String name, String email, String role) {
		this.type = type;
		this.name = name;
		this.email = email;
		this.role=role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", type=" + type + ", name=" + name + ", email=" + email + "role =" +role+"]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
	
	

	
    
}

