package br.com.fiap.cineFiap.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class SalaResponseDTO {
    private Long id;
    private String nome;
    private double preco;
    private LocalDateTime dataExclusao;
}
