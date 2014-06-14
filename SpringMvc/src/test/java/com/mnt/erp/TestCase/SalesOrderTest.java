/**
 *@Copyright MNTSOFT  
 */
package com.mnt.erp.TestCase;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
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

import com.mnt.erp.service.SalesOrderService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 27-11-2013
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml" })
@WebAppConfiguration
@TransactionConfiguration(transactionManager = "hibernateTransactionManager", defaultRollback = false)
@Transactional
public class SalesOrderTest extends
		AbstractTransactionalJUnit4SpringContextTests {
	private static final Logger log = Logger.getLogger(SalesOrderTest.class);

	@Autowired
	SalesOrderService sos;
	@Autowired
	XmlLabelsService xmlService;

	@Before
	public void before() {
		log.info("In Before");
	}

	@After
	public void after() {
		log.info("In After");
	}

	@Test
	public void uomSelectBox() {
		List<Object[]> actValue = sos.populateUOMIds();
		assertNotNull(actValue);

	}

	@Test
	public void searchSalesOrder() {
		List<Object[]> list = sos.searchSalesOrder();
		assertNotNull(list);

	}

}
