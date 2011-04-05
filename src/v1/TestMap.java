package v1;

public class TestMap {
	Map testMap;
	
	public static void main(String[] args) {
		Map testMap = new Map(4,7);
		
		Player p = new Player(testMap, 20, 20);
		
		
		System.out.println(testMap);
//		
//		testMap.updateMap('a', p);
//		
//		System.out.println(testMap);
//		System.out.println();
//		testMap.updateMap('s', p);
//		System.out.print(testMap);
//		System.out.println();
//		testMap.updateMap('d', p);
//		System.out.print(testMap);
//		System.out.println();
//		testMap.updateMap('w', p);
//		System.out.print(testMap);
	}
}