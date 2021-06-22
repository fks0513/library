package com.tj.library;

import org.springframework.web.multipart.MultipartFile;

public class LibDTO {
private String book,name,num;
private int price;
//private MultipartFile file;

public LibDTO() {
	super();
}

public LibDTO(String book, String name, String num, int price) {
	super();
	this.book = book;
	this.name = name;
	this.num = num;
	this.price = price;
	//this.file = file;
}

public String getBook() {
	return book;
}

public void setBook(String book) {
	this.book = book;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getNum() {
	return num;
}

public void setNum(String num) {
	this.num = num;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

//public MultipartFile getFile() {
//	return file;
//}
//
//public void setFile(MultipartFile file) {
//	this.file = file;
//}




}
