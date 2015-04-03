/*
 * Proxy.h
 *
 *  Created on: 2015Äê4ÔÂ3ÈÕ
 *      Author: renho
 */

#ifndef PROXY_PROXY_H_
#define PROXY_PROXY_H_

#include "Subject.h"
#include "RealSubject.h"

class Proxy: public Subject {
public:
	Proxy();
	Proxy(Subject* subject);
	virtual ~Proxy();
	void request();
};

#endif /* PROXY_PROXY_H_ */
