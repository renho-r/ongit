/*
 * RealSubject.h
 *
 *  Created on: 2015��4��3��
 *      Author: renho
 */

#ifndef PROXY_REALSUBJECT_H_
#define PROXY_REALSUBJECT_H_

#include "Subject.h"
#include <iostream>
using namespace std;


class RealSubject: public Subject {
public:
	RealSubject();
	virtual ~RealSubject();
	void request();
};

#endif /* PROXY_REALSUBJECT_H_ */
