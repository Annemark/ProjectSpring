package fr.cantine.dao;

import java.util.List;

public interface DaoInterface<T> {// T: n'import quelle type d'objet
	T createOrUpdate(T item);
	T findById(Long id);
	List<T> findAll();
	void delete(Long id);
}
