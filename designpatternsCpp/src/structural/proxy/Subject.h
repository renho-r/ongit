/*
 * Subject.h
 *
 *  Created on: 2015��4��3��
 *      Author: renho
 */

#ifndef PROXY_SUBJECT_H_
#define PROXY_SUBJECT_H_

class Subject {
public:
	Subject();
	virtual ~Subject();
	virtual void request()=0;
};

#endif /* PROXY_SUBJECT_H_ */
