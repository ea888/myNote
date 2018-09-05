package interview;

public class Collatz {
    public static void main(String args[]){
        Collatz c = new Collatz();
        int steps = c.findStep(97);

        System.out.println(steps);

        System.out.println(c.findLongestSteps(100));
        System.out.println(c.step);
    }

    private int count = 0;
    private int step = 0;

    public int findStep(int n){

        if(n==1){
            return count;
        }

        if(n==0){
            return -1;
        }
        count++;

        if(n%2 == 0){
            n=n/2;
        }else{
            n=3*n+1;
        }

        return findStep(n);
    }

    public int findLongestSteps(int range){
        this.step = 0;
        int max = 0;
        for(int i = 1; i<range+1; i++){
            this.count = 0;
            int step = findStep(i);
            if(max < step){
                max = step;
                this.step = i;
            }
            //max = Math.max(max,step);
        }
        return max;
    }

}
