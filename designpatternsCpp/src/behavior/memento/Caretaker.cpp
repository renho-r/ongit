/*
 * Caretaker.cpp
 *
 *  Created on: 2015Äê4ÔÂ7ÈÕ
 *      Author: renho
 */

#include "Caretaker.h"

Caretaker::Caretaker() {
}

Caretaker::~Caretaker() {
}

void Caretaker::setMemento(Memento* m) {
	memento = m;
}

Memento* Caretaker::getMemento() {
	return memento;
}
