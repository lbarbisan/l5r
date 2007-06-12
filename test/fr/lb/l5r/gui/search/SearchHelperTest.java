/**
 * 
 */
package fr.lb.l5r.gui.search;

import java.util.Map;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Administrateur
 *
 */
public class SearchHelperTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link fr.lb.l5r.gui.search.SearchHelper#retrieveSearchField(org.eclipse.ui.IEditorPart)}.
	 */
	@Test
	public void testRetrieveSearchField() {
		SearchClassOne editorPart = new SearchClassOne();
		Map<String, Object> fields =  SearchHelper.retrieveSearchField(editorPart);
		Assert.assertTrue(fields.containsKey("name"));
		Assert.assertTrue(fields.containsKey("school"));
	}

}
