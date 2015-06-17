package com.renho.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonFileUtil {

	@SuppressWarnings("resource")
	public static String getJsonString() {
		BufferedReader br;
		String jsonStr = null;
		try {
			String path = JsonFileUtil.class.getResource("").getPath();
			br = new BufferedReader(new FileReader(new File(path + "json.txt")));
			jsonStr = br.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
}
