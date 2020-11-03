package com.escom.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.escom.entities.Materia;
import com.escom.entities.MateriaId;
@Repository
public interface IMateriaDAO extends CrudRepository<Materia,MateriaId>{

}
