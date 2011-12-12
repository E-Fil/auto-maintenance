/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package am.model.sqlmaps;

import am.model.dao.Invoiceable;
import am.model.dao.InvoiceableType;
import am.model.dao.Vehicle;
import java.util.List;
import org.apache.ibatis.annotations.Options;

/**
 *
 * @author E.Fil
 */
public interface InvoiceablesMapper {
  /**
   * Get all invoiceable types
   * @return List<InvoiceableType>
   */
  List<InvoiceableType> getTypes();

  /**
   * Get all invoiceables for given vehicle
   * @param Vehicle vehicle
   * @return List<Invoiceable>
   */
  List<Invoiceable> getVehicleInvoiceables(Vehicle vehicle);

  /**
   * Get all invoiceables for given vehicle, filtered by given type
   * @param Vehicle vehicle
   * @param InvoiceableType type
   * @return List<Invoiceable>
   */
  List<Invoiceable> getVehicleInvoiceablesByType(Vehicle vehicle, InvoiceableType type);

  @Options(useGeneratedKeys=true)
  Integer insertInvoiceable(Invoiceable invoiceable);

  Integer updateInvoiceable(Invoiceable invoiceable);

  Integer deleteInvoiceable(Integer id);

}
