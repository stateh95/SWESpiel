package SWESpiel.spiel;

public class Map {

	public String getMap1() {
		String map1 = "g,g,g,g,g,w,g,w1w,m,w,g,m,w,m,m1g,m,g,w,g,w,g,g1g,g,g,w,m,m,C,m1";
		return map1;
		
	}
	
	public String getMap2() {
		String map2 = "m,g,m,g,m,m,w,m1g,m,w,g,m,w,m,m1w,w,m,m,g,g,g,m1g,g,g,C,m,m,w,g1";
		return map2;
	} 
	
	public String mergeMap() { 
		
		Map n = new Map();
		String m1 = n.getMap1();
		String m2 = n.getMap2();
		String m3 = m1.substring(0,64) + m2.substring(0,64);
		return m3;
		
	}
	
	public static void main(String[] args) {
		
		
		Map map = new Map();
		String mergeMap = map.mergeMap();
		System.out.println(mergeMap);
		BusinessRules br = new BusinessRules();
		br.checkMap1();
	}

}