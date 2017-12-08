package SWESpiel.spiel;



import java.util.Random;

import SWESpiel.spiel.Map;

public class BusinessRules {
	
	public void checkMap1(){ // for KI1
		 	
		//empfant die karte  von MapClass wo der client es definiert
		Map map1 = new Map();  
		String myMap = map1.getMap1();
		
		//1. Karte einer spielers 4x8
		String matrix[][] = new String [4][8]; //String matrix[][] = new String [str1.length][];
		//generiert eine Matrix
		String str1[] = myMap.split("1");
		for (int i = 0; i<4; i++) {
			String str2[] = str1[i].split(",");
			matrix[i] = new String [str2.length];
			for(int j = 0; j< 8; j++) {
				matrix[i][j] = str2[j];
		//		System.out.print(matrix[i][j] + " ");
			}
		//	System.out.println(" ");
		}
		
		//2.prueft ob die karte  nur aus  water, mountain, grass and a castle field gebildet ist.
		int sem =1;		
		for(int i =0;i<4 && sem == 1;i++) {
			for (int j=0;j<8  && sem == 1 ;j++) {
				if(matrix[i][j].charAt(0) == 'w' || matrix[i][j].charAt(0) == 'g' || matrix[i][j].charAt(0) == 'm' || matrix[i][j].charAt(0) == 'C') {
					sem = 1;
				}
				else {
					sem =0;
					
				}
			}
		}
		if(sem ==1) {
			System.out.println("Karte1 fulfills condition of minimum requirements of fields!");
		}
		else {
			throw new RuntimeException("False map!");
		}
		
		
		//3.pruft  ob alle Grenzlinen nicht zu viel Wasser felder hat
		
		//obere Grenzelinie
		 int countWaterTop = 0;
		for(int i =0; i < 1; i++) { 
			for(int j = 0; j< 8; j++) {
				if(matrix[i][j].charAt(0) == 'w') {
					countWaterTop ++;
				}
			}
			if(countWaterTop >3)
				throw new RuntimeException("Karte1: Obere Grenzlinie enthaelt zu viele Wasserfelder");
				
		}
		//linkeGrenzlinie
		int countWaterLeft = 0;
		for(int i=0; i<4;i++) {
			for(int j=0; j<1;j++) {
				if(matrix[i][j].charAt(0) == 'w')
					countWaterLeft++;
			}
			if(countWaterLeft >2)
				throw new RuntimeException("Karte1: Die linke  Grenzlinie enthaelt zu viele Wasserfelder");
		}
		//rechte Grenzlinie
		int countWaterRight = 0; 
		for(int i=0;i<4;i++) {
			for(int j=7;j<8;j++) {
				if(matrix[i][j].charAt(0) == 'w')
					countWaterRight++;
			}
			if(countWaterRight >2)
				throw new RuntimeException("Karte1: Die rechte Grenzlinie enthaelt zu viele Wasserfelder");
		}
		//untere Grenzlinie
		int countWaterBottom = 0;
		for(int i=3;i<4;i++) {
			for(int j =0; j<8;j++) {
				if(matrix[i][j].charAt(0) == 'w') 
					countWaterBottom++;
			}
			if(countWaterBottom >3)
				throw new RuntimeException("Karte1: Die untere Grenzlinie enthaelt zu viele Wasserfelder");
		}
		
		
		
		//4. Prueft ob die Karte die minimale Anzahl von moutain(Berg), water(wasser) , grass Felder enthalt
		int cWater =0, cGrass =0, cMountain = 0;
		for(int i = 0; i< 4; i++) {
			for(int j = 0; j<8; j++) {
				if(matrix[i][j].charAt(0) == 'w')
					cWater++;
				else {
					if(matrix[i][j].charAt(0) == 'g') {
						cGrass ++;
					}
					if(matrix[i][j].charAt(0) == 'm') {
						cMountain ++;
					}
				}
			}
		}
		//System.out.println("Water: " + cWater + ", Grass: " + cGrass + ", Mountain: " + cMountain);
		if(cWater < 4 || cGrass < 5 || cMountain < 3)
			throw new RuntimeException ("Map1:  minimale Anzahl von moutain(Berg), water(wasser) , grass Felder nicht da!");
		
		
		
		//5.checking for islands  TODO!!!!!!!!!!!!
		for(int i = 1; i< 4; i++) {
			for(int j =1; j<8; j++) {
				if((matrix[i][j].charAt(0) == 'g' || matrix[i][j].charAt(0) == 'm')&& matrix[i-1][j].charAt(0) == 'w' && matrix[i][j+1].charAt(0) == 'w' && matrix[i][j-1].charAt(0) == 'w' && matrix[i+1][j+1].charAt(0) == 'w' && matrix[i-1][j-1].charAt(0) == 'w') 
					throw new RuntimeException("Island generated!");
				else { // checking for islands at left border
					for( i= 0; i<4; i++) {
						for(j = 0; j< 2; j++) {
							if(matrix[i][j].charAt(0) == 'w' &&( matrix[i+1][j].charAt(0) == 'g' || matrix[i+1][j].charAt(0) == 'm')&& matrix[i+2][j].charAt(0) == 'w' && matrix[i+1][j+1].charAt(0) == 'w' && matrix[i][j+1].charAt(0) == 'w' && matrix[i+2][j+1].charAt(0) == 'w')
								throw new RuntimeException("Map1: Island generated at left border!");
							else { //checking for islands at right border
								for(i=0; i<4; i++) {
									for(j= 6; j< 8; j++) {
										if(matrix[i][j].charAt(0) == 'w' && matrix[i][j+1].charAt(0) == 'w' && matrix[i+1][j].charAt(0) == 'w'&& (matrix[i+1][j+1].charAt(0) == 'g' || matrix[i+1][j+1].charAt(0)=='m') &&matrix[i+2][j].charAt(0)=='w' && matrix[i+2][j+1].charAt(0)=='w')
											throw new RuntimeException("Map1: Island generated at right border!");
										else { // checking for islands at the top of the map
											for(i=0; i<2;i++){
												for(j=0;j<8;j++){
													if(matrix[i][j].charAt(0) == 'w' && (matrix[i][j+1].charAt(0) == 'g'||matrix[i][j+1].charAt(0) == 'm') && matrix[i][j+2].charAt(0) == 'w' && matrix[i+1][j].charAt(0) == 'w'&&matrix[i+1][j+1].charAt(0) == 'w'&&matrix[i+1][j+2].charAt(0) == 'w')
														throw new RuntimeException("Map1: Island generated at the top of the map!");
													else { // checking for islands at the bottom of the map
														for(i=2;i<4;i++) {
															for(j=0;j<8;j++) {
																if(matrix[i][j].charAt(0) == 'w' && matrix[i][j+1].charAt(0) == 'w' && matrix[i][j+2].charAt(0) == 'w' && matrix[i+1][j].charAt(0) == 'w'&& (matrix[i+1][j+1].charAt(0) == 'g' || matrix[i+1][j+1].charAt(0) == 'm')&&matrix[i+1][j+2].charAt(0) == 'w')
																	throw new RuntimeException("Map1: Island generated at the bottom of the map!");
															}
														}
													}
												}
											}
										}
										
									}
								}
							}
						}
					}
				}
			}
		}
		
	}
	
