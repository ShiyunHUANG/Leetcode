package easy;
/**
 * Given a non-negative integer num, repeatedly add all its digits 
 * until the result has only one digit. 
 * For example: 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. 
 * Since 2 has only one digit, return it. 
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime? 
 */
public class AddDigits258 {
	public int addDigits(int num) {
		if(num<=9&&num>=-9){
			return num;
		}
		int temp=0;
		int flag=num;
        String strNum=Integer.toString(num);
        System.out.println("strNum "+strNum);
        while(flag>9){
        //for(int k=0;k<2;k++){
        	System.out.println("***loop***");
            for(int i=0;i<strNum.length();i++){
            	temp=temp+Integer.parseInt(String.valueOf(strNum.charAt(i)));
            	System.out.println("strNum.charAt(i) is "+strNum.charAt(i));
            }
            System.out.println("temp is "+temp);
            if(temp>9){
            	strNum=Integer.toString(temp);
            	System.out.println("strNum is "+strNum);
            	flag=temp;
            	System.out.println("flag is "+flag);
    			temp=0;
            }

            else{
                flag=temp;
                System.out.println("flag is "+flag);
            	return temp;//!!!
            }
        }
        return temp;
    }
	public static void main(String[] args) {
		System.out.println(new AddDigits258().addDigits(395993));
	}
}
