package ro.albendiego.Fundatii.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ro.albendiego.Fundatii.model.Proiect;
import ro.albendiego.Fundatii.model.fundatie.Beton;
import ro.albendiego.Fundatii.model.fundatie.Efort;
import ro.albendiego.Fundatii.model.fundatie.Fundatie;
import ro.albendiego.Fundatii.model.fundatie.Sectiune;
import ro.albendiego.Fundatii.service.FileHandler;

import java.util.HashSet;
import java.util.Set;

@ShellComponent
public class TestSHell {

    @Autowired
    FileHandler fileHandler = new FileHandler();

    @ShellMethod(key = "test", value = "Tester method")
    public void test() {
        System.out.println("test");
    }

    @ShellMethod(key = "test2", value = "Tester method")
    public String test2() {
        return "This is a test";
    }

    @ShellMethod(key = "addProject", value = "Save project to file")
    public String addProject(@ShellOption String number, @ShellOption String name) {
        Proiect proiect = new Proiect();
        Set<Fundatie> fundatii = new HashSet<>();
        Sectiune sectiune = Sectiune.builder()
                .inaltime(100)
                .latime(250)
                .lungime(250)
                .build();
        Efort efort = Efort.builder()
                .N(1500)
                .My(50)
                .build();
        Beton beton = Beton.C20_25;
        Fundatie fundatie = Fundatie.builder()
                .beton(beton)
                .efort(efort)
                .sectiune(sectiune)
                .build();
        fundatii.add(fundatie);
        proiect.setFundatii(fundatii);
        proiect.setNumar(number);
        proiect.setNume(name);
        this.fileHandler.saveProject(proiect);
        return "Project saved";
    }

    @ShellMethod(key = "load")
    public String loadProject(@ShellOption String name){
        Proiect proiect = this.fileHandler.loadProject(name);
        proiect.getFundatii().forEach(System.out::println);
        return "Sectiune fundatie " + (long) proiect.getFundatii().size();
    }
}
