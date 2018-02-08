package by.htp.librory.action.console;


import java.io.PrintWriter;
import java.util.List;

import by.htp.librory.action.BaseAction;
import by.htp.librory.bean.Book;
import by.htp.librory.dao.database.BookDaoMySqlImpl;

public class HelloWorldConsoleImpl implements BaseAction {
	private BookDaoMySqlImpl dao = new BookDaoMySqlImpl();

	@Override
	public void doSmth(PrintWriter out) {
		///*List<Book> books = */dao.criate(new Book(7,"aaaa", 2014, "bbbb"));
		List<Book> books = dao.readAll();
		
		for (Book book: books) {
			out.println(book + " \r\n ");
			 
		}		
	}
	
	@Override
	public void doSmth2(PrintWriter out) {
		List<String> ls = dao.specificRequests();
//		Map <String, String>specSel = dao.specyficSelect();
//		for(Map.Entry<String, String> entry : specSel.entrySet()) {
//			out.println("name: " + entry.getKey() + "num: " + entry.getValue());
//		}	
		for(String str: ls) {
			out.println(str + " ");
		}
	}
}
