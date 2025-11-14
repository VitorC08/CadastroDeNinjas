package dev.java10x.CadastroDeNinjas.Ninja;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninja")
public class NinjaController {

    @GetMapping("/listar")
    public String mostrarNinjas(){
        return "mostrar todos os ninjas";
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
