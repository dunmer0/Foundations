package ro.albendiego.Fundatii.model.fundatie;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum Beton implements Serializable {
    C20_25(20),
    C25_30(25),
    C30_37(30);



    public final double rezistentaCompresiune;
    Beton(int rezistentaCompresiune) {
        this.rezistentaCompresiune = rezistentaCompresiune;
    }

}
