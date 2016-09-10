package qunaer.third;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String[] A = {"uauqsesb","uwywfprxptxpmgqwuphqtd","yibhwmzltswkoxmslparsggkakblrghmflnurwmcyrgburmx","ngidwcvnxxcyaeiahagxywwodqpixtkboigxdfqoqjgcwizj","mixlhfnqlunpnbtorov","wdwcqseyoopvuicakehitqdtz","eivqoollveiyuxgwzinihcqrjlfmscfkligkfhmmbp","oicotgbgrzswvbquxqogbpmff","luifkizyznhseoyforvfzopcudkyofpvkrfyrk","ahvyasyoxhrnjbfslmgdyrgfontvufxqq","gjxyfwqmxczwzecdkjwxkcsmjrbevszwfnubyzlshslslfjiqsatsq","wsbslwfrhpjexfmphkbhfwpeflaujhuoztshhiwpfzunx","upmqjvoywvcpbhmmrhqhursosxl","jjjkcxkbvmhzzrz","dkdvqryuufjrosrzl","pzprmccuq","ijiinpcnhuleqxhmpgcvyzgkg","esopsgamiuzyxtyzvcrtwkotiiakrargihlpsx","cmct","jqajtvesmuiaxbcgrakttzbywclanbjvawfzn","jxgdbjob","aub","ejwaihklobckvglgdhhjhomfzlfumkavrmelfmaodd","mqswknxf"};
       String[] keys = {"z","s","h","e","th","b","e","qo"};
       int[] num = containKeyword(A,24,keys,8);
       String sum ="";
       for(int i=0;i<num.length;i++){
    	   if(i!=num.length-1){
    		   sum+=num[i]+",";
    	   }else{
    		   sum+=num[i];
    	   }
       }
       System.out.println("["+sum+"]");
		
	}

	public static int[] containKeyword(String[] A, int n, String[] keys, int m) {
		Set<Integer> set = new HashSet();
		for(int i=0;i<m;i++){
			for(int j =0;j<n;j++){
				if(A[j].indexOf(keys[i])!=-1){
					//System.out.println(j);
					set.add(j);
				}
			}
		}
	    
		Iterator<Integer> iterator = set.iterator();
		int[] num = new int[set.size()];
		int i=0;
		while(iterator.hasNext()){
			num[i]=iterator.next();
			i++;
		}
		Arrays.sort(num);
		if(num.length<=0){
			num = new int[1];
			num[0] = -1;
		}
		return num;
    }
	
}
