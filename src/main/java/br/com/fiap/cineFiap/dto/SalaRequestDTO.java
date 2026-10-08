package br.com.fiap.cineFiap.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class SalaRequestDTO {
    private Long id;
    private String nome;
    private double preco;
    private LocalDateTime dataExclusao;
}
