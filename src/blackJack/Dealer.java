package blackJack;

import java.util.LinkedList;
import java.util.Scanner;

public class Dealer {
	private boolean doublePoint= false;
	private int point;
	private LinkedList <Card> cards=new LinkedList<Card>();
	private LinkedList <Card> dealerCards=new LinkedList<Card>();
	private LinkedList <Card> customerCards=new LinkedList<Card>();
	private LinkedList <Card> additionCards=new LinkedList<Card>();
	Scanner sc=new Scanner(System.in);
	Dealer(){
		updateCards();
		System.out.println("Hello! Wellcome to our casino\n Do you want to play?");
		int c=sc.nextInt();
		if(c==1)
			start();
		else
			System.out.println("Good bay");
	}
	
//	Begin game
	
	public void start(){
		giveCard(customerCards);
		giveCard(dealerCards);
		giveCard(customerCards);
		System.out.println("Dealer cards :");
		showCards(dealerCards);
		String n1=customerCards.get(0).name().substring(1);
		String n2=customerCards.get(1).name().substring(1);
		if(n1.equals(n2)){
			System.out.println("Do you want to divide?\n1-yes\n2-no");
			int c=sc.nextInt();
			if(c==1){
				doublePoint=true;
				additionCards.add(customerCards.get(1));
				customerCards.remove(1);
			}
		}
		plaingCustomer();
			
	}
			
//	Customers moves
		
	public void plaingCustomer(){
		if(doublePoint){
			giveCard(additionCards);
			giveCard(customerCards);
			showCards(additionCards);
			other:while(true){
				System.out.println("Do you want one more for addition card?\n1-yes\n2-no");
				int c=sc.nextInt();
				if(c==1){
					giveCard(additionCards);
					System.out.println("Your addition cards");
					showCards(additionCards);
					if(points(additionCards)>21){
						hasAce(additionCards);
						if(points(additionCards)>21){
							System.out.println("You have bust. Do your moves with next cards");
							break other;
						}
					}
				}else{
					break other;
				}
			}
		}
		
		while(true){
			System.out.println("Your card");
			showCards(customerCards);
			System.out.println("Do you want one more card?\n1-yes\n2-no");
			int c=sc.nextInt();
			if(c==1){
				giveCard(customerCards);
				if(points(customerCards)>21){
					hasAce(customerCards);
					if(points(customerCards)>21){
						if(points(additionCards)<=21){
							plaingDealer();
						}
						System.out.println("You have bust. Dealer win!!!");
						end();
					}
				}
			}else{
				plaingDealer();
			}
		}
		
	}
	
//	Game after customers moves
	
	public void plaingDealer(){
		while(points(dealerCards)<17){
			giveCard(dealerCards);
			if(points(dealerCards)>21){
				hasAce(dealerCards);
				if(points(dealerCards)>21){
					System.out.println("Dealer have bust. You win!!!");
					showCards(dealerCards);
					end();
				}
			}
		}
		System.out.println("Your carts:");
		showCards(customerCards);
		System.out.println("Dealer carts:");
		showCards(dealerCards);
		if(points(dealerCards)<points(additionCards)){
			System.out.println("You win!");
			System.out.println(points(additionCards)+"\n ");
		}else if(points(dealerCards)<points(customerCards)){
			System.out.println("You win!");
			System.out.println(points(customerCards)+"\n ");
		}else if(points(dealerCards)==points(customerCards)){
			System.out.println("sss");
		}else if(points(dealerCards)>points(customerCards)){
			System.out.println("Dealer win!");
			System.out.println(points(dealerCards)+"\n ");
		}
		end();
		
		
	}
	
//	finish game
	
	public void end(){
		additionCards.clear();
		customerCards.clear();
		dealerCards.clear();
		updateCards();
		System.out.println("Do you want to play again?\n1-yes\n2-no");
		int c=sc.nextInt();
		if(c==1){
			start();
		}else{
			System.out.println("Good bay");
		}
	}
	
//	update collection cards
	
	public void updateCards(){
		cards.clear();
		Card [] card=Card.values();
		for(int i=0;i<Card.values().length;i++){
			cards.add(card[i]);
		}
	}
	
//  Show all cards some collection 
	
	public void showCards(LinkedList <Card> some){    
		some.forEach((e)-> System.out.print(" ["+e.name().substring(1) +" of "+ e.getSuit()+" ]"));
		System.out.println("");
	}
	
//  Look for Ace in some collection
	
	public void hasAce(LinkedList <Card> some){
		if(some.contains(Card.CAce)){
			some.get(some.indexOf(Card.CAce)).setValue(1);
			return;
		}
		if(some.contains(Card.DAce)){
			some.get(some.indexOf(Card.DAce)).setValue(1);
			return;
		}
		if(some.contains(Card.SAce)){
			some.get(some.indexOf(Card.SAce)).setValue(1);
			return;
		}
		if(some.contains(Card.HAce)){
			some.get(some.indexOf(Card.HAce)).setValue(1);
			return;
		}
	}
	
//	Return numbers of points from one collection
	
	public int points(LinkedList <Card> some){
		point=0;
		some.forEach((e)-> point+=e.getValue());
		return point;
		
	}
	
//	Add one card to some collection
	
	public void giveCard(LinkedList <Card> some){
		int x=(int)(Math.random()*(cards.size()-1));
		some.addLast(cards.get(x));
		cards.remove(x);
	}
	
}

