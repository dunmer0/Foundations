package ro.albendiego.Fundatii.model.teren;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Data
@Builder
public class Teren implements Serializable {
    private String nume;
    private double grosime;
    private double unghiFrecare;
    private double coeziune;
    private double moduleEdometric;
    private double coeficientCorectie;
}
