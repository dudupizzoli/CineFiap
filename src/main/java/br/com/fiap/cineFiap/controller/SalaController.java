package br.com.fiap.cineFiap.controller;

import br.com.fiap.cineFiap.dto.SalaRequestDTO;
import br.com.fiap.cineFiap.dto.SalaResponseDTO;
import br.com.fiap.cineFiap.mapper.SalaMapper;
import br.com.fiap.cineFiap.models.Sala;
import br.com.fiap.cineFiap.service.SalaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin("*") //@CrossOrigin(origins = "http://localhost:3000") | CrossOrigin("*") dá permissão pra aplicação ser acessada de qualquer lugar
@RestController
@RequestMapping("/salas")
public class SalaController {
    private final SalaService salaService;

    public SalaController() {
        this.salaService = new SalaService();
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody SalaRequestDTO dto){
        try{
            Sala sala = SalaMapper.toEntity(dto);
            salaService.cadastrar(sala);
            return ResponseEntity.status(HttpStatus.CREATED).body("A sala foi criada com sucesso!");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body("Não foi possível realizar o cadastro pois uma ou mais informações eram inválidas: " + e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaResponseDTO> buscarPorId(@PathVariable Long id){
        try{
            Sala salaBuscada = salaService.buscarPorId(id);

            if (salaBuscada == null || salaBuscada.getId() == null) {
                return ResponseEntity.notFound().build();
            }
            else{
                return ResponseEntity.ok(SalaMapper.toDTO(salaBuscada));
            }

        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<SalaResponseDTO>> salasEmCartaz(){
        try{

            return ResponseEntity.ok(salaService.listar()
                    .stream()
                    .map(SalaMapper::toDTO)
                    .toList());
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


//    public void excluir ( Long id){
//
//            dao.excluir(id);
//
//    }

    @PutMapping("/{id}")
    public ResponseEntity<String> alterar(@PathVariable Long id, @RequestBody SalaRequestDTO dto){
        try{
            Sala sala = SalaMapper.toEntity(dto);
            salaService.alterar(sala, id);
            return ResponseEntity.ok().body("A sala foi atualizada com sucesso!");
        }catch(IllegalArgumentException e){
            return  ResponseEntity.badRequest().body("Ocorreu um erro: " + e);
        }
    }

    @PutMapping("/excluir/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        try{
            salaService.excluir(id);
            return ResponseEntity.ok().body("A sala foi atualizada com sucesso!");
        } catch (IllegalArgumentException e) {
            return  ResponseEntity.badRequest().body("Ocorreu um erro: " + e);
        }


    }
}