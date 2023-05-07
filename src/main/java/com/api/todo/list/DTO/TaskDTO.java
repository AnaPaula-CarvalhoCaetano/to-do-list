package com.api.todo.list.DTO;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("concluida")
    private boolean concluida;

    @JsonProperty("responsavel")
    private String responsavel;

    @JsonProperty("dataCriacao")
    private String dataCriacao;

    @JsonProperty("dataConclusao")
    private String dataConclusao;
}
