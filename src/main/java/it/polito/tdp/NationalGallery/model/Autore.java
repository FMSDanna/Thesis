package it.polito.tdp.NationalGallery.model;

public class Autore {
	String nome;

	
	
	public Autore(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome ;
	}
	
}