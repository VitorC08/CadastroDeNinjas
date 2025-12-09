package dev.java10x.CadastroDeNinjas.Ninja;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    @GetMapping("/listarId")
    public String mostrarTodosOsNinjasPorId(){
        return "mostrar todos os ninjas por id";
    }

    @PutMapping("/alterarId")
    public String alterarNinjaPorId(){
        return "Alterar ninja por id";
    }

    @DeleteMapping("/deletarId")
    public String deletarNinjaPorId(){
        return "Ninja deletado por id";
    }

}
