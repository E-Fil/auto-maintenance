package am.model.dao;

import org.json.simple.JSONObject;

public class Vehicle extends BaseDao {
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

  @Override
  public JSONObject toJSONObject() {
    jsonObj.put("idvehicle", idvehicle);
    jsonObj.put("lic_plate_number", lic_plate_number);
    jsonObj.put("description", description);

    return jsonObj;
  }
}
