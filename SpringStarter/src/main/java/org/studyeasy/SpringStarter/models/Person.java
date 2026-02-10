package org.studyeasy.SpringStarter.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 /*Marca a classe Java como uma entidade JPA, o que significa que ela 
 será mapeada para uma tabela de banco de dados. */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person {
    
    /*Define o campo que será a Chave Primária (Primary Key) da tabela. */
    @Id
    /*Define a estratégia de geração da chave primária (ex: GenerationType.IDENTITY para auto-incremento).  */
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "firstName", nullable = false, length = 100)
    private String firstName;
    
    @Column(name = "lastName", nullable = false, length = 100)
    private String lastName; 
    
    @Column(name = "email", nullable = false, length = 100)
    private String email; 

}
