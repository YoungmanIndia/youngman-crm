package com.youngman.youngman.services;

public interface CredentialsService {
	
	/**
	 * Password validation with specific rules
	 * @param password
	 * @param repeatPassword
	 * @param store
	 * @param language
	 * @throws CredentialsException
	 */
	void validateCredentials(String password, String repeatPassword) throws CredentialsException;
	
	/**
	 * Generates password based on specific rules
	 * @param store
	 * @param language
	 * @return
	 * @throws CredentialsException
	 */
	String generatePassword() throws CredentialsException;

}
