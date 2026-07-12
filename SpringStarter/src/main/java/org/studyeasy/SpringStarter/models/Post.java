package org.studyeasy.SpringStarter.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id; 

    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    private LocalDateTime createdAt;

    /*
    Isso significa que uma nova coluna será adicionada ao banco de dados e essa coluna conterá uma chave estrangeira para outra tabela.
    */
    @ManyToOne
    @JoinColumn(name="account_id", referencedColumnName = "id", nullable = false)
    private Account account;

}
