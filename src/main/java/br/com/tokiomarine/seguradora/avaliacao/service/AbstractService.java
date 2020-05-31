package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;

import br.com.tokiomarine.seguradora.avaliacao.domain.interfaces.PersistentEntity;

public interface AbstractService<ID extends Number, E extends PersistentEntity> {

	List<E> getAll() throws Exception;
	
	E getById(ID id) throws Exception;
	
	void delete(E entity);
	
	void deleteById(ID id);
	
	E save(E entity);
	
}
