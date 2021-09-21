package br.eti.fabriciofs.restapi;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record ProductDTO(@NotNull @NotEmpty @NotBlank String name, @Min(0) @Max(1) int status) {

  public Product toEntity() {
    return new Product(null, name, status);
  }

}
