package helper;

public class DT {
	public static double ParseDouble(String strNumber) {
		   if (strNumber != null && strNumber.length() > 0) {
		       try {
		          return Double.parseDouble(strNumber);
		       } catch(Exception e) {
		          return -1;   
		       }
		   }
		   else return 0;
	}
}
