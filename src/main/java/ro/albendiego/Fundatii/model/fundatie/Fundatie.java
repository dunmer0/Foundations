package ro.albendiego.Fundatii.model.fundatie;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Fundatie implements Serializable {
    private String nume;
    private Sectiune sectiune;
    private Efort efort;
    private Beton beton;
}
