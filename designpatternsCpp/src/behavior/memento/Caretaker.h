/*
 * Caretaker.h
 *
 *  Created on: 2015��4��7��
 *      Author: renho
 */

#ifndef BEHAVIOR_MEMENTO_CARETAKER_H_
#define BEHAVIOR_MEMENTO_CARETAKER_H_
#include "Memento.h"

class Caretaker {
public:
	Caretaker();
	virtual ~Caretaker();
	void setMemento(Memento* m);
	Memento* getMemento();
private:
	Memento* memento;
};

#endif /* BEHAVIOR_MEMENTO_CARETAKER_H_ */
