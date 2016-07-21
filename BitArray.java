public class BitArray
{
	private int[] a;
	private int size_of_a;
	private int m;
	public BitArray(int M)
	{
		if (M < 0)
		{
			throw new IllegalArgumentException("M cannot be negative");
		}
		size_of_a = M / 32;
		if (M % 32 != 0) size_of_a++;
		a = new int[size_of_a];
		for (int i = 0; i < size_of_a; i++)
		{
			a[i] = 0;
		}
		m = M;
	}
	public boolean get(int n)
	{
		if (n < 0 || n >= m)
		{
			System.out.println("n:  " + n);
			throw new IndexOutOfBoundsException("n must be between 0 and M to get");
		}
		int aa = a[n / 32];
		int bb = 1 << (n % 32);
		return (aa & bb) != 0;
	}
	public void set(int n)
	{
		if (n < 0 || n >= m)
		{
			System.out.println("n:  " + n);
			throw new IndexOutOfBoundsException("n must be between 0 and M to set");
		}
		int aa = a[n / 32];
		int bb = 1 << (n % 32);
		a[n / 32] = aa | bb;
		return;
	}
	//This method prints the bit array, used for debugging when you need to check how sparse the hash codes are
	public void print_all()
	{
		for (int i = 0; i < size_of_a; i++)
		{
			System.out.println(Integer.toBinaryString(a[i]));
		}
	}
}