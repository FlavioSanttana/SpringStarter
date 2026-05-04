package org.studyeasy.SpringStarter.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {
    
    /*Define o campo que será a Chave Primária (Primary Key) da tabela. */
    @Id
    /*Define a estratégia de geração da chave primária (ex: GenerationType.IDENTITY para auto-incremento).  */
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "firstName", nullable = false, length = 100)
    private String firstName;

    @OneToMany(mappedBy = "account")
    private List<Post> posts;
    
}
