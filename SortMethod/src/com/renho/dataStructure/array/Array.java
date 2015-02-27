package com.renho.dataStructure.array;

public class Array {

	private int[] arr;
	private int index;
	
	public Array(int count) {
		this.arr = new int[count];
		this.index = 0;
	}

	public int[] getArr() {
		return arr;
	}

	public int getIndex() {
		return index;
	}
	
	public boolean setArrayByIndex(int index, int value) {
		if(index > arr.length - 1) {
			return false;
		}else {
			arr[index] = value;
			return true;
		}
	}
	
	public int getArrayByIndex(int index) throws Exception {
		if(index > arr.length - 1) {
			throw new Exception("index´íÎó");
		}else {
			int value = arr[index];
			return value;
		}
	}
	
	public Array() {
		//int[] arr = {11, 22, 33, 44, 55, 66, 77, 88, 99};
		int[] arrx = new int[20];
		arrx[0] = 11;
		arrx[0] = 22;
		arrx[0] = 33;
		arrx[0] = 44;
		arrx[0] = 55;
		arrx[0] = 66;
		arrx[0] = 77;
		arrx[0] = 88;
		arrx[0] = 99;
		this.arr = arrx;
		this.index = 0;
	}
	
	public int find(int value) {
		
		int low = 0;
		int hig = this.arr.length - 1;
		int indexs = 0;
		while(this.arr[indexs] != value && low != hig) {
			indexs = (low + hig)/2;
			if(this.arr[indexs] == value) {
				return indexs;
			}else if(this.arr[indexs] > value) {
				hig = indexs - 1;
			}else if(this.arr[indexs] < value) {
				low = indexs + 1;
			}
		}
		
		return -1;
	}
	
	public void orderArray(boolean order) {
		if(order) {//true, ÉýÐò
			
		}else {//false, ½µÐò
			
		}
	}
	
	public void insert(int value) {
		int low = 0;
		int hig = this.arr.length - 1;
		int indexs = 0;
		while(this.arr[indexs] != value && low != hig) {
			indexs = (low + hig)/2;
			if(this.arr[indexs] == value) {
				for(int i=this.arr.length-1; i>=indexs; i++) {
					int temp = this.arr[i];
					this.arr[i] = this.arr[i-1];
					this.arr[i+1] = temp;
				}
				this.index = this.arr.length;
			}else if(this.arr[indexs] > value) {
				hig = indexs - 1;
			}else if(this.arr[indexs] < value) {
				low = indexs + 1;
			}
		}
	}
}
