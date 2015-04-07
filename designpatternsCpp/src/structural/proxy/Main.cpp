/*
 * Client.cpp
 *
 *  Created on: 2015Äê4ÔÂ3ÈÕ
 *      Author: renho
 */

#include <iostream>
#include "Subject.h"
#include "RealSubject.h"
#include "Proxy.h"

using namespace std;

int mainb() {
	Subject* subject = new RealSubject;
	Proxy* proxy = new Proxy(subject);
	proxy->request();

	delete subject;
	delete proxy;

	system("pause");
	return 0;
}


