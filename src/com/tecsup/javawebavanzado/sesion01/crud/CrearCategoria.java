package com.tecsup.javawebavanzado.sesion01.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tecsup.javawebavanzado.sesion01.jpa.Categoria;

public class CrearCategoria {
	
	static EntityManagerFactory emf;
	static EntityManager em;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		emf= Persistence.createEntityManagerFactory("JavaWebAvanzado_Sesion01_JPA");
		em= emf.createEntityManager();
		
		try {
			//empieza la tx
			em.getTransaction().begin();
			
			Categoria emp =  new Categoria();
			//emp.setIdcategoria(8);
			emp.setNombre("Verduras");
			emp.setDescripcion("Descripcion de verduras");
			//graba registro
			em.persist(emp);
			//confirma transacción
			em.getTransaction().commit();

		} catch (Exception e) {
			//deshacer transaccion 
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();

	}

}
