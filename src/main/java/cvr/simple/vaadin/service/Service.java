package cvr.simple.vaadin.service;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import cvr.simple.vaadin.repo.PictureRepository;
import cvr.simple.vaadin.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Service {

    @Autowired
    private PictureRepository repository;

    public Resource getImage(String name) {
        Picture picture = repository.find(name);
        if(picture!=null) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!! " + name + " найден в кеше");
        }
        else{
            System.out.println("--------------------- " + name + " не найден");
            String url = "http://dnmonster:8080/monster/" + name + "?size=80";
            picture = new Picture(name, new ExternalResource(url));
            repository.save(picture);
        }
        return picture.getResource();
    }
}

