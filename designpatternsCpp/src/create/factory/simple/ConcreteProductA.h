/*
 * ConcreteProductA.h
 *
 *  Created on: 2015��4��3��
 *      Author: renho
 */

#ifndef CREATE_FACTORY_SIMPLE_CONCRETEPRODUCTA_H_
#define CREATE_FACTORY_SIMPLE_CONCRETEPRODUCTA_H_

#include "IProduct.h"

class ConcreteProductA: public IProduct {
public:
	ConcreteProductA();
	virtual ~ConcreteProductA();
	void show();
};

#endif /* CREATE_FACTORY_SIMPLE_CONCRETEPRODUCTA_H_ */
