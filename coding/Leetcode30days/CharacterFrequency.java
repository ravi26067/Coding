import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CharacterFrequency {
	
	
	class Frequency{
		int frequency;
		char letter;
		public Frequency(int frequency, char letter) {
			super();
			this.frequency = frequency;
			this.letter = letter;
		}
		
		public int getFrequency() {
			return frequency;
		}
		public char getLetter() {
			return letter;
		}
		
		
		
	}

	public String frequencySort(String s) {
		int arr[] = new int[256];
		//store the frequencies in this hash array
		List<Frequency> frq = new ArrayList<>();
		for(int i=0;i<s.length();i++) {
			arr[s.charAt(i)]++;
		}
		
		
		int cnt = 0;
		
		for(int i=0;i<256;i++) {
			if(arr[i]>0) {
				frq.add(new Frequency(arr[i], (char)i));
			}
		}

		Collections.sort(frq,new Comparator<Frequency>() {
			@Override
			public int compare(Frequency left, Frequency right) {	
				return right.getFrequency()-left.getFrequency();
			}});
		
		s="";
		for(Frequency fq:frq) {
			for(int i=0;i<fq.getFrequency();i++)
				s+=fq.getLetter();
		}
		s+="\n";
		return s;
	}

	public static void main(String[] args) {
		CharacterFrequency fc = new CharacterFrequency();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t-->0) {
			String str = sc.nextLine();
			System.out.println(fc.frequencySort(str));
		}
	}
}
