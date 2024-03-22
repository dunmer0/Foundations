package ro.albendiego.Fundatii.model.teren;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@Builder
public class Foraj implements Serializable {
    private String nume;
    private Set<Teren> coloana;
    private double adancime =this.coloana.stream().map(Teren::getGrosime).reduce(0d, Double::sum);


}
