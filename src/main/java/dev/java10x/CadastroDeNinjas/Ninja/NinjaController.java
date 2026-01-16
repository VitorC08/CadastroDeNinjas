package dev.java10x.CadastroDeNinjas.Ninja;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja" , description = "Rota cria um novo ninja e insere no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na criação do Ninja.")
    })
    public ResponseEntity<String> criarNinja(
            @RequestBody
            @Parameter(description = "Usuário insere dados no corpo da requisição, para criação do novo ninja")
            NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    @GetMapping("/listar")
    @Operation(summary = "Lista um ninja por id" , description = "Rota lista um ninja de acordo com o seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninjas listados com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro para listar ninjas.")
    })
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista um ninja por id" , description = "Rota lista um ninja de acordo com o seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja econtrado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado.")
    })
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if(ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id: " + id + " não existe nos nosso registros");
        }
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera o ninja por id" , description = "Rota aletra um ninja de acordo com o seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado, não foi possível alterar.")
    })
    public ResponseEntity<?>alterarNinjaPorId(
            @Parameter(description = "Usuario manda o id no path da requisição.")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados para atualizar o ninja no corpo da requisição.")
            @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if(ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id " + id + " não existe nos nossos registros");
        }
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta um ninja por id" , description = "Rota deleta um ninja de acordo com o seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado, não foi possível deletar.")
    })
    public ResponseEntity<String> deletarNinjaPorId(
            @Parameter(description = "usuário insere o id no path do ninja que será deletado.")
            @PathVariable Long id
    ){
        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok()
                    .body("Ninja com o ID " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id " + id + " não existe nos nossos registros");
        }
    }
}
