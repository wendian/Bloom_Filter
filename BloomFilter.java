public class BloomFilter
{
	BitArray b;
	int m;
	public BloomFilter(int M)
	{
		if (M < 0)
		{
			throw new IllegalArgumentException("M cannot be negative");
		}
		b = new BitArray(M);
		m = M;
	}
	private int h1(String w)
	{
		return Math.abs(w.hashCode() % m);
	}
	private int h2(String w)
	{
		int val = 0;
		for (int i = 0; i < w.length(); i++)
		{
			val = val + w.charAt(i) << (i + 1);
			val *= val + 991;
		}
		return Math.abs(val) % m;
	}
	private int h3(String w)
	{
		int val = 0;
	    for (int i = 0; i < w.length(); i++)
	    {
	      val = (val << 1) ^ w.charAt(i);
	      val *= val;
	    }
	    return Math.abs(val) % m;
	}
	private int h4(String w)
	{
		int val = 0;
	    for (int i = 0; i < w.length(); i++)
	    {
	      val = 103 * val + w.charAt(i);
	      val *= val + 997;
	    }
	    return Math.abs(val) % m;
	}
	private int h5(String w)
	{
	    int val = 0;
	    for (int i = 0; i < w.length(); i++)
	    {
	    	val = val << 1;
	        val += 7 * w.charAt(i) * i;
	        val *= val + 39;
	    }
	    return Math.abs(val) % m;
	}
	private int h6(String w)
	{
		int val = 0;
		for (int i = 0; i < w.length(); i++)
	    {
	    	val *= w.charAt(i);
	    	val -= w.charAt(i);
	      val *= i;
	    	val += i;
	    }
	    return Math.abs(val) % m;
	}
	private int h7(String w)
	{
		int val = 0;
		for (int i = 1; i < w.length(); i++)
	    {
	    	val *= w.charAt(i);
	    	val -= w.charAt(i);
	      val /= i;
	      val *= val;
	    }
			val *= w.charAt(0);
	    return Math.abs(val) % m;
	}
	private int h8(String w)
	{
		int val = 0;
		for (int i = 0; i < w.length(); i++)
	    {
	    	val *= 37;
	    	val += w.charAt(i);
	    }
			val *= w.charAt(0);
			val -= w.length();
	    return Math.abs(val) % m;
	}
	public void add(String w)
	{
		b.set(h1(w));
		b.set(h2(w));
		b.set(h3(w));
		b.set(h4(w));
		b.set(h5(w));
		b.set(h6(w));
		b.set(h7(w));
		b.set(h8(w));
		return;
	}
	public boolean isIn(String w)
	{
		return b.get(h1(w)) && b.get(h2(w)) && b.get(h3(w)) && b.get(h4(w)) && b.get(h5(w)) && b.get(h6(w)) && b.get(h7(w)) && b.get(h8(w));
	}
	public double accuracy()
	{
		double x = -8;
		x *= 850;
		x /= m;
		double e = 2.718281828;
		e = Math.pow(e, x);
		e = 1 - e;
		return Math.pow(e, 8);
	}
	//Used to invoke the method in BitArray, for debugging purposes
	public void printall()
	{
		b.print_all();
	}
}