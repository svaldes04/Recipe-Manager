package part03;

import java.util.ArrayList;

public class Helper {

	/**
	 * Receives an ArrayList of IdedAndNamed and sorts it in ascending order by id.
	 * @param list
	 * @return ArrayList containing the same elements but in ascending order of id
	 */
	public static ArrayList<IdedAndNamed> sortById(ArrayList<IdedAndNamed> list){
		ArrayList<IdedAndNamed> result = new ArrayList<IdedAndNamed>();
		result.add(0, list.get(0));
		for(int i = 1; i < list.size(); i++) {
			for(int j = 0; j < result.size(); j++) {
				if(list.get(i).getId()<=result.get(j).getId()) {
					result.add(j, list.get(i));
					break;
				} else if(j == result.size()-1) {
					result.add(j+1, list.get(i));
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Receives an ArrayList of IdedAndNamed and sorts it in ascending order by name.
	 * @param list
	 * @return ArrayList containing the same elements but in alphabetical order
	 */
	public static ArrayList<IdedAndNamed> sortByName(ArrayList<IdedAndNamed> list){
		ArrayList<IdedAndNamed> result = new ArrayList<IdedAndNamed>();
		result.add(0, list.get(0));
		for(int i = 1; i < list.size(); i++) {
			for(int j = 0; j < result.size(); j++) {
				if(list.get(i).getName().compareTo(result.get(j).getName())<= 0) {
					result.add(j, list.get(i));
					break;	
				} else if(j == result.size()-1) {
					result.add(j+1, list.get(i));
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Receives an ArrayList of Ingredients and sorts it by FoodGroup (alphabetically).
	 * @param list
	 * @return ArrayList containing the same elements but organized by food group
	 */
	public static ArrayList<Ingredient> sortByFoodGroup(ArrayList<Ingredient> list){
		ArrayList<Ingredient> result = new ArrayList<Ingredient>();
		result.add(0, list.get(0));
		for(int i = 1; i < list.size(); i++) {
			for(int j = 0; j < result.size(); j++) {
				if(list.get(i).getFoodGroup().toString().compareTo(result.get(j).getFoodGroup().toString()) <= 0) {
					result.add(j, list.get(i));
					break;
				} else if(j == result.size()-1) {
					result.add(j+1, list.get(i));
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Searches in an arrayList for an IdedAndNamed that matches given id. The ArrayList must be sorted in ascending order by id.
	 * @param list
	 * @param id
	 * @return index where id matched, or -1 if the id does not match any element
	 */
	public static int searchById(ArrayList<IdedAndNamed> list, int id) {
		int min = 0;
		int max = list.size()-1;
		int mid;
		int result = -1;
		do{
			mid = min  + ((max - min) / 2);
	        if (list.get(mid).getId() < id) {
	            min = mid + 1;
	        } else if (list.get(mid).getId() > id) {
	            max = mid - 1;
	        } else if (list.get(mid).getId() == id) {
	        	result = mid;
	        	break;
	        }
		}while(min <= max);
		return result;
	}
	
	/**
	 * Searches in an arrayList for an IdedAndNamed that matches given name. The ArrayList must be sorted in ascending alphabetical order.
	 * @param list
	 * @param name
	 * @return arrayList containing all the indexes where name matched, or empty arrayList if there was no matches
	 */
	public static ArrayList<Integer> searchByName(ArrayList<IdedAndNamed> list, String name) {
		int min = 0;
		int max = list.size()-1;
		int mid;
		ArrayList<Integer> result = new ArrayList<Integer>();
		do{
			mid = min  + ((max - min) / 2);
	        if (list.get(mid).getName().compareToIgnoreCase(name) < 0) {
	            min = mid + 1;
	        } else if (list.get(mid).getName().compareToIgnoreCase(name) > 0) {
	            max = mid - 1;
	        } else if (list.get(mid).getName().compareToIgnoreCase(name) == 0) {
	        	result.add(mid);
	        	// check if any higher indexes match name
	        	int check = mid;
	        	do {
	        		// to avoid leaving range of indexes
	        		if(check >= list.size()-1) {break;}
	        		check++;
	        		if(list.get(check).getName().compareToIgnoreCase(name) == 0) {
	        			result.add(check);
	        		} else {break;}
	        	}while(true);
	        	
	        	// check if any lower indexes match name
	        	check = mid;
	        	do {
	        		// to avoid leaving range of indexes
	        		if(check <= 0) {break;}
	        		check--;
	        		if(list.get(check).getName().compareToIgnoreCase(name) == 0) {
	        			result.add(check);
	        		} else {break;}
	        	}while(true);
	        	
	        	// all indexes that match id have been added to result
	        	break;
	        }
		}while(min <= max);
		return result;
	}
	
	
	/**
	 * Searches in an arrayList for an IdedAndNamed that contain given part-name. The ArrayList must be sorted in ascending alphabetical order.
	 * @param list
	 * @param name
	 * @return arrayList containing all the indexes where name contains part-name, or empty arrayList if there was no matches
	 */
	public static ArrayList<Integer> searchByPartName(ArrayList<IdedAndNamed> list, String partname){
		list = sortByName(list);
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int index = 0; index < list.size(); index++) {
			// turn all to lower case, to compare without case sensitivity
			if(list.get(index).getName().toLowerCase().indexOf(partname.toLowerCase()) >= 0) {
				result.add(index);
			}
		}
		return result;
	}
	
	/**
	 * Searches in an arrayList for an Ingredient that matches given foodGroup. ArrayList must be sorted by FoodGroup (ascending alphabetically)
	 * @param list
	 * @param foodGroup
	 * @return arrayList containing all the indexes where foodGroup matched, or empty arrayList if there was no matches
	 */
	public static ArrayList<Integer> searchByFoodGroup(ArrayList<Ingredient> list, FoodGroup foodGroup){
		list = sortByFoodGroup(list);
		int min = 0;
		int max = list.size()-1;
		int mid;
		ArrayList<Integer> result = new ArrayList<Integer>();
		do{
			mid = min  + ((max - min) / 2);
	        if (list.get(mid).getFoodGroup().toString().compareTo(foodGroup.toString()) < 0) {
	            min = mid + 1;
	        } else if (list.get(mid).getFoodGroup().toString().compareTo(foodGroup.toString()) > 0) {
	            max = mid - 1;
	        } else if (list.get(mid).getFoodGroup().toString().compareTo(foodGroup.toString()) == 0) {
	        	result.add(mid);
	        	// check if any higher indexes match id
	        	int check = mid;
	        	do {
	        		// to avoid leaving range of indexes
	        		if(check >= list.size()-1) {break;}
	        		check++;
	        		if(list.get(check).getFoodGroup().toString().compareTo(foodGroup.toString()) == 0) {
	        			result.add(check);
	        		} else {break;}
	        	}while(true);
	        	
	        	// check if any lower indexes match id
	        	check = mid;
	        	do {
	        		// to avoid leaving range of indexes
	        		if(check <= 0) {break;}
	        		check--;
	        		if(list.get(check).getFoodGroup().toString().compareTo(foodGroup.toString()) == 0) {
	        			result.add(check);
	        		} else {break;}
	        	}while(true);
	        	
	        	// all indexes that match id have been added to result
	        	break;
	        }
		}while(min <= max);
		return result;
	}
}