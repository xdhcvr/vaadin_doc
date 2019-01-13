package cvr.simple.vaadin;

import com.vaadin.server.Resource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
//import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Picture implements Serializable {
    private static final long serialVersionUID = 8663375521470672664L;
    @Id
    private String name;
    private Resource resource;

//    public Picture(String name, Resource resource) {
//        this.name = name;
//        this.resource = resource;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Resource getResource() {
//        return resource;
//    }
//
//    public void setResource(Resource resource) {
//        this.resource = resource;
//    }
}
