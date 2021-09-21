package br.eti.fabriciofs.restapi;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record ProductDTO(
    @NotNull(message = "Name cannot be null") @NotEmpty(message = "Name cannot be empty") @NotBlank(message = "Name cannot be blank") String name,
    @Min(value = 0, message = "Status can be 0 or 1") @Max(value = 1, message = "Status can be 0 or 1") int status) {

  public Product toEntity() {
    return new Product(null, name, status);
  }

}
