package com.nagarro.java.DTO;

public class BookDTO {
	private int code;
	private String name;
	private String author;
	private String doc;

	public BookDto() {

	}


	public BookDto(int code, String name, String author,  String doc) {
		super();
		this.code = code;
		this.name = name;
		this.author =author;
		this.doc = doc;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getDoc() {
		return doc;
	}


	public void setDoc(String doc) {
		this.doc = doc;
	}


	public String toString() {
		return "BookDto [code=" + code + ", name=" + name + ", author=" + author + ", date="
				+ doc + "]";
	}
}
