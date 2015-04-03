/*
 * Proxy.cpp
 *
 *  Created on: 2015��4��3��
 *      Author: renho
 */

#include "Proxy.h"

Subject* subjecti;

int renho = 100;

Proxy::Proxy() {
}

Proxy::Proxy(Subject* subject) {
	subjecti = subject;
}

Proxy::~Proxy() {
}

void Proxy::request() {
	subjecti->request();
}
