package com.ventas.servicios;

import java.util.List;

public interface CRUD<T> {
	public T insertar(T t);
	public void borrar(long id);
	public void borrar(T t);
	public T editar(T t);
	public T findById(long id);
	public List<T> findAll();;
}
