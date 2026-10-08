package br.com.fiap.cineFiap.service;

import br.com.fiap.cineFiap.dao.SalaDAO;
import br.com.fiap.cineFiap.models.Sala;

import java.util.List;

public class SalaService {
    private final SalaDAO salaDAO;

    public SalaService() {
        this.salaDAO = new SalaDAO();
    }

    public List<Sala> listar(){
        try{
            return salaDAO.listar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Sala buscarPorId(Long id){
        if(id == null){
            throw new IllegalArgumentException("Nenhum ID foi fornecido.");
        }
        Sala salaBuscada = salaDAO.buscarPorId(id);
        if(salaBuscada == null) {
            throw new IllegalArgumentException("Sala não encontrada para o ID fornecido.");
        } else{
            return salaBuscada;
        }
    }

    public void cadastrar(Sala sala){
        if(sala.getNome() == null || sala.getNome().isEmpty()){
            throw new IllegalArgumentException("O nome da sala é obrigatório.");
        }
        if(sala.getPreco() <= 0){
            throw new IllegalArgumentException("O preço não pode ser menor ou igual a 0.");
        }
        if(sala.getDataExclusao() != null){
            throw new IllegalArgumentException("A data de exclusão precisa ser nula.");
        }
        else{
            salaDAO.cadastrar(sala);
        }
    }

    public void alterar(Sala sala, Long id){
        Sala salaBuscada = salaDAO.buscarPorId(id);
        if(id == null){
            throw new IllegalArgumentException("Nenhum ID foi fornecido.");
        }
        if(salaBuscada.getId() == null) {
            throw new IllegalArgumentException("Sala não encontrada para o ID fornecido.");
        }
        if(sala.getNome() == null || sala.getNome().isEmpty()){
            throw new IllegalArgumentException("O nome da sala é obrigatório.");
        }
        if(sala.getPreco() <= 0){
            throw new IllegalArgumentException("O preço não pode ser menor ou igual a 0.");
        }
        if(sala.getDataExclusao() != null){
            throw new IllegalArgumentException("A data de exclusão precisa ser nula.");
        }
        else{
            salaDAO.alterar(sala);
        }
    }

    public void excluir(Long id){
        if(id == null){
            throw new IllegalArgumentException("Nenhum ID foi fornecido.");
        }
        Sala salaBuscada = salaDAO.buscarPorId(id);
        if (salaBuscada.getDataExclusao() != null){
            throw new IllegalArgumentException("A data de exclusão precisa ser nula.");
        }
        else{
            salaDAO.deletar(id);
        }
    }


}