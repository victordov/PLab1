package md.victordov.lab.dao;

import java.util.Collection;

public interface GenericDAO<T> {

	Collection<T> retrieve();

	T retrieve(long id);

	boolean create(T t);

	boolean update(T t);

	boolean delete(Long id);

}
