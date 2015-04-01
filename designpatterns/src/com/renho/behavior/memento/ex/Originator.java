package com.renho.behavior.memento.ex;

public class Originator {
	private String state;

	public Originator() {
	}

	public MementoIF createMemento() {
		return new Memento(this.state);
	}

	// 将发起人恢复到备忘录对象记录的状态
	public void restoreMemento(MementoIF memento) {
		Memento aMemento = (Memento) memento;
		this.setState(aMemento.getState());
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
		System.out.println("state=" + state);
	}

	// 内部成员类，备忘录
	protected class Memento implements MementoIF {
		private String savedState;

		private Memento(String someState) {
			savedState = someState;
		}

		@SuppressWarnings("unused")
		private void setState(String someState) {
			savedState = someState;
		}

		private String getState() {
			return savedState;
		}
	}
}
