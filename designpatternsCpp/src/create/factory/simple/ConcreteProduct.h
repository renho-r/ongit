/*
 * ConcreteProduct.h
 *
 *  Created on: 2015Äê4ÔÂ3ÈÕ
 *      Author: renho
 */

#ifndef CREATE_FACTORY_SIMPLE_CONCRETEPRODUCT_H_
#define CREATE_FACTORY_SIMPLE_CONCRETEPRODUCT_H_
#include "IProduct.h"
#include <iostream>
using namespace std;


class ConcreteProduct: public IProduct {
public:
	ConcreteProduct();
	virtual ~ConcreteProduct();
	void show();
};

#endif /* CREATE_FACTORY_SIMPLE_CONCRETEPRODUCT_H_ */
