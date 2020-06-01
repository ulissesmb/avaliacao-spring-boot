package br.com.tokiomarine.seguradora.avaliacao.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.com.tokiomarine.seguradora.avaliacao.domain.entity.Estudante;

public interface EstudanteRepository extends CrudRepository<Estudante, Long>{

	List<Estudante> findByNome(String nome);
	List<Estudante> findByMatricula(Integer matricula);

}
