//Author : Koushal
package com.mercedes.csrwebsite.model;



import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
/* @Data, @NoArgsConstructor, and @AllArgsConstructor are used. 
These annotations automatically generate getters, setters, 
and constructors for the class. @Data also includes toString along with get set*/

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Spoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
 // New field to track identification status
    private boolean identified;
    private String name;
    private String image;
    private String description;

    @Column(name = "designation_role")
    private String designationRole;

	

    // Constructors, getters, and setters
    public Spoc() {
	}



    public Spoc(Long id, String name, String image, String description, String designationRole) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.designationRole = designationRole;
        this.identified = false; // Default to not identified
    }




	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getDesignationRole() {
		return designationRole;
	}



	public void setDesignationRole(String designationRole) {
		this.designationRole = designationRole;
	}



	



	public boolean isIdentified() {
        return identified;
    }

    public void setIdentified(boolean identified) {
        this.identified = identified;
    }
    
    @Override
    public String toString() {
        return "Spoc [id=" + id + ", name=" + name + ", image=" + image + ", description=" + description
                + ", designationRole=" + designationRole + ", identified=" + identified + "]";
    }
    
    
    
}

