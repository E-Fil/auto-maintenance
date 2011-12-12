/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package am.model.factories;

import am.controler.exceptions.BaseException;
import am.model.dao.BaseDao;
import am.model.dao.Invoiceable;
import am.model.sqlmaps.InvoiceablesMapper;

/**
 *
 * @author E.Fil
 */
public class InvoiceablesFactory extends BaseFactory {
  protected InvoiceablesMapper invoiceablesMapper = null;

  public InvoiceablesFactory() {
    super();
    logger.debug("InvoiceablesFactory generalUseInstance started");
  }

  @Override
  protected void init() {
    invoiceablesMapper = sqlSession.getMapper(InvoiceablesMapper.class);
  }

  @Override
  protected void destroy() {
    invoiceablesMapper = null;
  }

  @Override
  protected Integer create(BaseDao dao) throws BaseException {
    return createInvoiceable((Invoiceable)dao);
  }

  @Override
  protected Integer update(BaseDao dao) throws BaseException {
    return updateInvoiceable((Invoiceable)dao);
  }

  @Override
  protected Integer delete(BaseDao dao) throws BaseException {
    return deleteInvoiceable((Invoiceable)dao);
  }

  protected Integer createInvoiceable(Invoiceable invoiceable) {
    return invoiceablesMapper.insertInvoiceable(invoiceable);
  }

  protected Integer updateInvoiceable(Invoiceable invoiceable) {
    return invoiceablesMapper.updateInvoiceable(invoiceable);
  }

  protected Integer deleteInvoiceable(Invoiceable invoiceable) {
    return invoiceablesMapper.deleteInvoiceable(invoiceable.getIdInvoiceable());
  }
}
