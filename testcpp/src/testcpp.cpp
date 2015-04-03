//============================================================================
// Name        : testcpp.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
using namespace std;

void sort(int array[], int low, int height) {

	if (low < height) {
		int i = low;
		int j = height;
		int value = array[i];
		while (i < j) {
			while (i < j && array[j] > value) {
				j--;
			}
			array[i] = array[j];
			while (i < j && array[i] < value) {
				i++;
			}
			array[j] = array[i];
		}
		array[i] = value;
		sort(array, low, i);
		sort(array, i + 1, height);
	}

}

int main() {
	int array[] = { 88, 44, 66, 22, 11, 33, 77, 99, 55, 45, 76, 89, 100, 143 };
	sort(array, 0, 14);
	for (int i = 0; i < 14; i++) {
		cout << array[i] << "-";
	}
	return 0;
}
