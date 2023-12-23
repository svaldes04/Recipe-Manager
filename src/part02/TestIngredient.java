package part02;

import part01.FoodGroup;
import part01.Ingredient;

public class TestIngredient {

	public static void main(String[] args) {
		// Test 1
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
		test9();
		test10();
		test11();
		test12();
		test13();
		test14();
		test15();
		test16();
		test17();
		test18();
		
	}
	
	private static void test1(){
		Ingredient ingr1 = null;
		System.out.println("=========== TEST 1 ============");
		System.out.println("Testing ingredient constructor with valid arguments");
		System.out.println("Before: "+ingr1);
		try {
			ingr1 = new Ingredient("Cheese", FoodGroup.DAIRY, 70);
		}catch(Exception e) {

		}
		System.out.println("After: "+ingr1);
		if(ingr1 != null) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test2(){
		Ingredient ingr1 = null;
		System.out.println("=========== TEST 2 ============");
		System.out.println("Testing ingredient constructor with empty string");
		System.out.println("Before: "+ingr1);
		try {
			ingr1 = new Ingredient("", FoodGroup.DAIRY, 70);
		}catch(Exception e) {

		}
		System.out.println("After: "+ingr1);
		if(ingr1 != null) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test3(){
		Ingredient ingr1 = null;
		System.out.println("=========== TEST 3 ============");
		System.out.println("Testing ingredient constructor with empty space string");
		System.out.println("Before: "+ingr1);
		try {
			ingr1 = new Ingredient("       ", FoodGroup.DAIRY, 70);
		}catch(Exception e) {

		}
		System.out.println("After: "+ingr1);
		if(ingr1 != null) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test4(){
		Ingredient ingr1 = null;
		System.out.println("=========== TEST 4 ============");
		System.out.println("Testing ingredient constructor with null string");
		System.out.println("Before: "+ingr1);
		try {
			ingr1 = new Ingredient(null, FoodGroup.DAIRY, 70);
		}catch(Exception e) {

		}
		System.out.println("After: "+ingr1);
		if(ingr1 != null) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test5(){
		Ingredient ingr1 = null;
		System.out.println("=========== TEST 5 ============");
		System.out.println("Testing ingredient constructor with null foodGroup");
		System.out.println("Before: "+ingr1);
		try {
			ingr1 = new Ingredient("Cheese", null, 70);
		}catch(Exception e) {

		}
		System.out.println("After: "+ingr1);
		if(ingr1 != null) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test6(){
		Ingredient ingr1 = null;
		System.out.println("=========== TEST 6 ============");
		System.out.println("Testing ingredient constructor with 0 calories");
		System.out.println("Before: "+ingr1);
		try {
			ingr1 = new Ingredient("Cheese", FoodGroup.DAIRY, 0);
		}catch(Exception e) {

		}
		System.out.println("After: "+ingr1);
		if(ingr1 != null) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test7(){
		Ingredient ingr1 = null;
		System.out.println("=========== TEST 7 ============");
		System.out.println("Testing ingredient constructor with negative value for calories");
		System.out.println("Before: "+ingr1);
		try {
			ingr1 = new Ingredient("Cheese", FoodGroup.DAIRY, -1);
		}catch(Exception e) {

		}
		System.out.println("After: "+ingr1);
		if(ingr1 != null) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test8(){
		Ingredient ingr1 = null;
		String name = "Milk";
		System.out.println("=========== TEST 8 ============");
		System.out.println("Testing name mutator method with a string");
		try {
			ingr1 = new Ingredient("Cheese", FoodGroup.DAIRY, 70);
		}catch(Exception e) {

		}
		System.out.println("Before: "+ingr1.getName());
		ingr1.setName(name);
		System.out.println("After: "+ingr1.getName());
		if(ingr1.getName().compareTo(name) == 0) {
			System.out.println("Test Passed");
		} else if(ingr1.getName().compareTo("Cheese") == 0){
			System.out.println("Test Failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test9(){
		Ingredient ingr1 = null;
		String name = "";
		System.out.println("=========== TEST 9 ============");
		System.out.println("Testing name mutator method with an empty string");
		try {
			ingr1 = new Ingredient("Cheese", FoodGroup.DAIRY, 70);
		}catch(Exception e) {

		}
		System.out.println("Before: "+ingr1.getName());
		ingr1.setName(name);
		System.out.println("After: "+ingr1.getName());
		if(ingr1.getName().compareTo(name) == 0) {
			System.out.println("Test Failed");
		} else if(ingr1.getName().compareTo("Cheese") == 0){
			System.out.println("Test Passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test10(){
		Ingredient ingr1 = null;
		String name = null;
		System.out.println("=========== TEST 10 ============");
		System.out.println("Testing name mutator method with a null string");
		try {
			ingr1 = new Ingredient("Cheese", FoodGroup.DAIRY, 70);
		}catch(Exception e) {

		}
		System.out.println("Before: "+ingr1.getName());
		ingr1.setName(name);
		System.out.println("After: "+ingr1.getName());
		try {
			if(ingr1.getName().compareTo(name) == 0) {
				System.out.println("Test Failed");
			}
		}catch(Exception e) {
			System.out.println("Test Passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test11(){
		Ingredient ingr1 = null;
		String name = "       ";
		System.out.println("=========== TEST 11 ============");
		System.out.println("Testing name mutator method with blank spaces as name");
		try {
			ingr1 = new Ingredient("Cheese", FoodGroup.DAIRY, 70);
		}catch(Exception e) {

		}
		System.out.println("Before: "+ingr1.getName());
		ingr1.setName(name);
		System.out.println("After: "+ingr1.getName());
		if(ingr1.getName().compareTo(name) == 0) {
			System.out.println("Test Failed");
		} else if(ingr1.getName().compareTo("Cheese") == 0){
			System.out.println("Test Passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test12(){
		Ingredient ingr1 = null;
		double calories = 5;
		System.out.println("=========== TEST 12 ============");
		System.out.println("Testing calories mutator method with positive value");
		try {
			ingr1 = new Ingredient("Cheese", FoodGroup.DAIRY, 70);
		}catch(Exception e) {

		}
		System.out.println("Before: "+ingr1.getCalories());
		ingr1.setCalories(calories);
		System.out.println("After: "+ingr1.getCalories());
		if(ingr1.getCalories() == calories) {
			System.out.println("Test Passed");
		} else if(ingr1.getCalories() == 70){
			System.out.println("Test Failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test13(){
		Ingredient ingr1 = null;
		double calories = 0;
		System.out.println("=========== TEST 13 ============");
		System.out.println("Testing calories mutator method with 0 as value");
		try {
			ingr1 = new Ingredient("Cheese", FoodGroup.DAIRY, 70);
		}catch(Exception e) {

		}
		System.out.println("Before: "+ingr1.getCalories());
		ingr1.setCalories(calories);
		System.out.println("After: "+ingr1.getCalories());
		if(ingr1.getCalories() == calories) {
			System.out.println("Test Passed");
		} else if(ingr1.getCalories() == 70){
			System.out.println("Test Failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test14(){
		Ingredient ingr1 = null;
		double calories = -5;
		System.out.println("=========== TEST 14 ============");
		System.out.println("Testing calories mutator method with negative value");
		try {
			ingr1 = new Ingredient("Cheese", FoodGroup.DAIRY, 70);
		}catch(Exception e) {

		}
		System.out.println("Before: "+ingr1.getCalories());
		ingr1.setCalories(calories);
		System.out.println("After: "+ingr1.getCalories());
		if(ingr1.getCalories() == calories) {
			System.out.println("Test Failed");
		} else if(ingr1.getCalories() == 70){
			System.out.println("Test Passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test15(){
		Ingredient ingr1 = null;
		FoodGroup foodGroup = FoodGroup.FAT;
		System.out.println("=========== TEST 15 ============");
		System.out.println("Testing foodGroup mutator method with valid FoodGroup");
		try {
			ingr1 = new Ingredient("Cheese", FoodGroup.DAIRY, 70);
		}catch(Exception e) {

		}
		System.out.println("Before: "+ingr1.getFoodGroup());
		ingr1.setFoodGroup(foodGroup);
		System.out.println("After: "+ingr1.getFoodGroup());
		if(ingr1.getFoodGroup() == foodGroup) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test16(){
		Ingredient ingr1 = null;
		FoodGroup foodGroup = null;
		System.out.println("=========== TEST 16 ============");
		System.out.println("Testing foodGroup mutator method with null FoodGroup");
		try {
			ingr1 = new Ingredient("Cheese", FoodGroup.DAIRY, 70);
		}catch(Exception e) {

		}
		System.out.println("Before: "+ingr1.getFoodGroup());
		ingr1.setFoodGroup(foodGroup);
		System.out.println("After: "+ingr1.getFoodGroup());
		if(ingr1.getFoodGroup() == foodGroup) {
			System.out.println("Test Failed");
		} else {
			System.out.println("Test Passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test17(){
		Ingredient ingr1 = null;
		System.out.println("=========== TEST 17 ============");
		System.out.println("Testing toString method");
		try {
			ingr1 = new Ingredient("Cheese", FoodGroup.DAIRY, 70);
		}catch(Exception e) {

		}
		System.out.println(ingr1);
		System.out.println("=========== END OF TEST ============\n\n");
	}
	private static void test18(){
		Ingredient ingr1 = null;
		System.out.println("=========== TEST 18 ============");
		System.out.println("Testing getDetails method");
		try {
			ingr1 = new Ingredient("Cheese", FoodGroup.DAIRY, 70);
		}catch(Exception e) {

		}
		System.out.println(ingr1.getDetails());
		System.out.println("=========== END OF TEST ============\n\n");
	}
}
