/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

import generate.DeckFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import people.People;
import people.Player;

/**
 *
 * @author Tomek
 */
public class Game {
    private LinkedList<Card> cardsDeck; 
    private LinkedList<Card> cardsOnTable;
    private List<People> playersList; 
    
    {
        cardsDeck = (LinkedList)DeckFactory.generateDeck();       
        playersList = new ArrayList<>();
        this.cardsOnTable = new LinkedList<>();
    }
    public void startGame(int playersNumber){
        this.generatePlayer(playersNumber);
        this.randomizedDeck();
        this.dealCards();
        this.showPlayers();
        this.cardOnTable();
        this.cardOnTable();
        this.cardOnTable();
        this.cardsOnTable.forEach(c -> Card.displayCard(c));

        while(this.cardsOnTable.size()<5){
            this.dealCard();
        this.cardsOnTable.forEach(c -> Card.displayCard(c));
        }
        this.findWinner();
    }
   public void dealCard(){
       System.out.println("Press any button do deal card");
       Scanner key = new Scanner(System.in);
       if(key.hasNext()){
           this.cardOnTable();
       }
   }
   private void findWinner(){
       System.out.println("Winner is:");
           this.playersList.forEach(p -> p.getCards().addAll(this.cardsOnTable));
           List<WinnerCollector> winner = this.playersList.stream().collect(() -> new ArrayList<>(), new WinnerCollector(), (x1,x2) -> x1.addAll(x2));
//           System.out.println("After WinnerCollector");
//           System.out.println(winner);
           System.out.println("Winner List: ");
           winner.stream().sorted(Comparator.comparing(WinnerCollector::getResult, Comparator.reverseOrder()))
                   .forEach(w ->
                           System.out.println(w.getResult()+" "+ w.getPlayer().getName()+" "+w.getPlayer().getLastName()+"\n"+ w.getWinnerMap()));

   }
   public void dealCards(){
       this.playersList.stream().forEach(p -> {
        p.setCard(this.cardsDeck.pollFirst());
        p.setCard(this.cardsDeck.pollFirst());
       });
   }
   public void cardOnTable(){
       this.cardsOnTable.add(this.cardsDeck.pollFirst());
   }
   public void showPlayers(){
       this.playersList.forEach(p -> People.displayPeople(p));
   }
   public void showDeck(){
       this.cardsDeck.forEach(System.out::println);
   }
   public List<People> sortPlayersByName(){
       return this.playersList.stream().sorted(Comparator.comparing(People::getName)).collect(toList());
   }
   public List<People> sortPlayerByLastName(){
       return this.playersList.stream().sorted((p ,p2) -> p.getLastName().compareTo(p2.getLastName())).collect(toList());
   }
    public List<People> sortPlayerByID(){
       return this.playersList.stream().sorted(this.CompareByID).collect(toList());
   }
   public List<Card> sortCardByValue(){
       return this.cardsDeck.stream().sorted().collect(toList());
   }
   public List<Card> sortCardByValueByBiggest(){
       return this.cardsDeck.stream().sorted((c, c2) -> (int) c2.getValue() -(int)c.getValue()).collect(toList());
   }
   public void randomizedDeck(){
       Collections.shuffle(this.cardsDeck);
   }
   public void test(){
       this.playersList.stream().map(p -> p.getName().toUpperCase()).forEach(System.out::println);
   }
   public void displayCard(Card card){
       Card.displayCard(card);
   }
   public void generatePlayer(int playersNumber){
       this.playersList = People.generatePlayers(playersNumber);
   }
   public Comparator<People> CompareByID = new Comparator<People>(){
       @Override
       public int compare(People p, People p2){
           return p2.getId() - p.getId() ;
       }
            
   };
     public Comparator<People> CompareByIDMin = new Comparator<People>(){
       @Override
       public int compare(People p, People p2){
           return  p.getId() - p2.getId() ;
       }
            
   };
     public Comparator<Entry<Integer,Long>> EntryCompare = new Comparator<Entry<Integer,Long>>(){      
        @Override
        public int compare(Entry<Integer, Long> t, Entry<Integer, Long> t1) {
            
            int returnValue =  t1.getValue().intValue() - t.getValue().intValue();
            if( returnValue == 0){
                returnValue = t1.getKey() - t.getKey();
            }
           return returnValue;
        }
     };
   public static void main(String[] args) {       
        Game cards = new Game();
        cards.startGame(5);
    }    
   
}

