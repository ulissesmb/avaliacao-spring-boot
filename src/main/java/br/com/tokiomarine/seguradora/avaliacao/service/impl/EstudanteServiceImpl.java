package br.com.tokiomarine.seguradora.avaliacao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.avaliacao.domain.entity.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudandeService;

@Service
public class EstudanteServiceImpl extends AbstractServiceImpl<Long, Estudante, EstudanteRepository> implements EstudandeService {


	public List<Estudante> findByMatricula(Integer matricula) {
		List<Estudante> findByMatricula = getDao().findByMatricula(matricula);
		if(findByMatricula.size() > 0) {
			return findByMatricula;
		}
		return new ArrayList<>();
	}

	@Override
	public List<Estudante> findByNome(String nome) {
		return getDao().findByNome(nome);
	}

	

}