	public void checkMap2() { // for KI2
		
		//empfangt Karte 2 from MapClass
		Map map2 = new Map();
		String myMap2 = map2.getMap2();
		//System.out.print(myMap2);
		
		//1. half map 4x8
		String matrix[][] = new String [4][8]; 
		// generiert Matrix
		String str1[] = myMap2.split("1");
		for (int i = 0; i< 4; i++) {
		String str2[] = str1[i].split(",");
		matrix[i] = new String [str2.length];
		for(int j = 0; j< 8; j++) {
			matrix[i][j] = str2[j];
		//	System.out.print(matrix[i][j] + " ");
			}
		//	System.out.println(" ");
		}
			
		//2.prueft ob die karte  nur aus  water, mountain, grass and a castle field gebildet ist.
		int sem =1;		
		for(int i =0;i<4 && sem == 1;i++) {
			for (int j=0;j<8  && sem == 1 ;j++) {
				if(matrix[i][j].charAt(0) == 'w' || matrix[i][j].charAt(0) == 'g' || matrix[i][j].charAt(0) == 'm' || matrix[i][j].charAt(0) == 'C') {
					sem = 1;
				}
				else {
					sem =0;
						
				}
			}
		}
		if(sem ==1) {
			System.out.println("Map2 erfuelt conditionen fur minimale Anforderungen  der Felder!");
		}
		else {
			throw new RuntimeException("Karte nicht richtig gebaut!");
		}
		
		//3.pruft  ob alle Grenzlinen nicht zu viel Wasser felder hat
		
		//obere Grenzelinie
		int countWaterTop = 0; int countWaterBottom = 0; int countWaterRight = 0; int countWaterLeft = 0;
		for(int i =0; i < 1; i++) { 
			for(int j = 0; j< 8; j++) {
				if(matrix[i][j].charAt(0) == 'w') {
					countWaterTop ++;
				}
			}
			if(countWaterTop > 3)
				throw new RuntimeException("Karte1: Die  Obere Grenzlinie enthaelt zu viele Wasserfelder");
		}
		//linkeGrenzlinie
		for(int i=0; i<4;i++) {
			for(int j=0; j<1;j++) {
				if(matrix[i][j].charAt(0) == 'w')
					countWaterLeft++;
			}
			if(countWaterLeft >2)
				throw new RuntimeException("Karte1: Die linke  Grenzlinie enthaelt zu viele Wasserfelder");
		}
		//rechte Grenzlinie
		for(int i=0;i<4;i++) {
			for(int j=7;j<8;j++) {
				if(matrix[i][j].charAt(0) == 'w')
					countWaterRight++;
				}
				if(countWaterRight >2)
					throw new RuntimeException("Karte1: Die rechte  Grenzlinie enthaelt zu viele Wasserfelder");
		}
		//untere Grenzlinie
		for(int i=3;i<4;i++) {
			for(int j =0; j<8;j++) {
				if(matrix[i][j].charAt(0) == 'w') 
					countWaterBottom++;
			}
			if(countWaterBottom >3)
				throw new RuntimeException("Karte1: Die untere Grenzlinie enthaelt zu viele Wasserfelder");
		}
		
		//4.checking if map has minimum requirements of mountains, water, grass fields
		int cWater =0, cGrass =0, cMountain = 0;
		for(int i = 0; i< 4; i++) {
			for(int j = 0; j<8; j++) {
				if(matrix[i][j].charAt(0) == 'w')
					cWater++;
				else {
					if(matrix[i][j].charAt(0) == 'g') {
						cGrass ++;
					}
					if(matrix[i][j].charAt(0) == 'm') {
						cMountain ++;
					}
				}
			}
		}
		if(cWater < 4 || cGrass < 5 || cMountain < 3)
			throw new RuntimeException ("Map2: Minimum of water/mountain/grass fields not respected! You lose!");
		
		//5.checking for islands 
		for(int i = 1; i< 4; i++) {
			for(int j =1; j<8; j++) {
				if((matrix[i][j].charAt(0) == 'g' || matrix[i][j].charAt(0) == 'm')&& matrix[i-1][j].charAt(0) == 'w' && matrix[i][j+1].charAt(0) == 'w' && matrix[i][j-1].charAt(0) == 'w' && matrix[i+1][j+1].charAt(0) == 'w' && matrix[i-1][j-1].charAt(0) == 'w') 
					throw new RuntimeException("Map2: Island generated! You lose!");
				else { // checking for islands at left border
					for( i= 0; i<4; i++) {
						for(j = 0; j< 2; j++) {
							if(matrix[i][j].charAt(0) == 'w' &&( matrix[i+1][j].charAt(0) == 'g' || matrix[i+1][j].charAt(0) == 'm')&& matrix[i+2][j].charAt(0) == 'w' && matrix[i+1][j+1].charAt(0) == 'w' && matrix[i][j+1].charAt(0) == 'w' && matrix[i+2][j+1].charAt(0) == 'w')
								throw new RuntimeException("Map2: Island generated at left border! You lose!");
							else { //checking for islands at right border
								for(i=0; i<4; i++) {
									for(j= 6; j< 8; j++) {
										if(matrix[i][j].charAt(0) == 'w' && matrix[i][j+1].charAt(0) == 'w' && matrix[i+1][j].charAt(0) == 'w'&& (matrix[i+1][j+1].charAt(0) == 'g' || matrix[i+1][j+1].charAt(0)=='m') &&matrix[i+2][j].charAt(0)=='w' && matrix[i+2][j+1].charAt(0)=='w')
											throw new RuntimeException("Map2: Island generated at right border! You lose!");
										else { // checking for islands at the top of the map
											for(i=0; i<2;i++){
												for(j=0;j<8;j++){
													if(matrix[i][j].charAt(0) == 'w' && (matrix[i][j+1].charAt(0) == 'g'||matrix[i][j+1].charAt(0) == 'm') && matrix[i][j+2].charAt(0) == 'w' && matrix[i+1][j].charAt(0) == 'w'&&matrix[i+1][j+1].charAt(0) == 'w'&&matrix[i+1][j+2].charAt(0) == 'w')
														throw new RuntimeException("Map2: Island generated at the top of the map!");
													else { // checking for islands at the bottom of the map
														for(i=2;i<4;i++) {
															for(j=0;j<8;j++) {
																if(matrix[i][j].charAt(0) == 'w' && matrix[i][j+1].charAt(0) == 'w' && matrix[i][j+2].charAt(0) == 'w' && matrix[i+1][j].charAt(0) == 'w'&& (matrix[i+1][j+1].charAt(0) == 'g' || matrix[i+1][j+1].charAt(0) == 'm')&&matrix[i+1][j+2].charAt(0) == 'w')
																	throw new RuntimeException("Map2: Island generated at the bottom of the map!");
															}
														}
													}
												}
											}
										}
										
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public void finalMap() {
		
		Map n = new Map();
		String map1 = n.getMap1();
		String map2 = n.getMap2();
		
		//convertiert string 1  in matrix1
		//1. half map 4x8
	
		String matrix[][] = new String [4][8]; 
		
		// wandelt es in  Matrix1 (Map1)
		String str1[] = map1.split("1");
		for (int i = 0; i<4; i++) {
			String str2[] = str1[i].split(",");
			matrix[i] = new String [str2.length];
			for(int j = 0; j< 8; j++) {
				matrix[i][j] = str2[j];
		//		System.out.print(matrix[i][j] + " ");
			}
		//	System.out.println(" ");
		}
		
		//convertiert string2 in matrix2 (Map2)
		
		String matrix2[][] = new String [4][8]; 
		String s1[] = map2.split("1");
		for (int i = 0; i<4; i++) {
			String s2[] = s1[i].split(",");
			matrix2[i] = new String [s2.length];
			for(int j = 0; j< 8; j++) {
				matrix2[i][j] = s2[j];
	//			System.out.print(matrix2[i][j] + " ");
			}
	//		System.out.println(" ");
		}
		
		//reversing linie von matrix1
		
		System.out.println(" ");
		String[][] mapReversed = new String[4][8];
		int k = 4; int l = 7;
		for(int i = 0; i<4; i++) {
			k--;
			l =7;
			for(int j=0;j<8;j++) {
				mapReversed[k][l--] = matrix[i][j];
			}
		}
		
		// volle KArte 8x8
		
//		System.out.println("Final map of players: ");
		String[][] finalMap = new String[8][8];
		int row = -1;
		for(int i=0; i<8;i ++) {
			if(i>=4)
				row++;
			for(int j=0;j<8;j++) { 
				if(i<=3)
					finalMap[i][j] = mapReversed[i][j];
				else
					finalMap[i][j] = matrix2[row][j];
			}
		}
	/*	for(int i=0; i<8;i ++) {
			for(int j=0;j<8;j++) {
				System.out.print(finalMap[i][j] + " ");
			}
			System.out.println();
		}*/
		
		//generierung von Schatz 
		
		Random rand = new Random();
		int treasureKI1 = rand.nextInt(31);
		int treasureKI2 = rand.nextInt(32) +32; //(max-min+1)+min generiert zufaellig Zahl zw. 32 und 63
		
		int line = treasureKI1/(finalMap[0].length);
		int column = treasureKI1%(finalMap[0].length);
		
		int lineKI2 = treasureKI2/finalMap[0].length;
		int columnKI2 = treasureKI2%finalMap[0].length;
		
		System.out.println();
		System.out.println(" Karte mit Schaetze: ");
		
		
		
		//6.treasure and castle not on same field
	
		
		int treasure2KI1; int line2; int column2;
		int treasure2KI2; int line2KI2 = 0; int column2KI2 = 0;
		
		if (finalMap[line][column].charAt(0) == 'g' && finalMap[lineKI2][columnKI2].charAt(0) == 'g') {
			finalMap[line][column] = "T";
			finalMap[line2KI2][column2KI2] = "T";
			
			for(int i = 0; i<8;i++){
				for(int j=0;j<8;j++){
					System.out.print(finalMap[i][j] + " ");
				}
				System.out.println();
			}
		
		}else {
			int check =0;
			while((finalMap[line][column].charAt(0) != 'g' || finalMap[lineKI2][columnKI2].charAt(0) != 'g') && check ==0) {
				
				 treasure2KI1 = rand.nextInt(31);
				 line2 = treasure2KI1/(finalMap[0].length);
				 column2 = treasure2KI1%(finalMap[0].length);
				 
				 treasure2KI2 = rand.nextInt(32) +32;
				line2KI2 = treasure2KI2/finalMap[0].length;
				column2KI2 = treasure2KI2%finalMap[0].length;
				
				if(finalMap[line2][column2].charAt(0) == 'g' && finalMap[line2KI2][column2KI2].charAt(0) == 'g') {
					check =1;
				}
				if(check == 1) {
					
					finalMap[line2][column2] = "T";
					finalMap[line2KI2][column2KI2] = "T";
					for(int i = 0; i<8; i++) {
						for(int j = 0;j <8;j++) {
							System.out.print(finalMap[i][j] + " ");
						}
						System.out.println();
					}
				} 
			}
		}
	}
	
	//7.treasures only on grass fields. This algorithm also fulfills another business rule:
			//TO DO

	
	public static void main(String args[]) {
		

		BusinessRules br = new BusinessRules();
		br.checkMap1();
		br.checkMap2();
		br.finalMap();
		
	}

}
