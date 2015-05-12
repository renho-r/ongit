/*
 * Originator.h
 *
 *  Created on: 2015��4��7��
 *      Author: renho
 */

#ifndef BEHAVIOR_MEMENTO_ORIGINATOR_H_
#define BEHAVIOR_MEMENTO_ORIGINATOR_H_
#include "Memento.h"

class Originator {
public:
	Originator();
	virtual ~Originator();
	void setState(int s);
	int getState();
	Memento* createMemento();
	void setMemento(Memento* m);
	void show();
private:
	int state;
};

#endif /* BEHAVIOR_MEMENTO_ORIGINATOR_H_ */
