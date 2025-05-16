package com.backbase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringPathChanger {

	public String changeDirectoryString(String currentDirectory, String command) {

		StringBuilder result = null;
		try {

			if (Objects.isNull(command) && Objects.nonNull(currentDirectory)) {

				if (command.indexOf("cd ") == -1) {
					throw new IllegalStateException("Command must start with 'cd '");
				}

				// Remove the 'cd ' part of the command
				command = command.substring(3);

				// Split the command into parts
				String[] parts = command.split("/");
				List<String> pathList = new ArrayList(Arrays.asList(currentDirectory.split("/")));

				for (String part : parts) {
					// If part is "..", go up one directory (remove the last element)
					if (part.equals("..")) {
						if (pathList.size() > 1) { // Ensure not to go beyond root
							pathList.remove(pathList.size() - 1);
						}
					} else if (!part.isEmpty() && !part.equals(".")) {
						// If part is not "." or empty, go into the directory (add the element)
						pathList.add(part);
					}
				}

				// Reconstruct the path without trailing slash
				result = new StringBuilder();
				for (String str : pathList) {
					if (!str.isEmpty()) {
						result.append("/").append(str);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	public static void main(String[] args) {
		//System.out.println("Tsting Cd not passed");
		String str = new String("dc ");
		if(Objects.isNull(str)) {
			System.out.println("Objects is null Cd not passed");
		} else {
			System.out.println("Objects Cd passed");
		}
		if(!str.contains("cd")) {
			System.out.println("Cd not passed");
		} else {
			System.out.println("Cd passed");
		}
		/*StringPathChanger changer = new StringPathChanger();
		System.out.println(changer.changeDirectoryString("/dev/task", "cd /")); // Should return "/"
		System.out.println(changer.changeDirectoryString("/dev/task", "cd ..")); // Should return "/dev"
		System.out.println(changer.changeDirectoryString("/dev/task", "cd java")); // Should return "/dev/task/java"
		System.out.println(changer.changeDirectoryString("/dev/task", "cd ../solution")); // Should return
																							// "/dev/solution"
		System.out.println(changer.changeDirectoryString("/dev/task/java", "cd ../..")); // Should return "/dev"
		// Uncomment the line below to test the exception
		 System.out.println(changer.changeDirectoryString("/dev/task/java", "wrong ../..")); // Should throw IllegalStateException
	*/
	}
}
