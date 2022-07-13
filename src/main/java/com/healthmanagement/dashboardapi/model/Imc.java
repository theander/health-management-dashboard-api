package com.healthmanagement.dashboardapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "imc")
public class Imc {
    @Id
    private String id;
    private Float altura;
    private Float peso;

}
