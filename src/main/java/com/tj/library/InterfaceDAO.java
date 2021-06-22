package com.tj.library;

import java.util.ArrayList;

public interface InterfaceDAO {

	public ArrayList<LibDTO> list();
	public void write(String book, String name, String num, int price);
	public void update(int price, String book);
	public void delete(String book);
}
