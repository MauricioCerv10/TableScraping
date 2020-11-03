package com.escom.entities;

import java.io.Serializable;



public class MateriaId implements Serializable {
	
	private String boleta;	
	private String clave;
		

	public MateriaId(String boleta, String clave) {		
		this.boleta = boleta;
		this.clave = clave;
	}
	
	
	public MateriaId() {		
		
	}
}
