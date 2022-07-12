package ec.edu.espe.arquitectura.restclient.products.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ProductDTO {
    
    private String id;
    private String name;
    private Float price;
    private Integer existence;
    private Date manufacturDate;
}
