package com.renho.test;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		 DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = factory.newDocumentBuilder();
		 File file = new File("beans.xml");
		 Document doc = builder.parse(file);
		 Element root = doc.getDocumentElement();
		 System.out.println(root);
		 NodeList nl = root.getChildNodes();
		 for(int i=0; i<nl.getLength(); i++) {
			 System.out.println("----------------->" + i + " s<--------------------");
			 Node node = nl.item(i);
			 System.out.println(node.getNodeName());
			 System.out.println(node.getNodeValue());
			 System.out.println(node.getPrefix());
			 System.out.println(node.getTextContent());
			 System.out.println("----------------->" + i + " s a<--------------------");
			 NamedNodeMap nnm = node.getAttributes();
			 if(null != nnm && nnm.getLength() > 0) {
				 for(int j=0; j<nnm.getLength(); j++) {
					 Node nd = nnm.item(j);
					 System.out.println(nd);
					 System.out.println("nd.getNodeName():" + nd.getNodeName());
					 System.out.println("nd.getNodeValue():" + nd.getNodeValue());
				 }
			 }
			 System.out.println("----------------->" + i + " e a<--------------------");
			 System.out.println(node.getNodeType());
			 System.out.println();
			 System.out.println();
			 System.out.println();
			 System.out.println("----------------->" + i + " e<--------------------");
		 }
	}

}
