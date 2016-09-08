package blackJack;

public enum Card {
	HKing(Suit.Heart,10),DKing(Suit.Diamound,10),SKing(Suit.Spade,10),CKing(Suit.Club,10),
	HAce(Suit.Heart,11),DAce(Suit.Diamound,11),SAce(Suit.Spade,11),CAce(Suit.Club,11),
	HQueen(Suit.Heart,10),DQueen(Suit.Diamound,10),SQueen(Suit.Spade,10),CQueen(Suit.Club,10),
	HJack(Suit.Heart,10),DJack(Suit.Diamound,10),SJack(Suit.Spade,10),CJack(Suit.Club,10),
	HTen(Suit.Heart,10),DTen(Suit.Diamound,10),STen(Suit.Spade,10),CTen(Suit.Club,10),
	HNine(Suit.Heart,9),DNine(Suit.Diamound,9),SNine(Suit.Spade,9),CNine(Suit.Club,9),
	HEight(Suit.Heart,8),DEight(Suit.Diamound,8),SEight(Suit.Spade,8),CEight(Suit.Club,8),
	HSeven(Suit.Heart,7),DSeven(Suit.Diamound,7),SSeven(Suit.Spade,7),CSeven(Suit.Club,7),
	HSix(Suit.Heart,6),DSix(Suit.Diamound,6),SSix(Suit.Spade,6),CSix(Suit.Club,6),
	HFive(Suit.Heart,5),DFive(Suit.Diamound,5),SFive(Suit.Spade,5),CFive(Suit.Club,5),
	HFour(Suit.Heart,4),DFour(Suit.Diamound,4),SFour(Suit.Spade,4),CFour(Suit.Club,4),
	HThree(Suit.Heart,3),DThree(Suit.Diamound,3),SThree(Suit.Spade,3),CThree(Suit.Club,3),
	HTwo(Suit.Heart,2),DTwo(Suit.Diamound,2),STwo(Suit.Spade,2),CTwo(Suit.Club,2);
	private Suit suit;
	private int value;
	private Card(Suit s, int value) {
		this.suit = s;
		this.value = value;
	}
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit s) {
		this.suit = s;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
	
	
	
}
