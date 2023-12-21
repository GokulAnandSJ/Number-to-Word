package edu;
import java.util.Scanner;
import java.util.InputMismatchException;
//import java.util.Scanner;
/*
 * In this code for convert number up to one Crore.
 */
class NumberToWords {

	static void numberToWords(int n,String st) {
		if(n==0)
			return ;  //Hear why return empty means because of every time we entered number It shows the Zero so we can Givens as Empty..

		String []x = {" ","One","Two","Three","Four","Five","six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","SevenTeen","Eighteen","Ninteen"};

		String []y = {" "," ","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninty"};

		if(n<20)
			System.out.print(x[n]+' ');  //Entered Number is less than 20 means First process Can be executed.

		else
			System.out.print(y[n/10]+" "+x[n%10]+" ");  //why here n/10 can be used means upto twenty the all number will be Same So after we can + the words at 10+ so we used this Formula.
		System.out.print(st+" ");
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/**
		 * Why I am using try block hear means if user can enter the value above 9 Digit means
		 *  there will been you can face "InputMismatchException" .
		 *  why means for int can store only 9 digit that has last value of 999999999 user entered 
		 *  above this range you can face Exception.
		 *  so we can use try and catch block for solve the Exception.
		 *  Now user can enter the value above the range means that can be convert as long so we can solve that Exception.
		 * 
		 */
		try {									
			Scanner sc = new Scanner(System.in);    //Taking Input From the User
			System.out.println("Enter the Number");
			int num = sc.nextInt() ;

			if(num==0) {
				System.out.println("Zero");
			}
			else if
			(num<0 || num>999999999) {
				System.err.println("Your number is out of Range");
				return;
			}
			numberToWords(num/10000000,"Crore");       //The user entered number is Eight Digit means value is First Crore,second Thousand,then Hundred,final number.
			numberToWords(num/100000%100,"Lakh");      //Then the Value converted by upto Lakh that can be process of before thousands and Hundred.
			numberToWords(num/1000%100,"Thousand");    //Here the 4 digit value is converted at thousands,Hundred,then number.

			if(num==100 || num==200 || num==300 || num==400 || num==500 || num==600 || num==700 || num==800 || num==900) {
				numberToWords(num/100%10,"Hundred");     //Here the 3 digit value can process of hundred and number.
			}
			else
			numberToWords(num/100%10,"Hundred and");  //Except this number after hundred print and word.
		}
			numberToWords(num%100," ");	
			sc.close();
		}
		catch (InputMismatchException e) {
			System.err.println("Your number is out of Range");
		}
	}
}
