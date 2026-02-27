package com.capgemini.dto;

import jakarta.persistence.*;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Category {

    @Id
    private Long categoryId;

    private String categoryName;
    private String description;


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", description=" + description
				+ "]";
	}
    
    
}
