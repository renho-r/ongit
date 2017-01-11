package commonsio;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Main {

	public static void main(String[] args) throws IOException {
		File srcFile = new File(".classpath");
		File destFile = new File(".classpath_bak");
		FileUtils.copyFile(srcFile, destFile);
	}

}
