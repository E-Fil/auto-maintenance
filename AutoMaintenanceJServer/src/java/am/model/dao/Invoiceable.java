/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package am.model.dao;

import org.json.simple.JSONObject;

/**
 *
 * @author E.Fil
 */
public class Invoiceable extends BaseDao {

  Integer idInvoiceable;
  String name;
  String description;
  Float cost;
  InvoiceableType type;

  public Float getCost() {
    return cost;
  }

  public void setCost(Float cost) {
    this.cost = cost;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getIdInvoiceable() {
    return idInvoiceable;
  }

  public void setIdInvoiceable(Integer idInvoiceable) {
    this.idInvoiceable = idInvoiceable;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public InvoiceableType getType() {
    return type;
  }

  public void setType(InvoiceableType type) {
    this.type = type;
  }

  @Override
  public JSONObject toJSONObject() {
    jsonObj.put("idInvoiceable", getIdInvoiceable());
    jsonObj.put("name", getName());
    jsonObj.put("description", getDescription());
    jsonObj.put("cost", getCost());
    jsonObj.put("type", getType());

    return jsonObj;
  }
}
