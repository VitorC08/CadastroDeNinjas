package dev.java10x.CadastroDeNinjas.Ninja;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tb_cadastro")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NinjaModel {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private String name;

     @Column(unique = true)
     private String email;

     private int idade;

     @ManyToOne
     @JoinColumn(name = "missoes_id")
     private MissoesModel missoes;

}
