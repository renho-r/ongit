/*
 * Subject.h
 *
 *  Created on: 2015Äê4ÔÂ3ÈÕ
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
