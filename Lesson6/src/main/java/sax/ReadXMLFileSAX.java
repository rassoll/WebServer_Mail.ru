package sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author rassoll
 * @created 05.10.2018
 */
public class ReadXMLFileSAX
{
	public static Object readXML(String xmlFile)
	{
		try
		{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			//LogSaxHandler handler = new LogSaxHandler();
			SaxHandler handler = new SaxHandler();
			saxParser.parse(xmlFile, handler);

			return handler.getObject();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
