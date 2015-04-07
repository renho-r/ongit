#include <iostream>
#include "Caretaker.h"
#include "Memento.h"
#include "Originator.h"

using namespace std;

int main() {
	Originator* originator = new Originator;
	originator->setState(100);
	Memento* memento = originator->createMemento();
	Caretaker* caretaker = new Caretaker;
	caretaker->setMemento(memento);
	originator->show();
	originator->setState(200);
	originator->show();
	originator->setMemento(caretaker->getMemento());
	originator->show();

	delete originator;
	delete memento;
	delete caretaker;

	system("pause");
	return 0;
}
