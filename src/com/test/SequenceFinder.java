/**
 * 
 */
//Jesus
package com.test;

/**
 * @author Haridath Bodapati
 * 
 *
 */
public class SequenceFinder {

	boolean resultArrayIntialized;
	String resultArray[];

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		extracted();
		/*String input = "1 2 3 5 9 a 6 7 8 4 @ -5 -7 -3 -2 -1";
		// String input = "1 2 3 5 9 a 6 7 8 4 10 11 12";
		//String input = "1 2 @ -2 -1";
		SequenceFinder sequenceFinder = new SequenceFinder();
		String[] inputArray = input.split(" ");
		if (null != args || args.length > 2) {
			String[] sequenceNumbers = sequenceFinder.findSequnces(inputArray);
			System.out.println("Sequence numbers are " + sequenceNumbers);

			for (String arr : sequenceNumbers) {
				System.out.print(arr + " ");
				System.out.println();
			}
		}*/
	}

	private static void extracted() {
		String test = new String("how is it possible");
		String[] split = test.split("\\s+");
		//System.out.println("split " + split);
		for(int i = 0; i < split.length; i++) {
			System.out.println("Char is " + split[i]);
		}
		for(String s : split) {
			System.out.println(s);
		}
	}

	private String[] findSequnces(Object inputArray[]) {
		try {
			// int previousNumber = -1;
			StringBuilder sb = new StringBuilder();
			if (inputArray != null && inputArray.length > 1) {
				for (int i = 1; i < inputArray.length; i++) {
					// Boolean flag = Character.isDigit((char) a[i]);
					String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
					if (!(specialCharactersString
							.contains((String) inputArray[i]) || specialCharactersString
							.contains((String) inputArray[i - 1]))) {
						/*if (Character.isDigit(((String) inputArray[i])
								.charAt(0))
								&& Character
										.isDigit(((String) inputArray[i - 1])
												.charAt(0))) {*/

							if (Integer.parseInt((String) inputArray[i]) - 1 == Integer
									.parseInt((String) inputArray[i - 1])) {
								int arrayIndex = 0;

								// int[] array = new int[]{a[i-1],a[i]};
								// int[] array = new int[inputArray.length];
								// System.out.println("array length is "+array.length);
								if (sb.indexOf((String) inputArray[(i - 1)]) == -1) {
									sb.append(inputArray[(i - 1)]);
								}
								sb.append(inputArray[i]);
								// array[arrayIndex] =
								// Integer.parseInt((String)inputArray[i]);
								/*
								 * for(int j=0; j<array.length; j++){
								 * System.out.println("i value is "+array[j]); }
								 */
								if (!resultArrayIntialized) {
									resultArray = new String[inputArray.length - 1];
									resultArrayIntialized = true;
									resultArray[0] = sb.toString();
								} else {
									resultArray[0] = sb.toString();
								}
							}
						//}
					} else {
						continue;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultArray;
	}

}
