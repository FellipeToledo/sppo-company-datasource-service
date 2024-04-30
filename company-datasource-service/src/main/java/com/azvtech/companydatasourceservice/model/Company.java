package com.azvtech.companydatasourceservice.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Fellipe Toledo
 */

@Entity
@Getter
@Setter
@Table(name = "companies")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String cnpj;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String tel;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String site;


}
