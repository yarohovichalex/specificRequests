package by.htp.librory.dao;

import by.htp.librory.bean.Entity;

public interface BaseDao<T extends Entity> {
	void criate(T entity);
	T read(int id);
	void update(T entity);
	void delete(int id);
	
}
