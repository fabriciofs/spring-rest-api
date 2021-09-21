package br.eti.fabriciofs.restapi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductRepository repository;

  record Response(List<Product> list, int total) {
  }

  public ProductController(ProductRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public Response findAll() {
    var list = this.repository.findAll();
    return new Response(list, list.size());
  }

  @PostMapping
  public Product create(@RequestBody @Valid ProductDTO product) {
    return this.repository.save(product.toEntity());
  }

}
