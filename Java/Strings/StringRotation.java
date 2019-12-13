public class StringRotation {
	
	public static boolean isRotation(String str1,String str2) {
		
		System.out.println("Str1 : "+str1);
		System.out.println("Str2 : "+str2);
		if((str1+str1).contains(str2) && str1.length()==str2.length())
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		String s1 = "Apple";
		String s2 = "leAp";
		System.out.println("String rotation " + (isRotation(s1, s2) ? "is Present" : "is Not Present"));
	}

}
