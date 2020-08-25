package com.ventas.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.modelos.Compra;
import com.ventas.modelos.Producto;
import com.ventas.modelos.Usuario;
import com.ventas.repositorios.ProductoRepository;
import com.ventas.upload.StorageService;

@Service
public class ProductoServicio implements CRUD<Producto>{
	
	@Autowired
	private ProductoRepository repositorio;
	
	@Autowired
	private StorageService storageService;

	@Override
	public Producto insertar(Producto p) {
		return repositorio.save(p);
	}

	@Override
	public void borrar(long id) {
		Optional<Producto> o = repositorio.findById(id);
		if (o.isPresent() && !o.get().getImagen().isEmpty()) {
			storageService.delete(o.get().getImagen());
		}
		repositorio.deleteById(id);
	}

	@Override
	public void borrar(Producto p) {
		if (!p.getImagen().isEmpty()) {
			storageService.delete(p.getImagen());
		}
		repositorio.delete(p);
	}

	@Override
	public Producto editar(Producto p) {
		return repositorio.save(p);
	}

	@Override
	public Producto findById(long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public List<Producto> findAll() {
		return repositorio.findAll();
	}
	
	public List<Producto> productosDeUnPropietario(Usuario u) {
		return repositorio.findByPropietario(u);
	}
	
	public List<Producto> productosDeUnaCompra(Compra c) {
		return repositorio.findByCompra(c);
	}
	
	public List<Producto> productosSinVender() {
		return repositorio.findByCompraIsNull();
	}
	
	public List<Producto> buscar(String query) {
		return repositorio.findByNombreContainsIgnoreCaseAndCompraIsNull(query);
	}
	
	public List<Producto> buscarMisProductos(String query, Usuario u) {
		return repositorio.findByNombreContainsIgnoreCaseAndPropietario(query, u);
	}
	
	public List<Producto> variosPorId(List<Long> ids) {
		return repositorio.findAllById(ids);
	}
}
