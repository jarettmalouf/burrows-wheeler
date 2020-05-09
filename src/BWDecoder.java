import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class BWDecoder
{
	public static void main(String[] args) throws IOException
	{
		String input="";
		BufferedReader br = new BufferedReader(new FileReader("output2.txt"));
		while (br.ready())
			input += (char) br.read();
		br.close();
		PrintWriter out = new PrintWriter("output3.txt");
		out.flush();
		int l = input.length();
		String[] sorted = new String[l];
		String[] right = new String[l];
		for (int j = 0; j < l; j++)
		{
			right[j] = input.substring(j, j+1);
		}
		for (int i = 0; i < l; i++)
		{
			for (int a = 0; a < l; a++)
			{
				sorted[a] = right[a];
			}
			Arrays.sort(sorted);
			for (int k = 0; k < l; k++)
				right[k] += sorted[k].substring(sorted[k].length()-1,  sorted[k].length());
		}
		for (String str : right)
		{
			if (str.charAt(l-1) ==  '\0')
				out.print(str.substring(0, str.length()-2));
		}
		out.close();
	}
}
