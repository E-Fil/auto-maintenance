/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package am.model.factories;

import am.model.sqlmaps.VehicleMapper;

/**
 *
 * @author Administrator
 */
public class VehiclesFactory extends BaseFactory {
  protected VehicleMapper vehicleMapper = null;

  @Override
  protected void init() {
    vehicleMapper = sqlSession.getMapper(VehicleMapper.class);
  }

  @Override
  protected void destroy() {
    vehicleMapper = null;
  }

}
