package by.htp.librory.bean;

public class Book extends Entity {
	private String tittle;
	private Author author;
	private int year;
	private String str;
	
	public Book(int id, String tittle) {
		super(id);
		this.tittle = tittle;
	}
	
	public Book(int id, String tittle, int year, String str) {
		super(id);
		this.tittle = tittle;
		this.year = year;
		this.str = str;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Book(int id, String tittle, Author author) {
		super(id);
		this.tittle = tittle;
		this.author = author;
	}

	public Book(int id) {
		super(id);
		
	}

	

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((tittle == null) ? 0 : tittle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (tittle == null) {
			if (other.tittle != null)
				return false;
		} else if (!tittle.equals(other.tittle))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Book [tittle=" + tittle + ", author=" + author + ", getId()=" + getId() + "]";
	}
	
}
