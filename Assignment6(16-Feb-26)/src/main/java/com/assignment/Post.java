package com.assignment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Post {
	  @Id
	  @GeneratedValue
	  private int id;

	  private String title;
	  private String content;
	  private String created_at;
	  private String updated_at;

	  @ManyToOne
	  private User author;
	  
	  public User getAuthor() {
		  return author;
	  }

	  public void setAuthor(User author) {
		  this.author = author;
	  }
	  

	  public int getId() {
		  return id;
	  }

	  public void setId(int id) {
		  this.id = id;
	  }

	  public String getTitle() {
		  return title;
	  }

	  public void setTitle(String title) {
		  this.title = title;
	  }

	  public String getContent() {
		  return content;
	  }

	  public void setContent(String content) {
		  this.content = content;
	  }

	  public String getCreated_at() {
		  return created_at;
	  }

	  public void setCreated_at(String created_at) {
		  this.created_at = created_at;
	  }

	  public String getUpdated_at() {
		  return updated_at;
	  }

	  public void setUpdated_at(String updated_at) {
		  this.updated_at = updated_at;
	  }

	  @Override
	  public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", author=" + author + "]";
	  }

	  
	  
	  
}
