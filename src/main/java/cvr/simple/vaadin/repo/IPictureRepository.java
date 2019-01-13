package cvr.simple.vaadin.repo;

import cvr.simple.vaadin.Picture;

public interface IPictureRepository {
    void save(Picture picture);
    Picture find(String name);
}
