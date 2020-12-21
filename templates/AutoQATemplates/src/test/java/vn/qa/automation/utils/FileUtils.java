package vn.qa.automation.utils;

import java.nio.file.Paths;

public class FileUtils {
	public static String getAbsolutePath(String originalPath) {
		return Paths.get(".").normalize().toAbsolutePath().toString() + originalPath;
	}
}
