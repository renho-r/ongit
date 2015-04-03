/*
 * Client.cpp
 *
 *  Created on: 2015��4��3��
 *      Author: renho
 */

#include <iostream>
#include "Subject.h"
#include "RealSubject.h"
#include "Proxy.h"

using namespace std;

int main() {
	Subject* subject = new RealSubject;
	Proxy* proxy = new Proxy(subject);
	proxy->request();
	system("pause");
	return 0;
}


