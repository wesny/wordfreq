import java.util.*;

public class WordFreq{ 

    private Counter[] _strings;

    //***************************************************************************
    //Constructor: Takes an array of Strings and constructs the frequency array
    //***************************************************************************
    public WordFreq(String[] args){
  _strings = countWordFreq(args);
    } 

    //***************************************************************************
    //Creates the array for _strings
    //***************************************************************************
    public Counter[] countWordFreq(String[] args){
	MergeSort.sort(args);  //MergeSorts so similar elements are together
	String currentCheck = args[0]; //The string you are checking
	int currentLength = 0; //The current number of the string
	ArrayList<Counter> x = new ArrayList<Counter>();//Temp holder for freqs
	for (int i = 0; i < args.length; i++){
	    if (!args[i].equals(currentCheck)){ //Whether you change strings
		x.add(new Counter(currentCheck, currentLength)); 
		currentCheck = args[i]; //Starts the next cycle of checks
		currentLength = 1;
	    }
	    else currentLength++;
	}
	x.add(new Counter(currentCheck, currentLength)); //Adds the last Counter
	Counter[] ans = new Counter[x.size()];//Final ans
	for (int j = 0; j < x.size(); j++)  //We need an ArrayList
	     ans[j] = x.get(j);
	MergeSort.sort(ans);//MergeSorts the new data to order it
	reverse(ans); //We want the biggest elements first
	return ans;
    }
    //***************************************************************************
    //Standard reverse function
    //***************************************************************************

    public static void reverse(Counter[] x){
	for (int i = 0; i < x.length/2; i++){
	    Counter temp = x[i];
	    x[i] = x[x.length-1-i];
	    x[x.length-1-i] = temp;
	}
    }

    //***************************************************************************
    //toString in the format: [string:freq, string:freq,...]
    //***************************************************************************
    public String toString(){
	String ans = "[";
	for (Counter temp: _strings)
	    ans+= temp + ", ";
	return ans.substring(0, ans.length()-2) + "]";
    }

    public static void main(String[] args){
	System.out.println(new WordFreq(args));
    }

}
