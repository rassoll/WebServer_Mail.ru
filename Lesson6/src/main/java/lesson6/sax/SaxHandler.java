package lesson6.sax;

import lesson6.reflection.ReflectionHelper;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author rassoll
 * @created 05.10.2018
 */
public class SaxHandler extends DefaultHandler
{
	private static final String CLASSNAME = "class";
	private String element = null;
	private Object object = null;

	public void startDocument() throws SAXException
	{
		System.out.println("Start document");
	}

	public void endDocument() throws SAXException
	{
		System.out.println("End document ");
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
	{
		if (!qName.equals(CLASSNAME))
		{
			element = qName;
		}
		else
		{
			String className = attributes.getValue(0);
			System.out.println("Class name: " + className);
			object = ReflectionHelper.createInstance(className);
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException
	{
		element = null;
	}

	public void characters(char ch[], int start, int length) throws SAXException
	{
		if (element != null)
		{
			String value = new String(ch, start, length);
			System.out.println(element + " = " + value);
			ReflectionHelper.setFieldValue(object, element, value);
		}
	}

	public Object getObject()
	{
		return object;
	}
}