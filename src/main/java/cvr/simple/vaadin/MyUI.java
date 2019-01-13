package cvr.simple.vaadin;
///////// Checked


import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import cvr.simple.vaadin.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class MyUI extends UI {
    @Autowired
    private Service service;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        TextField field = new TextField("Ваше имя");
        field.setValue("Привет");
        Button button = new Button("Ok");
        Image image = new Image();
        image.setWidth("200px");
        image.setHeight("200px");
        image.setSource(service.getImage(field.getValue()));
        VerticalLayout layout = new VerticalLayout(field, button,image);

        button.addClickListener(e -> image.setSource(service.getImage(field.getValue())));
        setContent(layout);
    }
}
