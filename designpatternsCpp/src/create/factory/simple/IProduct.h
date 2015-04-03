/*
 * IProduct.h
 *
 *  Created on: 2015Äê4ÔÂ3ÈÕ
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
