package com.paulo.apuracao.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Quesito {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	@NotBlank(message = "Nome não pode ser vazio")
	@Size(min = 3, max = 255, message = "Nome deve conter entre 3 e 255 caracteres")
	private String nome;
	@Column(name = "descartar_menor", nullable = false)
	private Boolean descartarMenor;
	@Column(name = "quantidade_de_jurados", nullable = false)
	@Min(value = 1, message = "Quantidade de jurados deve ser maior que 0")
	@Max(value = 20, message = "Quantidade de jurados deve ser menor ou igual a 20")
	private Integer quantidadeDeJurados;
	@Column(name = "data_criacao", nullable = false)
	private LocalDateTime dataCriacao;
	@Column(name = "data_atualizacao", nullable = false)
	private LocalDateTime dataAtualizacao;

	public Quesito() {
	}

	public Quesito(Long id, String nome, Boolean descartarMenor, Integer quantidadeDeJurados) {
		super();
		this.id = id;
		this.nome = nome;
		this.descartarMenor = descartarMenor;
		this.quantidadeDeJurados = quantidadeDeJurados;
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

	public Boolean getDescartarMenor() {
		return descartarMenor;
	}

	public void setDescartarMenor(Boolean descartarMenor) {
		this.descartarMenor = descartarMenor;
	}

	public Integer getQuantidadeDeJurados() {
		return quantidadeDeJurados;
	}

	public void setQuantidadeDeJurados(Integer quantidadeDeJurados) {
		this.quantidadeDeJurados = quantidadeDeJurados;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public String toString() {
		return "Quesito [id=" + id + ", nome=" + nome + ", descartarMenor=" + descartarMenor + ", quantidadeDeJurados="
				+ quantidadeDeJurados + ", dataCriacao=" + dataCriacao + ", dataAtualizacao=" + dataAtualizacao + "]";
	}

	@PrePersist
	private void prePersist() {
		this.dataCriacao = LocalDateTime.now();
		this.dataAtualizacao = dataCriacao;
		if (this.descartarMenor == null) {
			this.descartarMenor = false;
		}
	}

	@PreUpdate
	private void preUpdate() {
		this.dataAtualizacao = LocalDateTime.now();
		if (this.descartarMenor == null) {
			this.descartarMenor = false;
		}
	}
}
