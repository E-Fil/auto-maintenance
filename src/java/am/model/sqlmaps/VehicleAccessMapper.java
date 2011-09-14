package am.model.sqlmaps;

import am.model.dao.VehicleAssociation;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface VehicleAccessMapper {
  List<VehicleAssociation> selectForUser();

  List<VehicleAssociation> selectForVehicle();

  Integer insertForUser(VehicleAssociation va);

  Integer updateAssociation(VehicleAssociation va);

  Integer deleteAssociation(Integer id);

}
