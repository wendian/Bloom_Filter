import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lines
{
	private String here;
	private BufferedReader file;

	public Lines(String loc)
	{
		try
		{
			file = new BufferedReader(new FileReader(loc));
			here = file.readLine();
		}
		catch (IOException e)
		{
			throw new IllegalArgumentException("Couldn't open input file " + loc + "\n");
		}
	}

	public boolean ended()
	{
		return here == null;
	}

	public String nextline()
	{
		try
		{
			String t = here;
			here = file.readLine();
			return t;
		}
		catch (IOException e)
		{
			throw new IllegalStateException("No more lines\n");
		}
	}
}