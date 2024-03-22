package ro.albendiego.Fundatii.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.util.StringUtils;
import ro.albendiego.Fundatii.model.Proiect;
import ro.albendiego.Fundatii.model.fundatie.Beton;
import ro.albendiego.Fundatii.model.fundatie.Efort;
import ro.albendiego.Fundatii.model.fundatie.Fundatie;
import ro.albendiego.Fundatii.model.fundatie.Sectiune;
import ro.albendiego.Fundatii.service.FileHandler;
import ro.albendiego.Fundatii.service.ForajService;
import ro.albendiego.Fundatii.service.FundatieService;
import ro.albendiego.Fundatii.utils.InputReader;

import java.util.HashSet;
import java.util.Set;

@ShellComponent
public class TestSHell {

    @Autowired
    FileHandler fileHandler;
    @Autowired
    FundatieService fundatieService;
    @Autowired
    ForajService forajService;
    @Autowired
    InputReader inputReader;
    Proiect proiect = new Proiect();

    @ShellMethod(key = "test", value = "Tester method")
    public void test() {
        System.out.println("test");
    }

    @ShellMethod(key = "test2", value = "Tester method")
    public String test2() {
        return "This is a test";
    }

    @ShellMethod(key = "create project", value = "Create project")
    public String createProject(@ShellOption String number, @ShellOption String name) {
        proiect.setNumar(number);
        proiect.setNume(name);
        return "Proiect nr: " +number+ "_"+name + " a fost creat.";
    }

    @ShellMethod(key = "create foundation", value = "Create foundations and add it to the project")
    public String createFoundation(@ShellOption String name) {
        Fundatie fundatie = this.fundatieService.createFundatie(name);
        Sectiune sectiune = this.fundatieService.createSectiune();
        do {
            String inaltime = inputReader.prompt("Enter height");
            if (StringUtils.hasText(inaltime) && !inaltime.equals("0")) {
                sectiune.setInaltime(Integer.parseInt(inaltime));
            } else {
                System.out.println("Value must not be 0");
            }
        } while (sectiune.getInaltime() == 0);
        do {
            String latime = inputReader.prompt("Enter width");
            if (StringUtils.hasText(latime) && !latime.equals("0")) {
                sectiune.setLatime(Integer.parseInt(latime));
            } else {
                System.out.println("Value must not be 0");
            }
        } while (sectiune.getLatime() == 0);
        do {
            String lungime = inputReader.prompt("Enter length");
            if (StringUtils.hasText(lungime) && !lungime.equals("0")) {
                sectiune.setLungime(Integer.parseInt(lungime));
            } else {
                System.out.println("Value must not be 0");
            }
        } while (sectiune.getLungime() == 0);
        fundatie.setSectiune(sectiune);
        this.proiect.getFundatii().add(fundatie);
        return "Testare finalizata";
    }

    @ShellMethod(key = "load")
    public String loadProject(@ShellOption String name){
        proiect = this.fileHandler.loadProject(name);
        proiect.getFundatii().forEach(System.out::println);
        return "Sectiune fundatie " + (long) proiect.getFundatii().size();
    }

    @ShellMethod(key = "getProject")
    public String getProject(){
        this.proiect.getFundatii().forEach(System.out::println);
        return this.proiect.getNume();
    }
}
