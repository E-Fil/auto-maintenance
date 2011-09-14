package am.model.sqlmaps;

import am.model.dao.Vehicle;
import java.util.List;

public interface VehicleMapper {
  List<Vehicle> selectAll();
  List<Vehicle> selectByUser(Integer userid);
  Integer insertVehicle(Vehicle vehicle);
  Integer updateVehicle(Vehicle vehicle);
  Integer deleteVehicle(Integer idvehicle);
}
