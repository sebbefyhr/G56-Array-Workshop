package se.lexicon;

import java.util.Arrays;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0];


    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        return names.length;
    }


    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * @param names The array of names to set.
     */
    public static void setNames(String[] names) {
        //todo: implement setNames method
        NameRepository.names = names;
    }


    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        //todo: implement clear method
        String[] newNames = new String[0];
        names = newNames;
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        //todo: implement findAll method

        return Arrays.copyOf(names, names.length);
    }


    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(String fullName) {
        for(String s : names){
            if(s.equalsIgnoreCase(fullName)){
                return s;
            }
        }
        return null;
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(String fullName) {
        //todo: implement add method
        if(find(fullName) == null){
            if(names[names.length-1] != null){
                names = Arrays.copyOf(names, names.length +1);
            }
            names[names.length-1] = fullName;
            return true;
        }
        return false;
    }


    /**
     * Find all names that match the given firstName.
     *
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(String firstName) {

        String[] firstNameArray = new String[0];

        for(int i = 0; i < names.length; i++){

            if(names[i].toLowerCase().contains(firstName.toLowerCase())){

                firstNameArray = Arrays.copyOf(firstNameArray, firstNameArray.length+1);
                firstNameArray[firstNameArray.length-1] = names[i];
            }

        }
        return firstNameArray;
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(String lastName) {

        String[] lastNameArray = new String[0];

        for(int i = 0; i < names.length; i++){
            if(names[i].toLowerCase().contains(lastName.toLowerCase())){
                lastNameArray = Arrays.copyOf(lastNameArray, lastNameArray.length + 1);
                lastNameArray[lastNameArray.length-1] = names[i];
            }
        }
        return lastNameArray;
    }


    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(String original, String updatedName) {
        //todo: implement update method
        for(int i = 0; i < names.length-1; i++){
            if(names[i].equalsIgnoreCase(original)){
                names[i] = updatedName;
                return true;
            }
        }
        return false;
    }


    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(String fullName) {

        for(int i = 0; i < names.length; i++){
            if(names[i].equalsIgnoreCase(fullName)){
                names[i] = null;

                if(i != names.length-1){
                    String temp = names[names.length-1];
                    names[names.length-1] = null;
                    names[i] = temp;
                    setNames(Arrays.copyOfRange(names, 0, names.length-1));
                }
                else{
                    setNames(Arrays.copyOfRange(names, 0, names.length-1));
                }

                return true;
            }
        }
        return false;
    }


}