package com.renho.nio.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class PathTest {

	public static void main(String[] args) {
		Path path = Paths.get("data", "nio-data.txt");
		System.out.println(path);
		
		Path basePath = Paths.get("data");
		Path path0 = basePath.resolve("nio-data.txt");
		System.out.println(path0.toString());
		Path path1 = basePath.resolve("nio-data0.txt");
		System.out.println(path1.toString());
		
		BasicFileAttributes attr = null;
		try {
		    attr = Files.readAttributes(path, BasicFileAttributes.class);
		} catch (IOException e) {
		    System.err.println(e);
		}
		System.out.println("File size: " + attr.size());
		System.out.println("File creation time: " + attr.creationTime());
		System.out.println("File was last accessed at: " + attr.lastAccessTime());
		System.out.println("File was last modified at: " + attr.lastModifiedTime());
		System.out.println("Is directory? " + attr.isDirectory());
		System.out.println("Is regular file? " + attr.isRegularFile());
		System.out.println("Is symbolic link? " + attr.isSymbolicLink());
		System.out.println("Is other? " + attr.isOther());

	}

}
