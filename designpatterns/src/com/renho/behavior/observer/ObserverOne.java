package com.renho.behavior.observer;

public class ObserverOne implements IObserver {

	private SubjectOne isubject;
	
	public ObserverOne(SubjectOne isubject) {
		this.isubject = isubject;
	}
	
	@Override
	public void update() {
		System.out.println("IObserver Update Ok" + isubject.sta);
	}

}
