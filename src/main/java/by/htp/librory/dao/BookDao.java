package by.htp.librory.dao;

import java.util.List;

import by.htp.librory.bean.Book;

public interface BookDao extends BaseDao<Book>{
	
	List<Book> readAll();
	//Map<String,String> specyficSelect();
}
