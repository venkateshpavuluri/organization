/**
 * @Copyright MNTSOFT  
 */
package com.mnt.erp.TestCase;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Naresh
 * @version 1.0 27-11-2013
 */
@RunWith(Suite.class)
@SuiteClasses({ SalesQuotationTest.class, SalesOrderTest.class,
		SalesInquiryTest.class, CustomerTest.class })
public class TestSuite {

}
