
package cards;


public class NumberCard implements Card, Comparable<Card>{
    
    private String color;
    private String suit;
    private Integer value;
    
    public NumberCard(String color, String suit, Integer value){
        this.color = color;
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getSuit() {
        return this.suit;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "NumberCard{" + "color=" + color + ", suit=" + suit + ", value=" + value + '}';
    }

    @Override
    public int compareTo(Card card) {
        return   this.getValue() - (int)card.getValue();
    }

   
    
    
}
