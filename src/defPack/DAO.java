package defPack;

import java.util.Collection;

interface DAO<T> {

	Collection<T> retrieve();

	T retrieve(long id);

	boolean create(T t);

	boolean update(T t);

	boolean delete(Long id);

}
