/*
 * Class: CMSC204
 * CRN:21078
 * Instructor: Monshi
 * Description: Checks whether password user entered is meets necessary requirements
 * Due: 2/7/22
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Akhil Gunda______
*/
import java.util.*;
/*
 * methods of PasswordChecker
 * @author Akhil Gunda
 */
public class PasswordCheckerUtility {

	/*
	 * checks if passwords equal
	 * @throws UnmatchedException
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
		if(!password.equals(passwordConfirm)){
			throw new UnmatchedException();
		}
	}
	/*
	 * @return true or false if passwords match
	 */
	public static boolean comparePasswordsWithReturn(String password,
            String passwordConfirm) {
		return password.equals(passwordConfirm);
	}
	
	/*
	 * checks to make sure password is longer or equal to 6 characters
	 * @throws LengthException
	 * @return true if password is valid length
	 */
	public static boolean isValidLength(String password)
            throws LengthException{
		
		if(password.length() >= 6) {
			return true;
		}
		
		throw new LengthException();
		
	}
	/*
	 * checks if has uppercase letter
	 * @throws NoUpperAlphaException
	 * @return returns true if has uppercase char
	 */
	public static boolean hasUpperAlpha(String password)
            throws NoUpperAlphaException{
		char c = password.charAt(0);
		for (int i = 0; i < password.length(); i++) {
			c = password.charAt(i);
			if(Character.isUpperCase(c)) {
				return true;
			}
		}
		
		throw new NoUpperAlphaException();
	}
	
	/*
	 * checks to make sure there is a lower case character
	 * @throws NoLowerAlphaException
	 * @return true if has lower case letter
	 */
	public static boolean hasLowerAlpha​(String password)
            throws NoLowerAlphaException{
		
		char c = password.charAt(0);
		for (int i = 0; i < password.length(); i++) {
			c = password.charAt(i);
			if(Character.isLowerCase(c)) {
				return true;
			}
		}
		
		throw new NoLowerAlphaException();
	}
	
	/*
	 * checks if there is a number
	 * @throws NoDigitException
	 * @return return true if has number
	 */
	public static boolean hasDigit​(String password)
            throws NoDigitException{
		char c = password.charAt(0);
		for (int i = 0; i < password.length(); i++) {
			c = password.charAt(i);
			if(Character.isDigit(c)) {
				return true;
			}
		}
		throw new NoDigitException();
	}
	
	/*
	 * checks if there is special character
	 * @throws NoSpecialCharacterException
	 * @return true if has special character
	 */
	public static boolean hasSpecialChar​(String password)
            throws NoSpecialCharacterException{
		if (password.matches(".*[^A-Za-z0-9].*"))
			return true;
		
		throw new NoSpecialCharacterException();
	}
	
	/*
	 * make sure 3 characters in row aren't same
	 * @throws InvalidSequenceException
	 * @return true if no 3 consequence characters are the same
	 */
	public static boolean NoSameCharInSequence​(String password)
            throws InvalidSequenceException{
		for (int i = 0; i < password.length() - 2; i++) {
			if (password.charAt(i) == password.charAt(i+1) && password.charAt(i) == password.charAt(i+2) 
					&& password.charAt(i+1) == password.charAt(i+2) ) {
				throw new InvalidSequenceException();
			}
		}
		return false;
	}
	/*
	 * checks for valid password
	 * @return true if password is valid
	 * @throws LengthException,
                   NoUpperAlphaException,
                   NoLowerAlphaException,
                   NoDigitException,
                   NoSpecialCharacterException,
                   InvalidSequenceException
        
	 */
	public static boolean isValidPassword​(String password)
            throws LengthException,
                   NoUpperAlphaException,
                   NoLowerAlphaException,
                   NoDigitException,
                   NoSpecialCharacterException,
                   InvalidSequenceException{
		boolean isValidPassword = false;
		try {
			if(PasswordCheckerUtility.isValidLength(password) && PasswordCheckerUtility.hasUpperAlpha(password) 
					&& PasswordCheckerUtility.hasLowerAlpha​(password) && PasswordCheckerUtility.hasDigit​(password)
					&& PasswordCheckerUtility.hasSpecialChar​(password) && !PasswordCheckerUtility.NoSameCharInSequence​(password)) {
				isValidPassword = true;
			}
		}
		catch(LengthException e)
		{
			throw new LengthException();
		}
		catch(NoUpperAlphaException e) {
			throw new NoUpperAlphaException();
		}
		catch(NoLowerAlphaException e) {
			throw new NoLowerAlphaException();
		}
		catch(NoDigitException e) {
			throw new NoDigitException();
		}
		catch(NoSpecialCharacterException e) {
			throw new NoSpecialCharacterException();
		}
		catch(InvalidSequenceException e) {
			throw new InvalidSequenceException();
		}
		//should return true if it gets to this point
		return isValidPassword;
	}
	
	/*
	 * checks to make sure there are between 6 and 9 characters
	 * @return true if it is, false otherwise
	 */
	public static boolean hasBetweenSixAndNineChars​(String password) {
		return password.length() >= 6 && password.length() <= 9? true: false;
	}
	
	/*
	 * checks if password is weak (is valid but has less than 6 or greater than 9 characters
	 * @throw WeakPasswordException
	 * @return false if is valid password and is not between 6 and 9 chars
	 */
	public static boolean isWeakPassword​(String password)
            throws WeakPasswordException{
		try {
			if(PasswordCheckerUtility.isValidPassword​(password) && !PasswordCheckerUtility.hasBetweenSixAndNineChars​(password)) {
				return false;
			}
		}
		catch(Exception e) {
			
		}
		throw new WeakPasswordException();
	}
	
	/*
	 * returns arraylist and its corresponding error message
	 * @return an ArrayList of invalid passwords, and the corresponding message
	 * 
	 */
	public static ArrayList<String> getInvalidPasswords​(ArrayList<String> passwords){
		ArrayList<String> invalidPasswords = new ArrayList<>();
		
		for(int i =0; i < passwords.size(); i++) {
			
			try {
				if(PasswordCheckerUtility.isValidPassword​(passwords.get(i))) {
				}
			}
			catch(LengthException | NoUpperAlphaException |
				NoLowerAlphaException | NoDigitException | 
				NoSpecialCharacterException |InvalidSequenceException e) {
				invalidPasswords.add(passwords.get(i) + " " + e.getMessage());
			}
			
		}
		return invalidPasswords;
	}

}