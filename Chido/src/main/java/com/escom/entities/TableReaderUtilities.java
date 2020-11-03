package com.escom.entities;

import java.util.ArrayList;

public class TableReaderUtilities {
	private int currIndex = 0;
	public Alumno getAlumnoNotes(String htmlTable) {
		//dividimos el string en todas las tablas que vienen en la pagina html
		String[] tables = htmlTable.split("<table width=\"100%\" class=\"bottomBorder\">");
		//variable que nos indica si el esta parte del string es basura
		boolean trash = true;
		ArrayList<ArrayList<Materia>> semestres = new ArrayList<ArrayList<Materia>>();
		for(int i = 0; i<tables.length; i++) {
			// si es basura, omitimos esa parte del string
			if(trash) { trash = false; continue;}
			String[] rows = tables[i].split("</tr><tr><td>");
			trash = true;
			ArrayList<Materia> materiasSemestre = new ArrayList<Materia>();
			//System.out.println("Semestre "+i);
			//System.out.println("Clave \t Materia \t\t\t\t\t Fecha \t\t\t\t\t Periodo \t Forma Eval \t Calificacion");
			for(String row : rows) {
				if(trash) { trash = false; continue; }
				Materia newMateria = getcalificacionMateriaAlumno(row,i);
				/*System.out.println(newMateria.getClave() + " \t " + newMateria.getMateria() + "\t\t\t\t\t "
						+ newMateria.getFecha() + " \t\t\t\t\t " + newMateria.getPeriodo() + " \t "
						+ newMateria.getFormaEval() + " \t " + newMateria.getCalificacion());*/
				materiasSemestre.add(newMateria);
			}
			semestres.add(materiasSemestre);
			
		}
		return new Alumno(semestres.get(0),semestres.get(1),semestres.get(2),semestres.get(3),semestres.get(4));
	}
	// Obtenemos el nombre de la materia, sus datos y la calificacion del alumno en dicha materia
	private Materia getcalificacionMateriaAlumno(String row, int semestre) {
		String[] campos = new String[6]; //clave[0], materia[1], fecha[2], periodo[3], formaEval[4], calificacion[5]
		int camposIndex = 0;
		StringBuilder currCampo = new StringBuilder();
		for(int i = 0; i<row.length(); i++) {
			if(row.charAt(i) == '<') {
				String closetag = "</td>";
				// Revisamos si lo que sigue es un tag de cierre para comenzar a procesar el siguiente campo
				if(isTargetTag(closetag, row, i)) {
					campos[camposIndex] = currCampo.toString();
					i += closetag.length();
					//Terminamos de procesar un campo y podemos empezar a procesar el siguiente
					camposIndex++;
					currCampo = new StringBuilder();
					if(camposIndex >= campos.length) break;
				}
				String initTag= "<td>";
				String initTagwithProper = "<td align=\"left\">";
				//Si coincide con <td> el substring lo ignoramos 
				if(isTargetTag(initTag, row, i)) {
					i += initTag.length(); 
				}
				if(isTargetTag(initTagwithProper, row, i)) {
					i += initTagwithProper.length();
				}
			}
			currCampo.append(row.charAt(i));
			
		}
		
		return new Materia(semestre,campos[0],campos[1],campos[2],campos[3],campos[4],Integer.parseInt(campos[5]));
	}
	//Compara si el siguiente substring es el tag que estemos busacando
	private boolean isTargetTag(String tag, String row, int currIndex) {
		for(int j = 0; j < tag.length(); j++) {
			if(j >= row.length()) return false;
			if(row.charAt(currIndex+j) != tag.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
