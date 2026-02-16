package com.assignment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	 @Id
	 @GeneratedValue
	 private int id;

	 private String content;
	 private String created_at;
	 
	 @ManyToOne
	 private Post post;  
	 
	 @ManyToOne
	 private User author;
	 
	 public Post getPost() {
		 return post;
	 }

	 public void setPost(Post post) {
		 this.post = post;
	 }

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

	 @Override
	 public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", created_at=" + created_at + ", post=" + post
				+ ", author=" + author + "]";
	 }

	
	 
	 
}
