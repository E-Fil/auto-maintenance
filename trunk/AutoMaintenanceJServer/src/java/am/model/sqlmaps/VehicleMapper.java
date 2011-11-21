package am.model.sqlmaps;

import am.model.dao.Vehicle;
import am.model.dao.VehicleAssociation;
import java.util.List;

public interface VehicleMapper {
  List<VehicleAssociation> VehiclesAndAssociationsByUser(Integer userid);
  List<Vehicle> selectAll();
  List<Vehicle> selectByUser(Integer userid);
  Integer insertVehicle(Vehicle vehicle);
  Integer updateVehicle(Vehicle vehicle);
  Integer deleteVehicle(Integer idvehicle);
}
