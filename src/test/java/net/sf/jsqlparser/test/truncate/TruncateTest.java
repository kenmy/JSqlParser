package net.sf.jsqlparser.test.truncate;

import java.io.StringReader;

import junit.framework.TestCase;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.truncate.Truncate;

public class TruncateTest extends TestCase {

	private CCJSqlParserManager parserManager = new CCJSqlParserManager();

	public TruncateTest(String arg0) {
		super(arg0);
	}
	
	private void doTestTrucate(boolean withTable) throws Exception{
		String statement = "TRUncATE " + (withTable?"TABLE ":"") + "myschema.mytab";
		Truncate truncate = (Truncate) parserManager.parse(new StringReader(statement));
		assertEquals("myschema", truncate.getTable().getSchemaName());
		assertEquals("myschema.mytab", truncate.getTable().getFullyQualifiedName());
		assertEquals(statement.toUpperCase(), truncate.toString().toUpperCase());
	}

	public void testTruncate() throws Exception {
		doTestTrucate(false);
		doTestTrucate(true);
		String statement = "TRUncATE   TABLE    mytab";
		String toStringStatement = "TRUncATE TABLE mytab";
		Truncate truncate = (Truncate) parserManager.parse(new StringReader(statement));
		assertEquals("mytab", truncate.getTable().getName());
		assertEquals(toStringStatement.toUpperCase(), truncate.toString().toUpperCase());
	}
}
