package edu;

//public class Demo {

	import java.util.Scanner;

	public class NumberToWordConverter {

	    private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	    private static final String[] teens = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	    private static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	    private static final String[] thousands = {"", "Thousand", "Million"};

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter a number (up to 999,999): ");
	        int number = scanner.nextInt();

	        if (number < 0 || number > 999999) {
	            System.out.println("Number out of range. Please enter a number between 0 and 999,999.");
	        } else {
	            String words = convertToWords(number);
	            System.out.println("Number in words: " + words);
	        }

	        scanner.close();
	    }

	    private static String convertToWords(int number) {
	        if (number == 0) {
	            return "Zero";
	        }

	        String result = "";
	        int index = 0;

	        do {
	            int part = number % 1000;
	            if (part != 0) {
	                String partWords = convertThreeDigitsToWords(part);
	                result = partWords + thousands[index] + " " + result;
	            }
	            index++;
	            number /= 1000;
	        } while (number > 0);

	        return result.trim();
	    }

	    private static String convertThreeDigitsToWords(int number) {
	        String result = "";

	        int hundreds = number / 100;
	        int remainder = number % 100;

	        if (hundreds > 0) {
	            result += units[hundreds] + " Hundred ";
	        }

	        if (remainder > 0) {
	            if (remainder < 10) {
	                result += units[remainder] + " ";
	            } else if (remainder < 20) {
	                result += teens[remainder - 10] + " ";
	            } else {
	                int tensDigit = remainder / 10;
	                int unitsDigit = remainder % 10;
	                result += tens[tensDigit] + " " + units[unitsDigit] + " ";
	            }
	        }

	        return result;
	    }
	}


