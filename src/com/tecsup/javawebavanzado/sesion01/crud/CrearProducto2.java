package com.tecsup.javawebavanzado.sesion01.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tecsup.javawebavanzado.sesion01.jpa.Categoria;
import com.tecsup.javawebavanzado.sesion01.jpa.Producto;

public class CrearProducto2 {
	private static final Object CATEGORIA_LACTEOS = 2;
	static EntityManagerFactory emf;
	static EntityManager em;

	public static void main(String[] args) {
		emf= Persistence.createEntityManagerFactory("JavaWebAvanzado_Sesion01_JPA");
		em= emf.createEntityManager();
		try {
			//empieza la tx
			em.getTransaction().begin();
			Categoria cate = em.find(Categoria.class,CATEGORIA_LACTEOS);
			Producto prod2 = new Producto();
			//emp.setIdproducto(5);
			prod2.setNombre("Majesito");
			prod2.setDescripcion("Descripcion de Majesito");
//			prod2.setPrecio(null);
//			prod2.setStock(5);
			
			Producto prod3 = new Producto();
			prod3.setNombre("Leche Anchor");
			prod3.setDescripcion("Descripcion de Leche Anchor");
			
		
			cate.addProducto(prod2);
			cate.addProducto(prod3);
			
			
			//confirma transacción
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
			emf.close();
			
		}
		

	}

}
