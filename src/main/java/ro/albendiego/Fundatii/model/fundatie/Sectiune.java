package ro.albendiego.Fundatii.model.fundatie;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Sectiune implements Serializable {
    private int latime;
    private int lungime;
    private int inaltime;
}
