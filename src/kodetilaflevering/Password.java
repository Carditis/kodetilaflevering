package kodetilaflevering;

import java.util.Scanner;
public class Password {

	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		//System.out.println("Enter your password: ");
		String s = scan.nextLine();
		int length = s.length();
		int tal = 0;
		int sm�Bogstav = 0;
		int storeBogstav = 0;
		int count = 0;
		char ch;

		if (length >= 7)
		{
			while (count < length)
			{
				ch = s.charAt(count);
				if (Character.isDigit(ch))
				{
					tal = tal + 1;
				}
				if (Character.isLowerCase(ch))
				{
					sm�Bogstav = sm�Bogstav + 1;
				}
				if (Character.isUpperCase(ch))
				{
					storeBogstav = storeBogstav + 1;
				}
				count = count + 1;
			}
		}
		if (length < 7) {
			System.out.println("unacceptable");
		} else {
			if (length >=7 && sm�Bogstav >=1 && storeBogstav >= 1) {
				System.out.println("acceptable");
			} else {
				if (length >=9 && sm�Bogstav >=1 && storeBogstav >= 1) {
					System.out.println("strong");
				}
			}
		}
	}
}
//Der skal fikses s� der kun kommer 1 svar ud!!
//Der kommer ikke svar ud fra Strong... Kun acceptable
//Der skal fikses s� der tages h�jde for ikke alfanumerisk
//Fix input ved kode som: ABCD!#$&