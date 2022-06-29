	package com.ib.bibliors.bo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
	@XmlTransient
	private LocalDate dateDeParution;

	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Livre(Integer id, String isbn, String titre, LocalDate dateDeParution) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.titre = titre;
		this.dateDeParution = dateDeParution;
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

	public LocalDate getDateDeParution() {
		return dateDeParution;
	}

	public void setDateDeParution(LocalDate dateDeParution) {
		this.dateDeParution = dateDeParution;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", isbn=" + isbn + ", titre=" + titre + ", dateDeParution=" + dateDeParution + "]";
	}

}


