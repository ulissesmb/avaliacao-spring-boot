package br.com.tokiomarine.seguradora.avaliacao.utils;

import java.util.Arrays;
import java.util.List;

import br.com.tokiomarine.seguradora.avaliacao.domain.entity.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.domain.enums.CursoEnum;

public class CargaUtil {
	
	public static List<Estudante> build() {
	return Arrays.asList(
				new Estudante("Xawoy", "xawoy@tms.com.br ", 7777L, 123456, CursoEnum.ENGENHARIA_COMPUTACAO),
				new Estudante("Furae", "furae@tms.com.br ", 7778L, 678912, CursoEnum.CIENCIAS_COMPUTACAO),
				new Estudante("Fupuy", "fupuy@tms.com.br ", 7779L, 321654, CursoEnum.ENGENHARIA_COMPUTACAO),
				new Estudante("Kuer", "kuer@tms.com.br ", 7780L, 654987, CursoEnum.ANALISE_DADOS),
				new Estudante("Blias", "blias@tms.com.br ", 7781L, 666131, CursoEnum.CIENCIAS_COMPUTACAO));
	}

}
