package org.itstep.dao;

import static org.junit.Assert.*;

import java.io.ObjectInputStream.GetField;

import org.itstep.model.Account;
import org.junit.Test;

public class AccountDAOTest {

	@Test
	public void testSave() {
		Account account1 = new Account("Ivan", "Ivanov");
		AccountDAO accountSave = new AccountDAO();
		accountSave.save(account1);
		Account account2 = new Account();
		AccountDAO accountGet = new AccountDAO();
		account2 = accountGet.get("Ivan", "Ivanov");
		
		assertEquals(account1.getFirstName(), account2.getFirstName());		
		assertEquals(account1.getSecondName(), account2.getSecondName());
		assertEquals(account1.getEmail(), account2.getEmail());
		assertEquals(account1.getPassword(), account2.getPassword());
		
		AccountDAO accountDell = new AccountDAO();
		accountDell.delete("Ivan", "Ivanov");
		
		account2 = accountGet.get("Ivan", "Ivanov");
		String name1 = account2.getFirstName();
		String name2 = account2.getSecondName();
		assertTrue(name1 == null);
		assertTrue(name2 == null);
	}

	@Test
	public void testGet() {
		//test is implemented in the method testSave
	}

	@Test
	public void testUpdate() {
		Account accountOld = new Account("Ivan", "Ivanov");
		AccountDAO accountSave = new AccountDAO();
		accountSave.save(accountOld);
		Account accountNew = new Account("Vasya", "Petrov");
		AccountDAO accountUpdate = new AccountDAO();
		accountUpdate.update("Ivan", "Ivanov", accountNew);
		
		Account account2 = new Account();
		AccountDAO accountGet = new AccountDAO();
		account2 = accountGet.get("Vasya", "Petrov");
		
		assertEquals(accountNew.getFirstName(), account2.getFirstName());		
		assertEquals(accountNew.getSecondName(), account2.getSecondName());
		assertEquals(accountNew.getEmail(), account2.getEmail());
		assertEquals(accountNew.getPassword(), account2.getPassword());
		
		AccountDAO accountDell = new AccountDAO();
		accountDell.delete("Vasya", "Petrov");
						
	}

	@Test
	public void testDelete() {
		//test is implemented in the method testSave
	}
	

}
