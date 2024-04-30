package com.azvtech.companydatasourceservice.dto;

import jakarta.persistence.Column;
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
public class CompanyRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String cnpj;
    @NotBlank
    private String address;
    @NotBlank
    private String tel;
    @NotBlank
    private String email;
    @NotBlank
    private String site;
}
