package com.renho;

import java.util.Comparator;
import org.jdom.Element;

public class ComparatorList implements Comparator<Element>{

	@Override
	public int compare(Element o1, Element o2) {
		return o1.getAttributeValue("index").compareTo(o2.getAttributeValue("index"));
	}
}
