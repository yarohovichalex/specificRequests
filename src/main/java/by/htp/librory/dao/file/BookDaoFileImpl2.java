package by.htp.librory.dao.file;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import by.htp.librory.bean.Book;
import by.htp.librory.dao.BookDao;

public class BookDaoFileImpl2 implements BookDao{

	@Override
	public void criate(Book entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Book entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> readAll() {
		List <Book> books = new ArrayList<>();
		String string;
		String []stringArray ;		
			try {
				FileReader fr = new FileReader("C:\\Dell\\fileRead.txt");
				Scanner scan = new Scanner(fr);
				do {					
					string = scan.nextLine();
					stringArray = string.split(",");
					books.add(new Book(Integer.parseInt(stringArray[0]), stringArray[1]));					
				}while(scan.hasNextLine());
				fr.close();
				scan.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}		
		return books;	
	}	

}
