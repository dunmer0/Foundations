package ro.albendiego.Fundatii.service;

import org.springframework.stereotype.Service;
import ro.albendiego.Fundatii.model.fundatie.Beton;
import ro.albendiego.Fundatii.model.fundatie.Efort;
import ro.albendiego.Fundatii.model.fundatie.Fundatie;
import ro.albendiego.Fundatii.model.fundatie.Sectiune;

@Service
public class FundatieService {
    public Fundatie createFundatie(String nume){
        return Fundatie.builder()
                .nume(nume)
                .build();
    }

    public Sectiune createSectiune() {
        return Sectiune.builder()

                .build();
    }

}
