public class Card {
    private Color color;
    private Rank rank;
    private Suit suit;

    public Card(Color color, Rank rank, Suit suit){
        this.color = color;
        this.rank = rank;
        this.suit = suit;
    }

    public Color getColor(){
        return color;
    }

    public Rank getRank(){
        return rank;
    }
    public Suit getSuit(){
        return suit;
    }

    @Override
    public String toString() {
        return color + "_" + rank + "_" + suit;
    }
}
