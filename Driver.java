public class Driver
{
	public static void main(String [] args)
	{
		//this is customized to let the user enter their own files as input
		if ((args.length == 2) || (args.length == 0))
    	{
			int count = 0, total = 0, m = 12373;
			String next_word = null, firstFile, secondFile;
			BloomFilter bloom = new BloomFilter(m);
			if (args.length == 2)
			{
				firstFile = args[0];
				secondFile = args[1];
			}
			else
			{
				System.out.println("No input file names given, default will be basic.txt and basic.txt");
				firstFile = "basic.txt";
				secondFile = "basic.txt";
			}
			Lines reader = new Lines(firstFile);
			while (!reader.ended())
			{
				next_word = reader.nextline();
				bloom.add(next_word);
				total ++;
			}
			reader = new Lines(secondFile);
			System.out.println("Successfully read " + total + " words from " + firstFile);
			System.out.println("Error words in new (" + secondFile + ") file:\n");
			total = 0;
			while (!reader.ended())
			{
				next_word = reader.nextline();
				if (bloom.isIn(next_word) == false)
				{
					System.out.println(next_word);
					count ++;
				}
				total ++;
			}
			System.out.println(count + " error words out of " + total + " total words.\n");
			System.out.println("This filter has approximately a " + bloom.accuracy() + "% chance for a false positive.");
			System.out.println("It uses a bit array of size " + m + " and 8 hash functions, the resulting probability is far lower than 1/850 = 0.00117647058 = 0.118%");
			//bloom.printall();
		}
		else
		{
			System.out.println("Usage:\n$java Driver <vocabulary> <target>");
		}
	}
}

/*
output of running java Driver
----------------------------------------------

No input file names given, default will be basic.txt and basic.txt
Successfully read 850 words from basic.txt
Error words in new (basic.txt) file:

0 error words out of 850 total words.

This filter has approximately a 0.0010213203220250256% chance for a false positive.
It uses a bit array of size 12373 and 8 hash functions, the resulting probability is far lower than 1/850 = 0.00117647058 = 0.118%

-----------------------------------------------
*/