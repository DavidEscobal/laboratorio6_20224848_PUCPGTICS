package org.example.lab6_20224848.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter @Setter
public class roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                  // PK: roles.id

    @Column(nullable = false, length = 50, unique = true)
    private String nombre;            // 'admin' | 'logistica' | etc.
}
