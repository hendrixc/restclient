package ec.edu.espe.arquitectura.restclient.products.resource;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.restclient.products.apiclient.ProductClientService;
import ec.edu.espe.arquitectura.restclient.products.dto.ProductDTO;

@RestController
@RequestMapping(path = "/facturacion")
public class ClientResource {

    private final ProductClientService service;
    
    public ClientResource(ProductClientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> obtainProductsForTransaction() {
        System.err.println("Antes del call");
        return ResponseEntity.ok(this.service.obtainAll());
    }

    @GetMapping( path = "/add")
    public ResponseEntity addProduct() {
        ProductDTO dto = new ProductDTO();
        dto.setExistence(1);
        dto.setManufacturDate(new Date());
        dto.setName("Producto Magico");
        dto.setPrice(1000f);
        this.service.addProduct(dto);
        return ResponseEntity.ok().build();
    }
}
