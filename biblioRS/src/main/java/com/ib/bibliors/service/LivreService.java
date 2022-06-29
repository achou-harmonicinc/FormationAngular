package com.ib.bibliors.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ib.bibliors.bo.Livre;

@Path("/livre")
public class LivreService {

	public static Map<Integer, Livre> livres;
	public static Integer compteurId = 4;

	public LivreService() {
		super();
		if (livres == null) {
			livres = new HashMap<Integer, Livre>();

			// creation d un livre
			Livre livre = new Livre(1, "123-abc-456", "livre du webservice RS static",  new Date(), 10.15f);
			// ajout a la liste
			livres.put(1, livre);
			livre = new Livre(2, "789-def-456", "livre du webservice RS 2",  new Date(), 22.15f);
			// ajout a la liste
			livres.put(2, livre);
			livre = new Livre(3, "456-etr-456", "livre du webservice RS 3",  new Date(), 16.47f);
			// ajout a la liste
			livres.put(3, livre);
		}
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Livre> findAll() {
		// List<Livre> livres = new ArrayList<Livre>();

		/*
		 * // creation d un livre Livre livre = new Livre(1, "123-abc-456",
		 * "livre du webservice RS",  new Date()); // ajout a la liste
		 * livres.add(livre); livre = new Livre(2, "789-def-456",
		 * "livre du webservice RS 2",  new Date()); // ajout a la liste
		 * livres.add(livre); livre = new Livre(3, "456-etr-456",
		 * "livre du webservice RS 3",  new Date()); // ajout a la liste
		 * livres.add(livre);
		 */
		return new ArrayList<Livre>(livres.values());
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Livre get(@PathParam("id") Integer id) {
		Livre livre = null;

		switch (id) {
		case 1:
			livre = new Livre(1, "123-abc-456", "livre du webservice RS", new Date(), 10.52f);
			break;
		case 2:
			livre = new Livre(2, "789-def-456", "livre du webservice RS 2",  new Date(), 17.52f);
			break;
		case 3:
			livre = new Livre(3, "456-etr-456", "livre du webservice RS 3",  new Date(), 15.52f);
			break;
		default:
			break;
		}

		return livre;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Livre save(Livre livre) {
		Integer id = compteurId++;
		livre.setId(id);
		livres.put(id, livre);
		
		return livre;

	}

	@PUT
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void update(Livre livre) {
		livres.put(livre.getId(), livre);

	}

	@DELETE
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void remove(Livre livre) {
		livres.remove(livre.getId());
	}

}