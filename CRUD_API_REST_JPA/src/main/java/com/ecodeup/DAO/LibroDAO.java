package com.ecodeup.DAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ecodeup.model.Libro;
import com.ecodeup.model.JPAUtil;

public class LibroDAO {
	
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void guardar(Libro libro) {
		
		entity.getTransaction().begin();
		entity.persist(libro);
		entity.getTransaction().commit();
		libro.setMensaje("Registro Exitoso");
	}
	public void editar(Libro libro) {
		
		entity.getTransaction().begin();
		entity.merge(libro);
		entity.getTransaction().commit();
		libro.setMensaje("Se Actualizo Correctamente");
	}
	public Libro buscar(int id ) {

		Libro l = new Libro();
		l=entity.find(Libro.class, id);
		return l;
	}
	
	public List<Libro> obtenerLibros(){
		
		List<Libro> listaLibros= new ArrayList<>();
		Query q=entity.createQuery("SELECT l FROM Libro l");
		listaLibros=q.getResultList();
		return listaLibros;
	}
	
	public void eliminar(int id){
		Libro l = new Libro();
		l=entity.find(Libro.class,id);
		entity.getTransaction().begin();
		entity.remove(l);
		entity.getTransaction().commit();
		l.setMensaje("Se Elimino Correctamente");

	}
}
