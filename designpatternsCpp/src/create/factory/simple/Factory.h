/*
 * Factory.h
 *
 *  Created on: 2015��4��3��
 *      Author: renho
 */

#ifndef CREATE_FACTORY_SIMPLE_FACTORY_H_
#define CREATE_FACTORY_SIMPLE_FACTORY_H_

#include "IProduct.h"
#include "ConcreteProduct.h"
#include "ConcreteProductA.h"

class Factory {
public:
	Factory();
	virtual ~Factory();
	virtual IProduct* createProduct(int type);
};

#endif /* CREATE_FACTORY_SIMPLE_FACTORY_H_ */
