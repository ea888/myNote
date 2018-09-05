package interview;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
//    words = ["What","must","be","acknowledgment","shall","be"]
//    maxWidth = 16
//    Output:
//            [
//            "What   must   be",
//            "acknowledgment  ",
//            "shall be        "
//            ]

    int maxWidth = 16;
    public List<String> justify(String[] input){
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int numOfWords = 0;
        boolean flag = true;
        for(int i=0; i< input.length; i++){
            if(flag){
                sb.append(input[i]);
                numOfWords++;
                flag = false;
                continue;
            }

            if((sb.length()+1+input[i].length()) <= this.maxWidth){
                sb.append(" "+input[i]);
                numOfWords++;
            }else{
                sb = justifySpaces(sb, numOfWords);
                res.add(sb.toString());
                sb.setLength(0);
                flag = true;
                numOfWords = 0;
                i--;
            }
        }

        sb = justifySpaces(sb, 1);
        res.add(sb.toString());
        return res;
    }

    public StringBuilder justifySpaces(StringBuilder sb, int numOfWords){

        StringBuilder res = new StringBuilder();


        if(numOfWords == 1){

            res.append(sb);
            String res1 = res.toString().trim();
            for(int i=0; i< this.maxWidth-res1.length(); i++){
                res.append("|");
            }
            return res;
        }


        int spaces = this.maxWidth - sb.length() + numOfWords -1;
        int eachSpace = spaces/(numOfWords-1);
        int plus = 0;
        if(spaces%(numOfWords-1) == 0){
            //do nothing
        }else{
            plus = spaces%(numOfWords-1);
        }

        String[] line = sb.toString().split(" ");
        for(int i=0; i<line.length;i++){
            if(i == 0){
                res.append(line[i]);
                for(int j=0; j<eachSpace+plus;j++){
                    res.append("|");
                }
            }else if(i<line.length-1){
                res.append(line[i]);
                for(int j=0; j<eachSpace;j++){
                    res.append("|");
                }
            }else{
                res.append(line[i]);
            }

        }

        return res;
    }

    public static void main(String[] args) {
        TextJustification tj = new TextJustification();
        List<String> res = tj.justify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"});
        for(String line : res){
            System.out.println(line);
        }
        System.out.println();
        tj.maxWidth = 20;
        res = tj.justify(new String[]{"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"});
        for(String line : res){
            System.out.println(line);
        }
    }

}
