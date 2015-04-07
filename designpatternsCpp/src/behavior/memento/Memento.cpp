/*
 * Memento.cpp
 *
 *  Created on: 2015��4��7��
 *      Author: renho
 */

#include "Memento.h"

Memento::Memento() {
	state = -1;
}

Memento::Memento(int s) {
	state = s;
}

Memento::~Memento() {
}

int Memento::getState() {
	return state;
}

void Memento::setState(int s) {
	state = s;
}
