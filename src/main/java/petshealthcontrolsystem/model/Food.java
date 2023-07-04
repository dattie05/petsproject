package petshealthcontrolsystem.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity

public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;
    private String foodName;
    private String foodNutrient;
    private String description;
    private String foodType;
    private  String expDate;
    private String expireDate;

}

