package dev.java10x.CadastroDeNinjas.Ninja;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }

    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok()
                    .body("Ninja com o ID " + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID " + id + " não econtrado.");
        }
    }
}
