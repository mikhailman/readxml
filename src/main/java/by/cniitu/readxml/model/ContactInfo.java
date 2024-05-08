package by.cniitu.readxml.model;

import jakarta.xml.bind.annotation.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "contact-info")
//@Document("contact-info")

public class ContactInfo implements Serializable {
    private String phonenumber;
    private Address address;
}
