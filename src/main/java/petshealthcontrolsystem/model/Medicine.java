package petshealthcontrolsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicineCode;
    private String medicineName;
    private String description;
    private String medicineType;
    private  String expDate;
    private String expireDate;

//    public Medicine(Long medicineCode, String medicineName, String description, String medicineType, String expDate, String expireDate) {
//        this.medicineCode = medicineCode;
//        this.medicineName = medicineName;
//        this.description = description;
//        this.medicineType = medicineType;
//        this.expDate = expDate;
//        this.expireDate = expireDate;
//    }
//
//    public Long getMedicineCode() {
//        return medicineCode;
//    }
//
//    public void setMedicineCode(Long medicineCode) {
//        this.medicineCode = medicineCode;
//    }
//
//    public String getMedicineName() {
//        return medicineName;
//    }
//
//    public void setMedicineName(String medicineName) {
//        this.medicineName = medicineName;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getMedicineType() {
//        return medicineType;
//    }
//
//    public void setMedicineType(String medicineType) {
//        this.medicineType = medicineType;
//    }
//
//    public String getExpDate() {
//        return expDate;
//    }
//
//    public void setExpDate(String expDate) {
//        this.expDate = expDate;
//    }
//
//    public String getExpireDate() {
//        return expireDate;
//    }
//
//    public void setExpireDate(String expireDate) {
//        this.expireDate = expireDate;
//    }
}
