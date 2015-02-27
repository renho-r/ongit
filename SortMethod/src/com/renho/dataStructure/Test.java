package com.renho.dataStructure;

public class Test {
	public static int[] a = { 10, 32, 1, 9, 5, 7, 12, 0, 4, 3 };

	public static void main(String args[]) {
		int i;
		int Index = a.length;
		System.out.print("排序前: ");
		for (i = 0; i < Index - 1; i++)
			System.out.printf("%3s ", a[i]);
		System.out.println("");
		ShellSort(Index - 1);
		System.out.print("排序后: ");
		for (i = 0; i < Index - 1; i++)
			System.out.printf("%3s ", a[i]);
		System.out.println("");
	}

	public static void ShellSort(int Index) {
		int j, k;
		int Temp;
		boolean Change;
		int DataLength;
		int Pointer;
		DataLength = (int) Index / 2;
		while (DataLength != 0) {
			for (j = DataLength; j < Index; j++) {
				Change = false;
				Temp = a[j];
				Pointer = j - DataLength;
				while (Temp < a[Pointer] && Pointer >= 0 && Pointer <= Index) {
					a[Pointer + DataLength] = a[Pointer];
					Pointer = Pointer - DataLength;
					Change = true;
					if (Pointer < 0 || Pointer > Index)
						break;
				}
				a[Pointer + DataLength] = Temp;
				if (Change) {
					System.out.print("排序中: ");
					for (k = 0; k < Index; k++)
						System.out.printf("%3s ", a[k]);
					System.out.println("");
				}
			}
			DataLength = DataLength / 2;
		}
	}
}
