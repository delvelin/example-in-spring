package io.infaqbox.infaqbox_nurani_insani.box;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BoxDTO {

    private Long id;

    @Size(max = 255)
    private String nomor;

    private Integer idArea;

    @Size(max = 255)
    private String namaTempat;

    private String alamat;

    @Size(max = 255)
    private String phone;

    @Size(max = 255)
    private String cp;

}
