/*
 * IProduct.h
 *
 *  Created on: 2015��4��3��
 *      Author: renho
 */

#ifndef CREATE_FACTORY_SIMPLE_IPRODUCT_H_
#define CREATE_FACTORY_SIMPLE_IPRODUCT_H_

class IProduct {
public:
	virtual ~IProduct();
	IProduct();
	virtual void show()=0;
};

#endif /* CREATE_FACTORY_SIMPLE_IPRODUCT_H_ */
