package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;

import br.com.tokiomarine.seguradora.avaliacao.domain.entity.Estudante;

public interface EstudandeService extends AbstractService<Long, Estudante> {
	
	List<Estudante> findByNome(String nome);
	List<Estudante> findByMatricula(Integer matricula);

}
