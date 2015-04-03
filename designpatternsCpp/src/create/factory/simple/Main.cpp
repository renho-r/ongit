/*
 * Main.cpp
 *
 *  Created on: 2015��4��3��
 *      Author: renho
 */

#include <iostream>
#include "IProduct.h"
#include "ConcreteProduct.h"
#include "Factory.h"
using namespace std;

int maina() {
	Factory* factory = new Factory;
	IProduct* product = factory->createProduct(0);
	product->show();
	product = factory->createProduct(1);
	product->show();
	return 0;
}


