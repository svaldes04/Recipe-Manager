package part02;

import java.util.ArrayList;

import part01.FoodGroup;
import part01.Helper;
import part01.IdedAndNamed;
import part01.Ingredient;
import part01.WeeklyMenu;

public class TestHelper {

	public static ArrayList<IdedAndNamed> list = new ArrayList<IdedAndNamed>();
	public static Ingredient ingr1;
	public static Ingredient ingr2;
	public static Ingredient ingr3;
	public static Ingredient ingr4;
	public static Ingredient ingr5;
	public static Ingredient ingr6;
	public static Ingredient ingr7;
	
	
	public static void main(String[] args) {
		try {
			ingr1 = new Ingredient("Bread", FoodGroup.CEREAL, 265);
			ingr2 = new Ingredient("Cheese", FoodGroup.DAIRY, 402);
			ingr3 = new Ingredient("Minced beef", FoodGroup.PROTEIN, 332);
			ingr4 = new Ingredient("Mayonnaise", FoodGroup.OTHER, 200);
			ingr5 = new Ingredient("Banana", FoodGroup.FRUIT_AND_VEG, 89);
			ingr6 = new Ingredient("Water", FoodGroup.ESSENTIAL_NUTRIENT, 0);
			ingr7 = new Ingredient("Grapes", FoodGroup.FRUIT_AND_VEG, 67);
		}catch(Exception e) {
			System.out.println("There was a problem while creating pre-existing testing values");
			ingr1 = null;
			ingr2 = null;
			ingr3 = null;
			ingr4 = null;
			ingr5 = null;
			ingr6 = null;
			ingr7 = null;
		}
		
		// Tests
		test55();
		test56();
		test57();
		test58();
		test59();
		test60();
		test61();
		test62();
		test63();
		test64();
		test65();
		test66();
		test67();
		test68();
		
	
	}
	
	/**
	 * Aids in printing elements of an ArrayList of IdedAndNamed
	 * @param list
	 */
	private static void printElems(ArrayList<IdedAndNamed> list) {
		for(int i=0; i<list.size();i++) { 
			System.out.print(list.get(i).getId()+ ". "+list.get(i).getName()+"   ");
			}
	}
	
	/**
	 * Aids in printing elements of an ArrayList of Ingredient
	 * @param list
	 */
	private static void printElemsIngr(ArrayList<Ingredient> list) {
		for(int i=0; i<list.size();i++) { 
			System.out.print(list.get(i).getId()+ ". "+list.get(i).getName()+ ", "+list.get(i).getFoodGroup()+"      ");
			}
	}
	
