package com.nadan.java.balance;

//�ϳ��� ������ �ش��ϴ� �����͸� ��� ���� Ŭ����
public class Account {
	
	//���¹�ȣ, ������, �ܾ��� ��� �ܺο��� ���� �����ؼ� �ٲٸ� �� �Ǵ� �����̴�.
	//���� private�� �ٲ� �� getter�� setter�� ����� ���ϴ� ������ ó�����ش�.
	private String accountNumber;
	private String owner;
	private int balance;
	
	//getter�� setter
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//���� �޼ҵ�
	public void addBalance(int input) {
		this.balance = this.balance + input;
	}
	
	//��� �޼ҵ�
	public void subBalance(int input) {
		balance = balance - input;
	}
	
	

}
