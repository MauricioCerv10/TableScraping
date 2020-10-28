package Model;

public class Materia {
	private int semestre;
	private String clave;
	private String materia;
	private String fecha;
	private String periodo;
	private String formaEval;
	private int calificacion;
	
	public Materia() {}
	
	public Materia(int semestre,String clave, String materia, String fecha, String periodo, String formaEval, int calificacion) {
		this.semestre = semestre;
		this.clave = clave;
		this.materia = materia;
		this.fecha = fecha;
		this.periodo = periodo;
		this.formaEval = formaEval;
		this.calificacion = calificacion;
	}

	

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getFormaEval() {
		return formaEval;
	}
	public void setFormaEval(String formaEval) {
		this.formaEval = formaEval;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
}
