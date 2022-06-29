package com.ib.bibliors.bo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Livre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4843734356455382449L;
	@XmlAttribute
	private Integer id;
	private String isbn;
	private String titre;
	//@XmlTransient
	private Date dateDeParution;
	private Float prix;

	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Livre(Integer id, String isbn, String titre, Date dateDeParution) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.titre = titre;
		this.dateDeParution = dateDeParution;
	}

	public Livre(Integer id, String isbn, String titre, Date dateDeParution, Float prix) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.titre = titre;
		this.dateDeParution = dateDeParution;
		this.prix = prix;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	

	public Date getDateDeParution() {
		return dateDeParution;
	}

	public void setDateDeParution(Date dateDeParution) {
		this.dateDeParution = dateDeParution;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", isbn=" + isbn + ", titre=" + titre + ", dateDeParution=" + dateDeParution
				+ ", prix=" + prix + "]";
	}
}