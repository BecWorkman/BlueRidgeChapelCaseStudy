package com.workman.blueridgechapel.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * 
 * @author Becky Workman
 * This POJO is used to facilitate testimonial creation and 
 * getting testimonial information.
 *
 */

@Entity
public class Testimonial implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String title;
	private String message;
	private int rating;
	
	public Testimonial() {}

	public Testimonial(String name, String title, String message, int rating) {
		super();
		this.name = name;
		this.title = title;
		this.message = message;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, message, name, rating, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Testimonial other = (Testimonial) obj;
		return Objects.equals(id, other.id) && Objects.equals(message, other.message)
				&& Objects.equals(name, other.name) && rating == other.rating && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Testimonial [id=" + id + ", name=" + name + ", title=" + title + ", message=" + message + ", rating="
				+ rating + "]";
	}
	
	


}
