package am.model.dao;

public class Vehicle {
    private Integer idvehicle;
    private String lic_plate_number;
    private String description;
    public Vehicle() {
    }

    public void setIdvehicle(Integer idvehicle) {
        this.idvehicle = idvehicle;
    }

    public Integer getIdvehicle() {
        return idvehicle;
    }

    public void setLic_plate_number(String lic_plate_number) {
        this.lic_plate_number = lic_plate_number;
    }

    public String getLic_plate_number() {
        return lic_plate_number;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
