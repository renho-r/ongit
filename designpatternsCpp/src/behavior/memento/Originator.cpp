/*
 * Originator.cpp
 *
 *  Created on: 2015Äê4ÔÂ7ÈÕ
 *      Author: renho
 */
#include <iostream>
#include "Originator.h"
using namespace std;

Originator::Originator() {
	state = -1;
}

Originator::~Originator() {
	cout << "renho" << endl;
}

void Originator::setState(int s) {
	state = s;
}

int Originator::getState() {
	return state;
}

Memento* Originator::createMemento() {
	return new Memento(state);
}

void Originator::setMemento(Memento* m) {
	state = m->getState();
}

void Originator::show() {
	cout << state << endl;
}
