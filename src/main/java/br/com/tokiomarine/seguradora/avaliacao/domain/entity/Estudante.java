package br.com.tokiomarine.seguradora.avaliacao.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.tokiomarine.seguradora.avaliacao.domain.enums.CursoEnum;
import br.com.tokiomarine.seguradora.avaliacao.domain.interfaces.PersistentEntity;

@Entity
@Table(name = "TP_ESTUDANTE")
public class Estudante implements PersistentEntity, Serializable {
	
	private static final long serialVersionUID = 9020234413846113980L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String email;
	
	private Integer telefone;
	
	@NotNull(message = "Matrícula é obrigatória")
	private Integer matricula;
	
	@Enumerated(EnumType.ORDINAL)
	private CursoEnum curso;
	
	public Estudante() {
	}

	public Estudante(Long id, String nome, String email, Integer telefone, Integer matricula, CursoEnum curso) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.matricula = matricula;
		this.curso = curso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public CursoEnum getCurso() {
		return curso;
	}

	public void setCurso(CursoEnum curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudante other = (Estudante) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Estudante [id=").append(id).append(", nome=").append(nome).append(", email=").append(email)
				.append(", telefone=").append(telefone).append(", matricula=").append(matricula).append(", curso=")
				.append(curso).append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	
}
