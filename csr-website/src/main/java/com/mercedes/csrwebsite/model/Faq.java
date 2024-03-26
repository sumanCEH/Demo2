//Author : Koushal
package com.mercedes.csrwebsite.model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Faq 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String answer;

    @Temporal(TemporalType.TIMESTAMP) /*this means both date and time should be stored in database, 
    									if we hadn't used @Temporal(TemporalType.TIMESTAMP) 
    									only date would have got stored. */
    @Column(name = "created_at")     /* used to specify the column name, 
    									if not used by default it will take createdAt*/
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "is_deleted") // soft delete thats why using Boolean
    private boolean isDeleted;
    
    
    // Constructors, getters, and setters
    
    public Faq() 
	{
		
	}


	public Faq(String question, String answer, Date createdAt, Date updatedAt, boolean isDeleted) 
	{
		this.question = question;
		this.answer = answer;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isDeleted = isDeleted;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public boolean isDeleted() {
		return isDeleted;
	}


	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}


	@Override
	public String toString() {
		return "Faq [id=" + id + ", question=" + question + ", answer=" + answer + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", isDeleted=" + isDeleted + "]";
	}
	
	
	
    
    
    
    
    
    
    
}
