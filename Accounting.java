package com.nadan.java.balance;

import java.util.ArrayList;
import java.util.Scanner;

public class Accounting {
	
	//Account��ü�� �迭�� ��� ����Ʈ�̴�. �� ����Ʈ���� ��ü�� ������ getter, setter�� ���ϴ� �����͸� ó���Ѵ�.
	ArrayList<Account> list = new ArrayList<>();
	//scanner�� ���� ��ȣ�� ���� �Է¹޴´�.
	Scanner scanner = new Scanner(System.in);
	
	public void accounting(){
		
		//while���� ������ ���� true���̴�. ���߿� ����� ��� false������ ������ �־� ��ȯ���� �������´�.
		boolean run = true;
		//if���� �� �´� ���� ������ ó���� �ϰ� �ٽ� ���� �ö�� � ó���� �� ������ ���� ��ȯ���̴�
		while(run){
			System.out.println("------------------------------------------");
			System.out.println("| 1.���»��� | 2.���¸�� | 3.���� | 4.��� | 5.���� |");
			System.out.println("------------------------------------------");
			
			//scanner�� ���� ��ȣ�� �Է¹ް� if������ � ó���� ����� ������ ó���Ѵ�.
			System.out.print("����>");
			String select = scanner.nextLine();
			
			//�Էµ� ���� String�̱� ������ ���ڷ� �ٲ㼭 ���Ѵ�
			//�� ó���� �����ϱ� ������ ���� �޼ҵ�� ���� ó���Ѵ�.
			//���� ����
			if(Integer.parseInt(select)==1){
				createAccount();
			//���� ����Ʈ
			} else if(Integer.parseInt(select)==2){
				accountList();	
			//����
			} else if(Integer.parseInt(select)==3){
				deposit();
			//���
			} else if(Integer.parseInt(select)==4){
				withdraw();
			//����
			} else if(Integer.parseInt(select)==5){
				System.out.println("���α׷� ����");
				run = false;	
			}
			
		}
		scanner.close();
	}
	
	//���� ���� �޼ҵ�
	public void createAccount(){
		System.out.println("���»���");
		System.out.println("----------");
		//���ο� ���°� �����Ǿ�� �ϱ� ������ ���ο� Account ��ü�� �����Ѵ�.
		Account newAccount = new Account();
		//���¹�ȣ�� �ʼ������� �ʿ��� ������ �־��ش�.
		System.out.print("���¹�ȣ �Է� : "); //���¹�ȣ �Է�
		String accountNumber = scanner.nextLine();
		//setter�� ���� �Է¹޴� ���� ���¹�ȣ�� �־��ش�.
		newAccount.setAccountNumber(accountNumber);
		
		System.out.print("������ �Է� : "); //������ �Է�
		String owner = scanner.nextLine();
		//setter�� ���� �Է¹޴� ���� �����ֿ� �־��ش�.
		newAccount.setOwner(owner);
		
		System.out.print("�Աݾ� �Է� : "); //�Աݾ� �Է�
		String deposit = scanner.nextLine();
		//setter�� ���� �Է¹޴� ���� �ʱⰪ�� �־��ش�.
		newAccount.setBalance(Integer.parseInt(deposit));
		
		//Accout��ü�� ����Ʈ�� �־��ش�.
		list.add(newAccount);
		
		System.out.println("���°� �����Ǿ����ϴ�");
		System.out.println();
	}
	
	//����Ʈ�� ��� �ִ� ���¸� ����ؼ� ������ش�.
	public void accountList(){
		
		System.out.println("���¸��");
		System.out.println("----------");
		int length = list.size();
		//����Ʈ�� ��� �ִ� �迭�� ������ŭ ó���Ѵ�.
		for(int i=0; i<length; i++){
			//get�� ���� ��ü�� ���� ��  getter�� ���� ���� �ҷ��´�
			String an = list.get(i).getAccountNumber();
			String ow = list.get(i).getOwner();
			int bl = list.get(i).getBalance();
			//�����ؼ� �� ���� ��� ����Ѵ�
			System.out.println(an+"\t"+ow+"\t"+bl);
		}
		System.out.println();
	}

	//����
	public void deposit(){
		Account account = new Account();
		System.out.println("����");
		System.out.println("----------");
		//���ݿ��� �߿��� ���� �ϴ� �� ���¸� ã�ƿ;� �Ѵٴ� ���̴�. 
		//���� �Է¹��� ���¹�ȣ�� ����Ʈ�� ��� �ִ� ���¹�ȣ�� ���ϸ鼭 ��ġ�ϴ� ��ü�� �����´�.
		System.out.print("���¹�ȣ : ");
		String an = scanner.nextLine();
		for(Account a : list){
			if(a.getAccountNumber().equals(an)){
				account = a;
			}
		}
		System.out.print("���ݾ� : ");
		//�� �� ������ scanner�� ���� Ÿ������ ��� ��� �ϴ±�. nextInt�� �ߴٰ� �ҳ� �������
		String deposit = scanner.nextLine();
		//���⼭�� setter�� balance�� ó���ϸ� �� �ȴ�. �ʱⰪ�� �ٲ�� ������ �����̴�.
		//���� �ʱⰪ�� �����ִ� �޼ҵ带 �ҷ��ͼ� ���ݾ��� �Ű� ������ �־��ش�.
		account.addBalance(Integer.parseInt(deposit));  
		System.out.println("�Ա��� �Ϸ�Ǿ����ϴ�");
		//�Ա��� �Ϸ�� ��� ���� �����ܰ� �����ش�
		System.out.println("�ܾ� : "+account.getBalance());
		System.out.println();
	}

	//���
	public void withdraw(){
		Account account = new Account();
		System.out.println("���");
		System.out.println("----------");
		//���ݰ� ���������� ��ݿ��� �߿��� ���� �� ���¸� ã�ƾ� �ϴ� ���̴�
		//�Է¹��� ���¹�ȣ�� ����Ʈ�� ��� �ִ� ���¹�ȣ�� ���ϸ鼭 ��ġ�ϴ� ��ü�� �����´�.
		System.out.print("���¹�ȣ : ");
		String an = scanner.nextLine();
		for(Account a : list){
			if(a.getAccountNumber().equals(an)){
				account = a;
			}
		}
		System.out.print("��ݾ� : ");
		String withdraw = scanner.nextLine();
		//���⼭�� setter�� balance�� ó���ϸ� �� �ȴ�. �ʱⰪ�� �ٲ�� ������ �����̴�.
		//���� ���� ������ ���ִ� �޼ҵ带 �ҷ��ͼ� ���ݾ��� �Ű� ������ �־��ش�.
		account.subBalance(Integer.parseInt(withdraw));
		System.out.println("����� �Ϸ�Ǿ����ϴ�");
		//��� �Ϸ� �� �ܾ��� �����ش�.
		System.out.println("�ܾ� : "+account.getBalance());
		System.out.println();
	}


}
