package com.ventas.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventas.modelos.Compra;
import com.ventas.modelos.Producto;
import com.ventas.modelos.Usuario;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	List<Producto> findByPropietario(Usuario propietario);
	List<Producto> findByCompra(Compra compra);
	List<Producto> findByCompraIsNull();
	List<Producto> findByNombreContainsIgnoreCaseAndCompraIsNull(String nombre);
	List<Producto> findByNombreContainsIgnoreCaseAndPropietario(String nombre, Usuario usuario);
}
