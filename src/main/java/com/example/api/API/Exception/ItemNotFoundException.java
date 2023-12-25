package com.example.api.API.Exception;

public class ItemNotFoundException extends RuntimeException{
		
	private Long id;
	
	public ItemNotFoundException(Long id) {
		super("Could not found item " + id); 
	}
}
