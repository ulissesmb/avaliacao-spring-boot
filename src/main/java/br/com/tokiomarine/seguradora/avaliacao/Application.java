package br.com.tokiomarine.seguradora.avaliacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tokiomarine.seguradora.avaliacao.domain.entity.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.impl.EstudanteServiceImpl;
import br.com.tokiomarine.seguradora.avaliacao.utils.CargaUtil;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private EstudanteServiceImpl estudanteService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Estudante> all = estudanteService.getAll();
		if(all.isEmpty()) {
			CargaUtil.build().forEach(f -> estudanteService.save(f));			
		}
		
	}
}
