package br.com.fiap.cineFiap.mapper;

import br.com.fiap.cineFiap.dto.SalaRequestDTO;
import br.com.fiap.cineFiap.dto.SalaResponseDTO;
import br.com.fiap.cineFiap.models.Sala;

public class SalaMapper {
    public static Sala toEntity(SalaRequestDTO dto){
        Sala sala = new Sala();
        sala.setId(dto.getId());
        sala.setNome(dto.getNome());
        sala.setPreco(dto.getPreco());
        sala.setDataExclusao(dto.getDataExclusao());
        return sala;
    }

    public static SalaResponseDTO toDTO (Sala sala){
        SalaResponseDTO dto = new SalaResponseDTO();
        dto.setId(sala.getId());
        dto.setNome(sala.getNome());
        dto.setPreco(sala.getPreco());
        dto.setDataExclusao(sala.getDataExclusao());
        return dto;
    }
}
