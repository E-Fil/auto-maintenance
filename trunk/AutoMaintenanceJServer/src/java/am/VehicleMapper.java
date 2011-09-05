package am;

import java.util.List;

public interface VehicleMapper {
    List<Vehicle> selectAll();
    List<Vehicle> selectByUser();
}
