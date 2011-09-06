package am.model.sqlmaps;

import am.model.dao.Vehicle;
import java.util.List;

public interface VehicleMapper {
    List<Vehicle> selectAll();
    List<Vehicle> selectByUser();
}
