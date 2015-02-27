package com.renho.behavior.observer;

public class ObserverTwo implements IObserver{

private SubjectOne isubject;
	
	public ObserverTwo(SubjectOne isubject) {
		this.isubject = isubject;
	}
	
	@Override
	public void update() {
		System.out.println("ObserverTwo update Ok" + isubject.sta);
	}

}
