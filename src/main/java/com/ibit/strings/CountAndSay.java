package com.ibit.strings;


public class CountAndSay {

	private static final boolean debug=false;
	public static void main(String ars[]) {
		for(int i=1;i<=5;i++)System.out.println(countAndSay(i));

	}

	public static String countAndSay(int n) {
		StringBuilder sequence=new StringBuilder();
		if(n==1)
			return sequence.append("11").toString();
		else if(n>1)
		{
			sequence.append("11");
			StringBuilder new_sequence=new StringBuilder();
			int count=0;

			for(int i=2;i<=n;i++) {
				count=1;
				char ch=sequence.toString().charAt(0);
				if(debug)
					System.out.println("ch: "+ch);

				for(int j=1;j<sequence.toString().length();j++) {
					if(ch==sequence.toString().charAt(j)) {
						count++;
						
					}else {
						if(debug) System.out.println("ch: "+ch);
						new_sequence.append(count);
						new_sequence.append(ch);
						ch=sequence.toString().charAt(j);
						count=1;
						if(debug)
						{
							System.out.println("sequence: "+sequence.toString());
							System.out.println("new_sequence: "+new_sequence.toString());
						}
					}
					if(j==sequence.toString().length()-1) {
						new_sequence.append(count);
						new_sequence.append(ch);
					}
					if(debug) {
						System.out.println("ch: "+ch);
						System.out.println("count: "+count);
					}
				}

				//assign the new_sequence to the old sequence and reset the new sequence
				sequence=new_sequence;
				new_sequence=new StringBuilder();
				if(debug) System.out.println("sequence: "+sequence.toString());

			}
		}else {
			//do nothing
		}
		return sequence.toString();
	}
}