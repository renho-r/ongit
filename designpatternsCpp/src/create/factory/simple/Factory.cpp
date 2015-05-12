/*
 * Factory.cpp
 *
 *  Created on: 2015��4��3��
 *      Author: renho
 */

#include "Factory.h"

Factory::Factory() {

}

Factory::~Factory() {

}

IProduct* Factory::createProduct(int type) {
	IProduct* product;
	if(0 == type) {
		product = new ConcreteProduct;
	}else if(1 == type){
		product = new ConcreteProductA;
	}
	return product;
}
