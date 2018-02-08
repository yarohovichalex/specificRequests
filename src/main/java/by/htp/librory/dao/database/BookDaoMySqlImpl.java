package by.htp.librory.dao.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.htp.librory.bean.Author;
import by.htp.librory.bean.Book;
import by.htp.librory.dao.BookDao;

public class BookDaoMySqlImpl implements BookDao{

	@Override
	public void criate(Book entity) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
		} catch (ClassNotFoundException e1) {			
			e1.printStackTrace();
		}
		
		try(Connection cn = DriverManager.getConnection(url,"root","root")){
			String sql = "INSERT INTO book(id, brief, publish_year, author) VALUES (?, ?, ?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, entity.getId());
			ps.setString(2, entity.getTittle());
			ps.setInt(3, entity.getYear());
			ps.setString(4,entity.getStr());
			ps.executeUpdate();

			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		/*try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		}
		
		try(Connection cn = DriverManager.getConnection(url,"root","root")){
			PreparedStatement ps = cn.prepareStatement("INSERT INTO 'book' (id, brief, publish_year, author) VALUES (?, ?, ?)");
			ps.setString(1, "user_name");
			ResultSet rs = ps.executeUpdate();
						
		}catch(SQLException e) {
			e.printStackTrace();
		}*/		
		
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
	private static final String url = "jdbc:mysql://localhost/workdb?"
			+ "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode"
			+ "=false&serverTimezone=UTC&useSSL=false";
	@Override
	public List<Book> readAll() {
		List <Book> books = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		}
		
		try(Connection cn = DriverManager.getConnection(url,"root","root")){
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from book");
			
			while(rs.next()) {
				books.add(new Book(rs.getInt("id"), rs.getString("brief"), new Author(rs.getString("author"), new Date(1994,06,13))));
				System.out.println(rs.getString("brief"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
	
	
	public /*Map<String, String>*/List<String> specificRequests() {
		Map <String, String> specuficMap = new HashMap<>();
		List<String> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
		} catch (ClassNotFoundException e1) {			
			e1.printStackTrace();
		}
		
		try(Connection cn = DriverManager.getConnection(url,"root","root")){
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from employee,"+
					" employee_book where employee_book.employeeid = employee.id\r\n" + 
					"group by name\r\n" + 
					"having count(employeeid)>1;");
			
//			while(rs.next()) {
//				specuficMap.put(rs.getString("name"), rs.getString("countBook"));
//				System.out.println(rs.getString("name"));
//			}
			while(rs.next()) {
				list.add(rs.getString("name"));
				System.out.println(rs.getString("name"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/*@Override
	public List<Book> readAll() {
		Connection cn = null;
		try {
			cn = DriverManager.getConnection("");			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(cn != null) {
					cn.close();
				}				
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return null;
	}*/

}
