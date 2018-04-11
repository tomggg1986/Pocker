/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generate;

import cards.Card;
import cards.Figure;
import cards.NumberCard;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Tomek
 */
public class DeckFactory {
    private static final int DECKSIZE = 52;
    public  enum color{
        RED("red"),BLACK("black");
        private String col;
        private color(String col){
            this.col = col;
        }
        public String toString(){
            return this.col;
        }
    }
    public static enum suitFrench{
        HEARDS("heards"),TILES("tiles"),CLOVERS("clovers"),PIKES("pikes");
        private String suit;
        private suitFrench(String suit){
            this.suit = suit;
        }
    }
    public enum figure{
        JACK("Jack"),
        QUEEN("Queen"),
        KING("King"),
        ACE("Ace");
        private String figure;
        private figure(String f){
            this.figure = f;
        }
        @Override
        public String toString(){
            return this.figure;
        }
    }
    public static List<Card> generateDeck(){
        List<Card> deck = new LinkedList<>();
        for(int i =2;i<=10;i++){
            deck.add(new NumberCard(color.BLACK.toString(), suitFrench.CLOVERS.name(),i));
            deck.add(new NumberCard(color.BLACK.toString(), suitFrench.PIKES.name(),i));
            deck.add(new NumberCard(color.RED.toString(), suitFrench.HEARDS.name(),i));
            deck.add(new NumberCard(color.RED.toString(), suitFrench.TILES.name(),i));
        }
        
        deck.add(new Figure(color.BLACK.toString(), suitFrench.CLOVERS.name(),1,figure.JACK.toString()));
        deck.add(new Figure(color.BLACK.toString(), suitFrench.PIKES.name(),11,figure.JACK.toString()));
        deck.add(new Figure(color.RED.toString(), suitFrench.HEARDS.name(),11,figure.JACK.toString()));
        deck.add(new Figure(color.RED.toString(), suitFrench.TILES.name(),11,figure.JACK.toString()));
            
        deck.add(new Figure(color.BLACK.toString(), suitFrench.CLOVERS.name(),12,figure.QUEEN.toString()));
        deck.add(new Figure(color.BLACK.toString(), suitFrench.PIKES.name(),12,figure.QUEEN.toString()));
        deck.add(new Figure(color.RED.toString(), suitFrench.HEARDS.name(),12,figure.QUEEN.toString()));
        deck.add(new Figure(color.RED.toString(), suitFrench.TILES.name(),12,figure.QUEEN.toString()));
        
        deck.add(new Figure(color.BLACK.toString(), suitFrench.CLOVERS.name(),13,figure.KING.toString()));
        deck.add(new Figure(color.BLACK.toString(), suitFrench.PIKES.name(),13,figure.KING.toString()));
        deck.add(new Figure(color.RED.toString(), suitFrench.HEARDS.name(),13,figure.KING.toString()));
        deck.add(new Figure(color.RED.toString(), suitFrench.TILES.name(),13,figure.KING.toString()));
        
        deck.add(new Figure(color.BLACK.toString(), suitFrench.CLOVERS.name(),14,figure.ACE.toString()));
        deck.add(new Figure(color.BLACK.toString(), suitFrench.PIKES.name(),14,figure.ACE.toString()));
        deck.add(new Figure(color.RED.toString(), suitFrench.HEARDS.name(),14,figure.ACE.toString()));
        deck.add(new Figure(color.RED.toString(), suitFrench.TILES.name(),14,figure.ACE.toString()));
       
        return deck;
    }
    private static Card createNumberCard(String color,String suit, Integer number){
        return new NumberCard(color, suit, number );
    } 
}
