package dev.java10x.CadastroDeNinjas.Ninja;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas(){return "First Route";}

    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    @GetMapping("/todos")
    public String mostrarNinjas(){
        return "mostrar todos os ninjas";
    }

    @GetMapping("/todosID")
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
