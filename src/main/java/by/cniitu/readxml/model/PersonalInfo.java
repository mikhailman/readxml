package by.cniitu.readxml.model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement (name = "personal-info")
//@Document("personal-info")

public class PersonalInfo implements Serializable {
    private String firstname;
    private String lastname;
    private String email;
    private String dateofbirth;
    private String gender;
}
