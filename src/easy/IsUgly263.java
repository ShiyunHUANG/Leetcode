package easy;

public class IsUgly263 {
    public boolean isUgly(int num) {
        if(num==1)return true;
        if(num<=0)return false;
        while(num%2==0)num=num/2;
        while(num%3==0)num=num/3;
        while(num%5==0)num=num/5;
        return num==1;
   
        /**
         * Below is my first method, out of time limit
         */
/*        if(num==1)return true;
        if(num<0)return false;
        int factors[]=new int[]{2,3,5};
        int remain=num;
        int idx=0;
        boolean b[]=new boolean[]{num%2==0,num%3==0,num%5==0};
        if(!b[0]||!b[1]||!b[2])return false;
        int countT=0;
        for(int i=0;i<b.length;i++){
            if(b[i])countT++;
        }
        if(countT==1){
            for(idx=0;idx<b.length;idx++){
                if(b[idx]==true)break;
            }
            while(remain>factors[idx]){
                if(remain%factors[idx]!=0)return false;
                else num=num/factors[idx];
            }
            return true;
        }
        if(countT==2){
            int[] dividers=new int[2];
            for(idx=0;idx<b.length;idx++){
                if(b[idx]==true)dividers[idx]=factors[idx];
            }
            while(remain%dividers[0]==0){
                num=num/dividers[0];
            }
            while(remain>dividers[1]){
                if(remain%dividers[1]!=0)return false;
                else num=num/dividers[1];
            }
            return true;
        }
        if(countT==3){
            while(remain%factors[0]==0){
                num=num/factors[0];
            }
            while(remain%factors[1]==0){
                num=num/factors[1];
            }
            while(remain>factors[2]){
                if(remain%factors[2]!=0)return false;
                else num=num/factors[2];
            }
            return true;
        }
        return false;*/
    }
    public static void main(String[] args) {

    }

}
