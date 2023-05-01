package com.api.todo.list.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "ToDo_Table")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String descricao;
	private String concluida;
    private String responsavel;
	private Date dataCriacao;
	private Date dataConclusao;

}
