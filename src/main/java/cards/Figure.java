package cards;


public class Figure implements Card, Comparable<Card>{
    
    private String Color;
    private String Suit;
    private Integer Value;
    private String figure;
    
    public Figure(){
        
    }
    public Figure(String Color, String Suit, int Value, String figure) {
        this.Color = Color;
        this.Suit = Suit;
        this.Value = Value;
        this.figure = figure;
    }  
    @Override
    public String getColor() {
        return this.Color;
    }

    @Override
    public String getSuit() {
        return this.Suit;
    }

    @Override
    public Integer getValue() {
        return this.Value;
    }

    public String getFigure() {
        return figure;
    }

    @Override
    public String toString() {
        return "Figure{" + "Color=" + Color + ", Suit=" + Suit + ", Value=" + Value + '}';
    }

    @Override
    public int compareTo(Card card) {
        return this.getValue() - (int)(card).getValue();
    }
  
}
