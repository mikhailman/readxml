package by.cniitu.readxml.model;

import jakarta.xml.bind.annotation.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@Document("user")

public class User implements Serializable {

    @XmlAttribute
    @Id
    private String id;
    private PersonalInfo personalinfo;
    private ContactInfo contactinfo;
    private Employment employment;
    private Education education;
    private Skills skills;
//    @XmlElement(name = "skills")
//    private List<String> skills;


}
