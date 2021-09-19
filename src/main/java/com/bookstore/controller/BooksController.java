package com.bookstore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.exception.ResourceNotFoundException;
import com.bookstore.model.books;
import com.bookstore.repository.BookRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class BooksController {
	@Autowired
	private BookRepository bookRepository;
	
	//get all books 
	@GetMapping("/books")
	public List<books> getAllBooks(){
		return bookRepository.findAll();
	}
	//getbyId
		@GetMapping("/books/{Id}")
		public ResponseEntity<books> getbooksById(@PathVariable long Id){
			books book = bookRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("not found"));
			return ResponseEntity.ok(book);
		}
		
	//create books
		@PostMapping("/books")
		public books createBooks(@RequestBody books bookDetail) {
			return bookRepository.save(bookDetail);
		}
	
	
//update
	@PutMapping("/books/{Id}")
	public ResponseEntity<books> updateBooks(@PathVariable long Id, @RequestBody books booksDetails){
		books book = bookRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("not exist"+Id));
		book.setBookName(booksDetails.getBookName());
		book.setBookPrice(booksDetails.getBookPrice());
		
		books updatedbook = bookRepository.save(book);
		return ResponseEntity.ok(updatedbook);

		
	}
	
	//delete 
	
	@DeleteMapping("/books/{Id}")
	public ResponseEntity<Map<String,Boolean>> deleteBooks(@PathVariable long Id){
		books book = bookRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("not exist"+Id));
		bookRepository.delete(book);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
	    return ResponseEntity.ok(response);
	
	}
	
}