	private static void test55() {
		list.clear();
		System.out.println("=========== TEST 55 ============");
		System.out.println("Testing sortById method with an already sorted list");
		
		list.add(ingr1);
		list.add(ingr2);
		list.add(ingr3);
		list.add(ingr4);
		list.add(ingr5);
		list.add(ingr6);
		list.add(ingr7);
		
		System.out.println("Before: ");
		printElems(list);
		ArrayList<IdedAndNamed> temp = Helper.sortById(list); 
		System.out.println("\nAfter: ");
		printElems(temp);
		boolean sorted = true;
		for(int i=0;i<temp.size()-1;i++) {
			if(temp.get(i).getId() > temp.get(i+1).getId()) {
				sorted = false;
			}
		}
		if(sorted) {
			System.out.println("\nTest passed");
		} else {
			System.out.println("\nTest failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test56() {
		list.clear();
		System.out.println("=========== TEST 56 ============");
		System.out.println("Testing sortById method with an unsorted list");
		
		list.add(ingr2);
		list.add(ingr1);
		list.add(ingr3);
		list.add(ingr5);
		list.add(ingr7);
		list.add(ingr6);
		list.add(ingr4);
		
		System.out.println("Before: ");
		printElems(list);
		ArrayList<IdedAndNamed> temp = Helper.sortById(list); 
		System.out.println("\nAfter: ");
		printElems(temp);
		boolean sorted = true;
		for(int i=0;i<temp.size()-1;i++) {
			if(temp.get(i).getId() > temp.get(i+1).getId()) {
				sorted = false;
			}
		}
		if(sorted) {
			System.out.println("\nTest passed");
		} else {
			System.out.println("\nTest failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test57() {
		list.clear();
		System.out.println("=========== TEST 57 ============");
		System.out.println("Testing sortByName method with an already sorted list ");
		
		list.add(ingr5);
		list.add(ingr1);
		list.add(ingr2);
		list.add(ingr7);
		list.add(ingr4);
		list.add(ingr3);
		list.add(ingr6);
		
		System.out.println("Before: ");
		printElems(list);
		ArrayList<IdedAndNamed> temp = Helper.sortByName(list); 
		System.out.println("\nAfter: ");
		printElems(temp);
		boolean sorted = true;
		for(int i=0;i<temp.size()-1;i++) {
			if(temp.get(i).getName().compareTo(temp.get(i+1).getName()) > 0) {
				sorted = false;
			}
		}
		if(sorted) {
			System.out.println("\nTest passed");
		} else {
			System.out.println("\nTest failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test58() {
		list.clear();
		System.out.println("=========== TEST 58 ============");
		System.out.println("Testing sortByName method with an unsorted list ");
		
		list.add(ingr1);
		list.add(ingr2);
		list.add(ingr3);
		list.add(ingr4);
		list.add(ingr5);
		list.add(ingr6);
		list.add(ingr7);
		
		System.out.println("Before: ");
		printElems(list);
		ArrayList<IdedAndNamed> temp = Helper.sortByName(list); 
		System.out.println("\nAfter: ");
		printElems(temp);
		boolean sorted = true;
		for(int i=0;i<temp.size()-1;i++) {
			if(temp.get(i).getName().compareTo(temp.get(i+1).getName()) > 0) {
				sorted = false;
			}
		}
		if(sorted) {
			System.out.println("\nTest passed");
		} else {
			System.out.println("\nTest failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test59(){
		ArrayList<Ingredient> ingrs = new ArrayList<Ingredient>();
		System.out.println("=========== TEST 59 ============");
		System.out.println("Testing sortByFoodGroup method with an already sorted list ");
		
		ingrs.add(ingr1);
		ingrs.add(ingr2);
		ingrs.add(ingr6);
		ingrs.add(ingr7);
		ingrs.add(ingr5);
		ingrs.add(ingr4);
		ingrs.add(ingr3);
		
		System.out.println("Before: ");
		printElemsIngr(ingrs);
		ArrayList<Ingredient> temp = Helper.sortByFoodGroup(ingrs); 
		System.out.println("\nAfter: ");
		printElemsIngr(temp);
		boolean sorted = true;
		for(int i=0;i<temp.size()-1;i++) {
			if(temp.get(i).getFoodGroup().toString().compareTo(temp.get(i+1).getFoodGroup().toString()) > 0) {
				sorted = false;
			}
		}
		if(sorted) {
			System.out.println("\nTest passed");
		} else {
			System.out.println("\nTest failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test60(){
		ArrayList<Ingredient> ingrs = new ArrayList<Ingredient>();
		System.out.println("=========== TEST 60 ============");
		System.out.println("Testing sortByFoodGroup method with an unsorted list ");
		
		ingrs.add(ingr1);
		ingrs.add(ingr2);
		ingrs.add(ingr3);
		ingrs.add(ingr4);
		ingrs.add(ingr5);
		ingrs.add(ingr6);
		ingrs.add(ingr7);
		
		System.out.println("Before: ");
		printElemsIngr(ingrs);
		ArrayList<Ingredient> temp = Helper.sortByFoodGroup(ingrs); 
		System.out.println("\nAfter: ");
		printElemsIngr(temp);
		boolean sorted = true;
		for(int i=0;i<temp.size()-1;i++) {
			if(temp.get(i).getFoodGroup().toString().compareTo(temp.get(i+1).getFoodGroup().toString()) > 0) {
				sorted = false;
			}
		}
		if(sorted) {
			System.out.println("\nTest passed");
		} else {
			System.out.println("\nTest failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test61() {
		list.clear();
		System.out.println("=========== TEST 61 ============");
		System.out.println("Testing searchById method, id in the list");
		
		list.add(ingr1);
		list.add(ingr2);
		list.add(ingr3);
		list.add(ingr4);
		list.add(ingr5);
		list.add(ingr6);
		list.add(ingr7);
		list = Helper.sortById(list); 
		
		System.out.println("List: ");
		printElems(list);
		int result = Helper.searchById(list, 3);
		System.out.println("\nIndex where id 3 was found: "+ result);
		
		if(result == 2) {
			System.out.println("\nTest passed");
		} else {
			System.out.println("\nTest failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	private static void test62() {
		list.clear();
		System.out.println("=========== TEST 62 ============");
		System.out.println("Testing searchById method, id not in the list");
		
		list.add(ingr1);
		list.add(ingr2);
		list.add(ingr4);
		list.add(ingr5);
		list.add(ingr6);
		list.add(ingr7);
		list = Helper.sortById(list); 
		
		System.out.println("List: ");
		printElems(list);
		int result = Helper.searchById(list, 3);
		System.out.println("\nIndex where id 3 was found: "+ result);
		
		if(result == -1) {
			System.out.println("\nTest passed");
		} else {
			System.out.println("\nTest failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test63() {
		list.clear();
		System.out.println("=========== TEST 63 ============");
		System.out.println("Testing searchByName method, name in the list");
		
		list.add(ingr1);
		list.add(ingr2);
		list.add(ingr3);
		list.add(ingr4);
		list.add(ingr5);
		list.add(ingr6);
		list.add(ingr7);
		list = Helper.sortByName(list); 
		
		System.out.println("List: ");
		printElems(list);
		ArrayList<Integer> result = Helper.searchByName(list, "Water");
		System.out.println("\nIndexes where name 'Water' was found: "+ result);
		
		if(result.size() == 2 && list.get(result.get(0)).getName().compareTo("Water") == 0 
				&& list.get(result.get(1)).getName().compareTo("Water") == 0 ) {
			System.out.println("\nTest passed");
		} else {
			System.out.println("\nTest failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test64() {
		list.clear();
		System.out.println("=========== TEST 64 ============");
		System.out.println("Testing searchByName method, name not in the list");
		
		list.add(ingr1);
		list.add(ingr2);
		list.add(ingr4);
		list.add(ingr3);
		list.add(ingr5);
		list.add(ingr3);
		list.add(ingr7);
		list = Helper.sortByName(list); 
		
		System.out.println("List: ");
		printElems(list);
		ArrayList<Integer> result = Helper.searchByName(list, "Water");
		System.out.println("\nIndexes where name 'Water 'was found: "+ result);
		
		if(result.size() == 0) {
			System.out.println("\nTest passed");
		} else {
			System.out.println("\nTest failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test65() {
		ArrayList<Ingredient> ingrs = new ArrayList<Ingredient>();
		System.out.println("=========== TEST 65 ============");
		System.out.println("Testing searchByFoodGroup method, FoodGroup in the list");
		
		ingrs.add(ingr1);
		ingrs.add(ingr2);
		ingrs.add(ingr4);
		ingrs.add(ingr3);
		ingrs.add(ingr5);
		ingrs.add(ingr3);
		ingrs.add(ingr7);
		ingrs = Helper.sortByFoodGroup(ingrs); 
		
		System.out.println("List: ");
		printElemsIngr(ingrs);
		ArrayList<Integer> result = Helper.searchByFoodGroup(ingrs, FoodGroup.FRUIT_AND_VEG);
		System.out.println("\nIndexes where foodGroup 'Fruit & Veg' was found: "+ result);
		
		if(result.size() == 2 && ingrs.get(result.get(0)).getFoodGroup().toString().compareTo("Fruit & Veg") == 0 
				&& ingrs.get(result.get(1)).getFoodGroup().toString().compareTo("Fruit & Veg") == 0  ) {
			System.out.println("\nTest passed");
		} else {
			System.out.println("\nTest failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test66() {
		ArrayList<Ingredient> ingrs = new ArrayList<Ingredient>();
		System.out.println("=========== TEST 66 ============");
		System.out.println("Testing searchByFoodGroup method, FoodGroup not in the list");
		
		ingrs.add(ingr1);
		ingrs.add(ingr2);
		ingrs.add(ingr4);
		ingrs.add(ingr3);
		ingrs.add(ingr5);
		ingrs.add(ingr3);
		ingrs.add(ingr7);
		ingrs = Helper.sortByFoodGroup(ingrs); 
		
		System.out.println("List: ");
		printElemsIngr(ingrs);
		ArrayList<Integer> result = Helper.searchByFoodGroup(ingrs, FoodGroup.SPICE_AND_HERB);
		System.out.println("\nIndexes where foodGroup 'Spice & Herb' was found: "+ result);
		
		if(result.size() == 0) {
			System.out.println("\nTest passed");
		} else {
			System.out.println("\nTest failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test67() {
		list.clear();
		System.out.println("=========== TEST 67 ============");
		System.out.println("Testing searchByPartName method, part-name in the list");
		
		list.add(ingr1);
		list.add(ingr2);
		list.add(ingr3);
		list.add(ingr4);
		list.add(ingr5);
		list.add(ingr6);
		list.add(ingr7);
		list = Helper.sortByName(list); 
		
		System.out.println("List: ");
		printElems(list);
		ArrayList<Integer> result = Helper.searchByPartName(list, "B");
		System.out.println("\nIndexes where name contains part-name 'B' was found: "+ result);
		
		if(result.size() == 3 && list.get(result.get(0)).getName().toLowerCase().indexOf("B".toLowerCase()) >= 0 
				&& list.get(result.get(1)).getName().toLowerCase().indexOf("B".toLowerCase()) >= 0
				&& list.get(result.get(2)).getName().toLowerCase().indexOf("B".toLowerCase()) >= 0) {
			System.out.println("\nTest passed");
		} else {
			System.out.println("\nTest failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test68() {
		list.clear();
		System.out.println("=========== TEST 68 ============");
		System.out.println("Testing searchByPartName method, part-name not in the list");
		
		list.add(ingr2);
		list.add(ingr2);
		list.add(ingr2);
		list.add(ingr4);
		list.add(ingr2);
		list.add(ingr6);
		list.add(ingr7);
		list = Helper.sortByName(list); 
		
		System.out.println("List: ");
		printElems(list);
		ArrayList<Integer> result = Helper.searchByPartName(list, "B");
		System.out.println("\nIndexes where name contains part-name 'B' was found: "+ result);
		
		if(result.size() == 0) {
			System.out.println("\nTest passed");
		} else {
			System.out.println("\nTest failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
}
