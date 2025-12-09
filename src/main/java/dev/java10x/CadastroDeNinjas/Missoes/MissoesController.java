package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

   private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes (){
        return missoesService.listarMissoes();
    }

    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao criado com sucesso!" ;
    }

    @PutMapping ("/alterar")
    public String alterarMissao(){
        return "Missao alterada com sucesso!" ;
    }

    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada com sucesso!" ;
    }


}
