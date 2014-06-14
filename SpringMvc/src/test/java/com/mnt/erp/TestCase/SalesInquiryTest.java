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

import com.mnt.erp.service.SalesInquiryService;

/**
 * @author Naresh
 * @version 1.0 27-11-2013
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml" })
@WebAppConfiguration
@TransactionConfiguration(transactionManager = "hibernateTransactionManager", defaultRollback = false)
@Transactional
public class SalesInquiryTest extends
		AbstractTransactionalJUnit4SpringContextTests {
	private static final Logger log = Logger.getLogger(SalesInquiryTest.class);
	@Autowired
	SalesInquiryService sis;

	@Before
	public void before() {
		log.info("In Before");
	}

	@After
	public void after() {
		log.info("In After");
	}

	@Test
	public void searchSalesInquiry() {
		List<Object[]> actValue = sis.searchSalesInquiry();
		assertNotNull(actValue);

	}

	/*
	 * @Test public void salesInquiryDelete() { String actValue =
	 * sis.deleteSalesInquiry(1); assertEquals("Deleted", actValue); }
	 */

}
