package io.infaqbox.infaqbox_nurani_insani.area;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AreaDTO {

    private Long id;
    @NotNull
    private String namaArea;

}
