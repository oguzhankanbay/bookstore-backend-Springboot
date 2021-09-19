package com.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class books {
	@Id()
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long Id;
	@Column(name="book_name")
	private String bookName;
	@Column(name="book_price")
	private long bookPrice;
	
	public books() {
		
	}
	
	public books(String bookName, long bookPrice) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}
	public long getBookId() {
		return Id;
	}
	public void setBookId(long bookId) {
		Id = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public long getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(long bookPrice) {
		this.bookPrice = bookPrice;
	}
	
}
