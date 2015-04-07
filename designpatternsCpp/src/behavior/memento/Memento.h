/*
 * Memento.h
 *
 *  Created on: 2015Äê4ÔÂ7ÈÕ
 *      Author: renho
 */

#ifndef BEHAVIOR_MEMENTO_MEMENTO_H_
#define BEHAVIOR_MEMENTO_MEMENTO_H_

class Memento {
public:
	Memento();
	Memento(int s);
	virtual ~Memento();
	int getState();
	void setState(int s);
private:
	int state;
};

#endif /* BEHAVIOR_MEMENTO_MEMENTO_H_ */
