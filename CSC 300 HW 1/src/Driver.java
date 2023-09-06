import java.util.Random;


public class Driver {
	public static void main(String Args[]) {
		
		Salesman[] s = createMen(100,100);
		results(getTopFive(s));
	}
	
	
	static Salesman[] createMen(int num, int randRange) {
		Salesman[] men = new Salesman[num];
		
		for(int i = 0; i < num; i++) {
			Random r =  new Random();
    		int x = r.nextInt(randRange);
			men[i] = new Salesman("Salesman " + Integer.toString(i), x);
		}
		
		return men;
	}
	
	static Salesman[] getTopFive(Salesman[] allSales){

		Salesman[] topFive = createMen(5,1);
		
		for(int i = 0; i < allSales.length; i++) {
			for(int j = 0; j < topFive.length; j++) {
				if(allSales[i].getSales() > topFive[j].getSales()) {
					
					topFive = adjust(j,topFive);
					topFive[j] = allSales[i];
					break;
				}
			}
		}
		
		return topFive;

	}
	
	static Salesman[] adjust(int index, Salesman[] s) {
		
		for(int i = s.length - 1; i > index; i--) {
			s[i] = s[i-1];
		}
		return s;
	}

	static void results(Salesman[] s) {
		
		for(int i = 0; i < s.length; i++) {
			System.out.println(s[i].getName() + ": " + s[i].getSales());
		}
	}
}
