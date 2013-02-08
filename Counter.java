public class Counter implements Comparable{
    
    Object _val;
    int _freq;

    //***************************************************************************
    //Constructor
    //***************************************************************************
    public Counter(Object val, int freq){
  	_val = val;
	_freq = freq;
    }

    //***************************************************************************
    //Compares the freq of an object with standard compareTo rules
    //***************************************************************************
    public int compareTo(Object rhs){
	if (!(rhs instanceof Counter))
	    throw new IllegalArgumentException();
        Counter x = (Counter)rhs;
	if (_freq == x._freq)
	    return 0;
	else if (_freq > x._freq) return 1;
	else return -1;
    }

    public void inc(){
	_freq++;
    }
    
    public void dec(){
	_freq--;
    }

    public String toString(){
	return _val + ":" + _freq;
    }

}
