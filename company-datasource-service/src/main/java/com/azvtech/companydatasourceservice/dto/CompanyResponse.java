package com.azvtech.companydatasourceservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * @author Fellipe Toledo
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CompanyResponse {
    private Long id;
    private String name;
    private String cnpj;
    private String address;
    private String tel;
    private String email;
    private String site;
}

