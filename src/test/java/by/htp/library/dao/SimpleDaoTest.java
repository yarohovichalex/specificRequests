package by.htp.library.dao;

import org.junit.Assert;  // библеотека
import org.junit.Before;
import org.junit.Test;

import by.htp.librory.dao.BookDao;
import by.htp.librory.dao.simple.BookDaoFileImpl;

public class SimpleDaoTest {
	
	private BookDao dao;
		
	
	
	@Before
	public void initData() {
		dao = new BookDaoFileImpl(); 
		//dao = new BookDaoMySqlImpl();	//сваливаеться
		}
	
	
	@Test
	public void testReadAllNotEmptyList() {
		Assert.assertNotNull("Dao was not initialized", dao);
		Assert.assertNotNull("Dao was not initialized", dao.readAll());
	}
}
