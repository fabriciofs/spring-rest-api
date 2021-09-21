package br.eti.fabriciofs.restapi;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public record ProductDTO(@NotBlank(message = "Name cannot be blank") String name,
    @Min(value = 0, message = "Status can be 0 or 1") @Max(value = 1, message = "Status can be 0 or 1") int status) {

  public Product toEntity() {
    return new Product(null, name, status);
  }

}
