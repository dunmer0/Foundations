package ro.albendiego.Fundatii.service;

import org.springframework.stereotype.Service;
import ro.albendiego.Fundatii.model.teren.Foraj;
import ro.albendiego.Fundatii.model.teren.Teren;

@Service
public class ForajService {

    public Foraj createForaj(String nume) {
        Foraj foraj = new Foraj();
        foraj.setNume(nume);
        return foraj;
    }

    public void addTeren(Foraj foraj, Teren teren) {
        foraj.getColoana().add(teren);
    }

    public void calAdancime(Foraj foraj) {
        foraj.setAdancime(foraj.getColoana().stream().map(Teren::getGrosime).reduce(0.0, Double::sum));
    }
}
