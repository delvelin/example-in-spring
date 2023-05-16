package io.infaqbox.infaqbox_nurani_insani.box;

import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @Size(max = 255)
    private String namaTempat;

    @NotNull
    private String alamat;

    @NotNull
    @Size(max = 255)
    private String cpPhone;

    @NotNull
    @Size(max = 255)
    private String cpName;

}
