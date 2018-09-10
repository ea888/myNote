package note.algorithm;

public class MaxSequence {
    public int maxSeq1(int[] seq){
        int max = seq[0];

        for(int i = 0; i < seq.length; i++){
            int subSeq = 0;
            for(int j = i; j< seq.length ; j++){
                subSeq += seq[j];
                if(max < subSeq){
                    max = subSeq;
                }
            }
        }

        return max;
    }

    public int maxSeq2(int[] seq){
        int max = seq[0];
        int maxHere = seq[0];

        for(int i =1;i<seq.length;i++){
            if(maxHere<=0){
                maxHere = seq[i]; // <=0 due to "consecutive", negative max is a sign of recalculating
            }else{
                maxHere += seq[i]; // >0 can add
            }

            //even if all numbers are negative, will record the biggest one
            if(maxHere > max){
                max = maxHere;//record the max so far
            }
        }


        return max;
    }

    public static void main(String[] args) {

        MaxSequence ms = new MaxSequence();

        int[] seq = {1,-2,-2,3,-7,8,9};
        System.out.println(ms.maxSeq1(seq));
        System.out.println(ms.maxSeq2(seq));
    }
}
