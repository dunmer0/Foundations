package ro.albendiego.Fundatii.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.albendiego.Fundatii.model.fundatie.Fundatie;
import ro.albendiego.Fundatii.model.teren.Foraj;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
public class Proiect implements Serializable {
    private String numar;
    private String nume;
    private Set<Fundatie> fundatii;
    private Set<Foraj> foraje;
}
