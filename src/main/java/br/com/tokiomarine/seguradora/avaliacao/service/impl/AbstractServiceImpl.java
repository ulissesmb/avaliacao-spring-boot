package br.com.tokiomarine.seguradora.avaliacao.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.util.CollectionUtils;

import br.com.tokiomarine.seguradora.avaliacao.domain.interfaces.PersistentEntity;
import br.com.tokiomarine.seguradora.avaliacao.exception.NotFoundException;
import br.com.tokiomarine.seguradora.avaliacao.service.AbstractService;

public class AbstractServiceImpl<ID extends Number, E extends PersistentEntity, DAO extends CrudRepository<E, ID>> implements AbstractService<ID, E> {

	@Autowired
	private DAO dao;
	
	@Override
	public List<E> getAll() throws NotFoundException {
		List<E> entities =  (List<E>) getDao().findAll();
		if(CollectionUtils.isEmpty(entities)){
			return new ArrayList<>();
		}
		return entities;
	}

	@Override
	public E getById(ID id) throws Exception {
		Optional<E> entity = dao.findById(id);
		return entity.orElse(null);
	}

	@Override
	public void delete(E entity) {
		dao.delete(entity);
	}

	@Override
	public void deleteById(ID id) {
		dao.deleteById(id);		
	}

	@Override
	public E save(E entity) {
		return dao.save(entity);
	}

	public DAO getDao() {
		return dao;
	}
	

}
