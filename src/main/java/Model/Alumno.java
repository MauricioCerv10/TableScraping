package Model;

import java.util.ArrayList;

public class Alumno {
	private String noBoleta;
	private ArrayList<Materia> primerSemestre;
	private ArrayList<Materia> segundoSemestre;
	private ArrayList<Materia> tercerSemestre;
	private ArrayList<Materia> cuartoSemestre;
	private ArrayList<Materia> quintoSemestre;
	
	public Alumno() {}
	
	public Alumno(String noBoleta, ArrayList<Materia> primerSemestre, ArrayList<Materia> segundoSemestre, ArrayList<Materia> tercerSemestre,
			ArrayList<Materia> cuartoSemestre, ArrayList<Materia> quintoSemestre) {
		this.noBoleta = noBoleta;
		this.primerSemestre = primerSemestre;
		this.segundoSemestre = segundoSemestre;
		this.tercerSemestre = tercerSemestre;
		this.cuartoSemestre = cuartoSemestre;
		this.quintoSemestre = quintoSemestre;
	}



	public String getNoBoleta() {
		return noBoleta;
	}
	public void setNoBoleta(String noBoleta) {
		this.noBoleta = noBoleta;
	}
	public ArrayList<Materia> getPrimerSemestre() {
		return primerSemestre;
	}
	public void setPrimerSemestre(ArrayList<Materia> primerSemestre) {
		this.primerSemestre = primerSemestre;
	}
	public ArrayList<Materia> getSegundoSemestre() {
		return segundoSemestre;
	}
	public void setSegundoSemestre(ArrayList<Materia> segundoSemestre) {
		this.segundoSemestre = segundoSemestre;
	}
	public ArrayList<Materia> getTercerSemestre() {
		return tercerSemestre;
	}
	public void setTercerSemestre(ArrayList<Materia> tercerSemestre) {
		this.tercerSemestre = tercerSemestre;
	}
	public ArrayList<Materia> getCuartoSemestre() {
		return cuartoSemestre;
	}
	public void setCuartoSemestre(ArrayList<Materia> cuartoSemestre) {
		this.cuartoSemestre = cuartoSemestre;
	}
	public ArrayList<Materia> getQuintoSemestre() {
		return quintoSemestre;
	}
	public void setQuintoSemestre(ArrayList<Materia> quintoSemestre) {
		this.quintoSemestre = quintoSemestre;
	}
	
	
}
