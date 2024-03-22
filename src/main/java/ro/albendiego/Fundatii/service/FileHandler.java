package ro.albendiego.Fundatii.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.AbstractResource;
import org.springframework.stereotype.Component;
import ro.albendiego.Fundatii.model.Proiect;

import java.io.*;

@Component
public class FileHandler {

    public void saveProject(Proiect proiect){
        String fileName = proiect.getNumar() + "_"+proiect.getNume()+".ago";
        try(FileOutputStream fileSave = new FileOutputStream(fileName);
            ObjectOutputStream save = new ObjectOutputStream(fileSave)) {
            save.writeObject(proiect);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Proiect loadProject(String name) {
        Proiect proiect = new Proiect();
        try (FileInputStream fileLoad = new FileInputStream(name);
             ObjectInputStream load = new ObjectInputStream(fileLoad)) {
            proiect = (Proiect) load.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return proiect;
    }
}
