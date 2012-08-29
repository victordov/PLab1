package md.victordov.lab.services;

import md.victordov.lab.common.exception.MyDaoException;

public interface GenericService {
	
	public long createFunction() throws MyDaoException;
	
	public boolean updateFunction() throws MyDaoException;

	public void printOne() throws MyDaoException;

	public void printAll() throws MyDaoException;


}
