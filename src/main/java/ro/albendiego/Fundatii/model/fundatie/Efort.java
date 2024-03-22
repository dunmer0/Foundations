package ro.albendiego.Fundatii.model.fundatie;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Efort implements Serializable {
    private double N;
    private double My;
    private double Mz;
    private double Vy;
    private double Vz;
}
