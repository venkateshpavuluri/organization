/**
 * 
 */
package com.mnt.erp.TestCase;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.mnt.erp.bean.RFQLineBean;
import com.mnt.erp.bean.RfqBean;
import com.mnt.erp.service.RfqService;

/**
 * @author Venkateshp
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)

/*@ContextConfiguration(locations={"file:D:\\MNTERP\\target\\MNTERP\\WEB-INF\\spring-servlet.xml"})
*/
@ContextConfiguration(locations={"file:D:\\MNTERP\\target\\MNTERP\\WEB-INF\\spring-servlet.xml"})
@WebAppConfiguration
@TransactionConfiguration(transactionManager="hibernateTransactionManager",defaultRollback=true)
@Transactional

public class RfqTestCases extends AbstractTransactionalJUnit4SpringContextTests  {
public static Logger logger=Logger.getLogger(RfqTestCases.class);
	@Autowired
	RfqService rfqService;
	@Before
	public void befor()
	{
		logger.info("first");
	}
    @Test
	public void ajjTest() {
		RfqBean bean=new RfqBean();
		bean.setRfqType("3");
		bean.setRfqNo("23");
		bean.setRfqDate("11/12/2013");
		bean.setQuotationdeadline("df");
		bean.setItemCategory("2");
		bean.setDeliveryDate("11/12/2013");
		bean.setValidFrom("11/12/2013");
		bean.setValidTo("11/12/2013");
		bean.setStorageLocation("2");
		bean.setPalntRfq("3");
		bean.setRefNumber("2");
		bean.setPurchaseGrouprfq("3");
		RFQLineBean lineBean=new RFQLineBean();
		lineBean.setMaterialid("4");
		lineBean.setQty(3);
		lineBean.setUomid("8");
		lineBean.setDeliverydate("11/12/2013");
		java.util.List<RFQLineBean> list=new ArrayList<RFQLineBean>();
		list.add(lineBean);
		bean.setRfqlinebean(list);
		assertEquals("success", rfqService.saverfqservice(bean));
		
		//Result result=

		//fail("Not yet implemented");
	}
    
    

}
