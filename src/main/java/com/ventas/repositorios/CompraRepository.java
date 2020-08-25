package com.ventas.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventas.modelos.Compra;
import com.ventas.modelos.Usuario;

public interface CompraRepository extends JpaRepository<Compra, Long> {
	
	List<Compra> findByPropietario(Usuario propietario);
	
}
