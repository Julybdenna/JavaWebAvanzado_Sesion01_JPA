package com.tecsup.javawebavanzado.sesion01.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tecsup.javawebavanzado.sesion01.jpa.Categoria;

public class BuscarCategoria {
	static EntityManagerFactory emf;
	static EntityManager em;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("JavaWebAvanzado_Sesion01_JPA");
		em = emf.createEntityManager();
		try {
			Categoria emp = em.find(Categoria.class, 2);

			System.out.println(emp.getDescripcion());

			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();

		}

	}

}
