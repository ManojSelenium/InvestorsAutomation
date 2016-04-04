package com.investors.xmlgenerator;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;

public class XMLSuiteRunner {

	private DocumentBuilderFactory docFactory;
	private DocumentBuilder docBuilder;
	private Document doc;
	private DOMImplementation domImpl;

	ReadTestData testData;

	public XMLSuiteRunner() throws ParserConfigurationException, IOException {

		docFactory = DocumentBuilderFactory.newInstance();
		docBuilder = docFactory.newDocumentBuilder();
		doc = docBuilder.newDocument();
		domImpl = doc.getImplementation();
		testData = new ReadTestData();

	}

	public Element rootTag(String a) {
		Element elementName = doc.createElement(a);
		doc.appendChild(elementName);
		return elementName;
	}

	public Element subTag(Element rootTagName, String childTagName) {
		Element childElement = doc.createElement(childTagName);
		rootTagName.appendChild(childElement);
		return childElement;
	}

	public void setAttributes(String sattributeKey, String sattributeValue, Element tagName) {

		Attr attr = doc.createAttribute(sattributeKey);
		attr.setValue(sattributeValue);
		tagName.setAttributeNode(attr);

	}

	public void createXML(String sSheetName) throws TransformerException, IOException {

		// System.out.println("Sheet name"+sSheetName);
		DocumentType doctype = domImpl.createDocumentType("doctype", "suite", "http://testng.org/testng-1.0.dtd");
		Element suiteTag = rootTag("suite");
		setAttributes("name", "AutomationSuite", suiteTag);

		setAttributes("parallel", "false", suiteTag);

		Element listnersTag = subTag(suiteTag, "listeners");

		Element listnerTag1 = subTag(listnersTag, "listener");
		Element listnerTag2 = subTag(listnersTag, "listener");

		setAttributes("class-name", "org.uncommons.reportng.HTMLReporter", listnerTag1);
		setAttributes("class-name", "org.uncommons.reportng.JUnitXMLReporter", listnerTag2);

		Element testTag = subTag(suiteTag, "test");
		setAttributes("name", "AutomationSuite", testTag);

		Element parameterTag = subTag(testTag, "parameter");

		setAttributes("name", "sBrowser", parameterTag);
		setAttributes("value", "firefox", parameterTag);
		Element classesTag = subTag(testTag, "classes");

		TreeMap<String, LinkedList> xmlMap = testData.readTestCaseExcel(sSheetName);

		for (Map.Entry<String, LinkedList> mapIterator : xmlMap.entrySet()) {

			Element classTag = subTag(classesTag, "class");
			setAttributes("name", mapIterator.getKey(), classTag);

			Element methodTag = subTag(classTag, "methods");

			LinkedList methodArray = mapIterator.getValue();

			for (int i = 0; i < methodArray.size(); i++) {

				String arrayValues = (String) methodArray.get(i);
				String methodName = arrayValues.split("@!@")[0];
				String flag = arrayValues.split("@!@")[1];

				if (flag.equalsIgnoreCase("y")) {

					Element includeTag = subTag(methodTag, "include");
					setAttributes("name", methodName, includeTag);
				} else {
					Element excludeTag = subTag(methodTag, "exclude");
					setAttributes("name", methodName, excludeTag);
				}

			}

		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		// transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC,
		// doctype.getPublicId());
		transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());
		DOMSource source = new DOMSource(doc);

		StreamResult result = new StreamResult(new File("reusable.xml"));
		transformer.transform(source, result);
		System.out.println("File Created");
	}

	public static void main(String args[]) throws ParserConfigurationException, TransformerException, IOException {

		XMLSuiteRunner xml = new XMLSuiteRunner();
		xml.createXML("Sanity");

	}
}
