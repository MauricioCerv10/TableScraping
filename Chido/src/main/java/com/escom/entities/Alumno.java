package com.escom.entities;

import java.util.ArrayList;

public class Alumno {
	private String noBoleta;
	private ArrayList<ArrayList<Materia>> semestres;
	
	
	public Alumno() {}
	
	public Alumno(String noBoleta, ArrayList<ArrayList<Materia>> semestres) {
		this.noBoleta = noBoleta;
		this.semestres = semestres;
		
	}
	public Alumno( ArrayList<ArrayList<Materia>> semestres) {
		this.semestres = semestres;
		
	}


	public String getNoBoleta() {
		return noBoleta;
	}
	public void setNoBoleta(String noBoleta) {
		this.noBoleta = noBoleta;
	}

	public ArrayList<ArrayList<Materia>> getSemestres() {
		return semestres;
	}

	public void setSemestres(ArrayList<ArrayList<Materia>> semestres) {
		this.semestres = semestres;
	}

	
	
	
}