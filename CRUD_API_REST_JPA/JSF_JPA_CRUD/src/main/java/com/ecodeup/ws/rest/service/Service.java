package com.ecodeup.ws.rest.service;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ecodeup.DAO.LibroDAO;
import com.ecodeup.model.Libro;

@Path("/PruebaOrrego")
public class Service {
	
	
	@GET
	@Path("/listadoLibros")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  List<Libro> listadoLibros() {
		LibroDAO librosDAO= new LibroDAO();

		return librosDAO.obtenerLibros();
	}
	
	@POST
	@Path("/registrarLibros")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String registrarLibros(Libro miLibro) {
	LibroDAO librosDAO= new LibroDAO();
	librosDAO.guardar(miLibro);
	 return miLibro.getMensaje();
	}
	
	@PUT
	@Path("/editarLibros")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String editarLibros(Libro miLibro) {
		LibroDAO librosDAO= new LibroDAO();

		librosDAO.editar(miLibro);
	 return miLibro.getMensaje();
	}
	

	@DELETE
	@Path("/eliminarLibros/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String eliminarLibros(@PathParam("id") int id) {
	Libro libro=new Libro();	
	LibroDAO librosDAO= new LibroDAO();

	librosDAO.eliminar(id);
	 return libro.getMensaje();
	}
	
	@GET
	@Path("/buscarLibros/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Libro buscarLibros(@PathParam("id") int id) {
		LibroDAO librosDAO= new LibroDAO();

		return librosDAO.buscar(id);
	}
	
	
	
}
