package ro.albendiego.Fundatii.model.teren;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class Foraj implements Serializable {
    private String nume;
    private Set<Teren> coloana = new HashSet<>();
    private double adancime;



}
