package blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import blackjack.demo.Card;

public class demo {
	
		

		static public class Card {
			String kleurCard;
			String waardeCard;
			int points;
			
			public Card (String akleurCard, String awaardeCard, int apoints ) {
				kleurCard = akleurCard;
				waardeCard = awaardeCard;
				points = apoints;	
	}
			
			public void printCard() {
				System.out.println(kleurCard + waardeCard);
			}
		}
static void menu() {
				System.out.println(" ");
				System.out.println("you can choose the following options:");
				System.out.println("a = Start new game. ");
				System.out.println("k = draw a card. ");
				System.out.println("k = pass ");
				System.out.println("q = quit game.");
				System.out.println(" ");
			}

		public static void main(String[] args) {
			
			
			String kleur[] = {"Clubs", "Diamonds", "Hearts", "Spades"};
			String waarde[] = {" King", " Queen"," Jack", " 10", " 9"," 8", " 7", " 6", " 5", " 4", " 3", " 2",  " Ace"};
			int[] point = {10, 10, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2, 11 }; 
			List<Card> deck = new ArrayList<Card>();
			int totalPoints = 0;
			int draws = 0;
			boolean stop = false; 
				
			for(int i=0; i< kleur.length; i++) {
				for(int j=0; j<waarde.length; j++) {
					 
					Card Cardnumber = new Card(kleur[i],waarde[j],point[j]);
					deck.add(Cardnumber);
					
				}
			}
			
				
			
			Collections.shuffle(deck);
			
			System.out.println("Welcome to Blackjack");
			System.out.println("You have the following cards:");
			System.out.println(" ");
			Card card1 = deck.get(0);
			System.out.println(card1.kleurCard + card1.waardeCard);
			Card card2 = deck.get(1);
			System.out.println(card2.kleurCard + card2.waardeCard);
			draws=2;
			System.out.println(" ");
			
			
			Scanner myObj = new Scanner(System.in);
			
			
			
			
			while (stop != true) {
				
				menu();
				String input = myObj.nextLine() ;
				
			switch (input) {
			case "a":
				draws = 0;
				Collections.shuffle(deck);
				totalPoints = 0;
				
				System.out.println(" ");
				Card newCard1 = deck.get(0);
				System.out.println(newCard1.kleurCard + newCard1.waardeCard);
				Card newCard2 = deck.get(1);
				System.out.println(newCard2.kleurCard + newCard2.waardeCard);
				draws=2;
				
				break;
			case "k":
				
				System.out.println(" ");
				Card result = deck.get(draws);
				System.out.println(result.kleurCard + result.waardeCard);
				draws++;
				
				break;
			case "q":
				System.out.println("You decided to stop the game.");
				stop = true;
				break;
			case "p":
				
				System.out.println("You have the following cards:");
				totalPoints = 0;
				
				for (int i = 0; i<(draws+1); i++) {
					if (i>0) {
					Card resultPoint = deck.get(i-1);
					System.out.println(resultPoint.kleurCard + resultPoint.waardeCard);
					totalPoints = totalPoints + resultPoint.points;
					
					if(totalPoints>21 ) {
						for (int r=0; r<draws; r++){
							Card aas = deck.get(r);
							if(aas.waardeCard == " Ace") {
								totalPoints= totalPoints - 10; 
							}
						}
						
					}
					
					}
					else {
					totalPoints =0;}
				}
				
				System.out.println("In total " + totalPoints + " points.");
				
				if (totalPoints>21) {
					System.out.println("You lose!");
				}else if (totalPoints == 21) {
					System.out.println("Congratualation, you win");
				}else {
					System.out.println("You have less then 21 points.");
				}
				
				draws = 0;
				Collections.shuffle(deck);
				totalPoints = 0;
				
				break;
			default:
				System.out.println("This is not a option.");
				
			}
			}
			
			}
			
		}

		
		
		
	
			

		
			



			

