/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package am.model.factories;

import am.controler.exceptions.BaseException;
import am.model.dao.BaseDao;
import am.model.dao.Vehicle;
import am.model.dao.VehicleAssociation;
import am.model.sqlmaps.VehicleMapper;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class VehiclesFactory extends BaseFactory {
  protected VehicleMapper vehicleMapper = null;

  public List<VehicleAssociation> VehiclesAndAssociationsByUser(Integer userid) {
    return vehicleMapper.VehiclesAndAssociationsByUser(userid);
  }

  public List<Vehicle> selectAll() {
    return vehicleMapper.selectAll();
  }

  public List<Vehicle> selectByUser(Integer userid) {
    return vehicleMapper.selectByUser(userid);
  }

  public Integer insertVehicle(Vehicle vehicle) throws BaseException {
    Integer i = vehicleMapper.insertVehicle(vehicle);
    if (i.intValue() != 1) {
      throw new BaseException("Vehicle not inserted");
    }
    return vehicle.getIdvehicle();
  }

  public Integer updateVehicle(Vehicle vehicle) throws BaseException {
    Integer i = vehicleMapper.updateVehicle(vehicle);
    if (i.intValue() != 1) {
      throw new BaseException("Vehicle not updated");
    }
    return vehicle.getIdvehicle();
  }

  public Integer deleteVehicle(Vehicle vehicle) throws BaseException {
    Integer i = vehicleMapper.deleteVehicle(vehicle.getIdvehicle());
    if (i.intValue() != 1) {
      throw new BaseException("Vehicle not deleted");
    }
    return vehicle.getIdvehicle();
  }

  @Override
  protected void init() {
    vehicleMapper = sqlSession.getMapper(VehicleMapper.class);
  }

  @Override
  protected void destroy() {
    vehicleMapper = null;
  }

  @Override
  protected Integer create(BaseDao dao) throws BaseException {
    return insertVehicle((Vehicle)dao);
  }

  @Override
  protected Integer update(BaseDao dao) throws BaseException {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  protected Integer delete(BaseDao dao) throws BaseException {
    throw new UnsupportedOperationException("Not supported yet.");
  }

}
