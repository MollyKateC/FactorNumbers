package FactorNumbers;

import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

public class Factor100Numbers {

	public static void main(String[] args) throws Exception{
		Factor100Numbers factorRandomNumbers = new Factor100Numbers();
		HashMap<Integer,ArrayList<Long>> factors = factorRandomNumbers.factor100RandomNumbers();
		for(int i = 0; i < factors.size(); i++){
		    System.out.print(factors.get(i).get(0) + ": ");
		    for(int x = 1; x < factors.get(i).size(); x++){
			System.out.print(factors.get(i).get(x) + ", ");
		    }
		    System.out.println("");
		}
	}
	    
	private ArrayList<Long> factorNumbers(long number){
		ArrayList<Long> factors = new ArrayList<Long>();

		long half = number/2 + 1;
		for(long i = 2; i < half; i++){
		    if(number % i == 0){
			factors.add(i);
		    }
		}
		return factors;
	}
	    
	private ArrayList<Integer> generate100RandomNumbers(){
		Random random =new Random();
	    ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
	    for(int i = 0; i < 100; i ++){
		    randomNumbers.add(random.nextInt(1000000));     
		}
		return randomNumbers;
	}

    public HashMap<Integer,ArrayList<Long>> factor100RandomNumbers(){
    	ArrayList<Integer> listNums = this.generate100RandomNumbers();
		HashMap<Integer,ArrayList<Long>> factorsMap = new HashMap<Integer,ArrayList<Long>>();
		
		for(int i = 0; i < listNums.size(); i++){
		    long x = listNums.get(i);
		    ArrayList<Long> factorList = factorNumbers(x);
		    factorList.add(0, x);
		    factorsMap.put(i, factorList);
		}
		return factorsMap;
	}
}

