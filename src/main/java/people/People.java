/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import cards.Card;
import cards.Figure;
import cards.NumberCard;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Tomek
 */
public interface People{
    
    int getId();
    String getName();
    String getLastName();
    String getAdress();
    List<Card> getCards();
    LocalDate getDate();
   
    Card getOneCard();
    boolean hasCards();
    int cardNumber();
    
    void setId(int id);
    void setName(String name);
    void setLastname(String lastName);
    void setAddress(String address);
    void setCards(LinkedList<Card> card);
    void setCard(Card card);
    void setDate(LocalDate date);

    @Override
    public boolean equals(Object o);
    
    static <T extends People> void  displayPeople(T people){
        System.out.println("----------------------------------------------");
        System.out.println(people.getName()+"  "+people.getLastName());
        people.getCards().forEach(card ->{
            if( card instanceof NumberCard){
                System.out.print("| "+card.getValue().toString()+" "+card.getSuit()+" "+card.getColor()+" | ");
            }else{
                System.out.print("| "+((Figure)card).getFigure()+" "+card.getSuit()+" "+card.getColor()+" | ");
            }
        });
        System.out.println("\n----------------------------------------------");
    }
    static List<People> generatePlayers(int numberOfPlayers){
        String[] name ={"Tomek","Jacek","Piotrek","Filip","Wojtek","Karol","Marcin","Szymon","Bartek","Dawid"};
        String[] lastName ={"Gołębiowski","Janaszek","Kowalski","Lato","Mydło","Sidło","Stoch","Kubacki"};
//        int[] nameNumber = new Random().ints(numberOfPlayers, 0, name.length).toArray();
//        int[] lastNameNumber =  new Random().ints(numberOfPlayers, 0, lastName.length).toArray();

        Random generator = new Random();
        List<People> playersList =Stream.generate(() -> {
                 
            return new Player(generateID(),
                    name[generator.nextInt(name.length -1)],
                    lastName[generator.nextInt(lastName.length -1)],
                    "Address",LocalDate.now()
            );
            
        }).limit(numberOfPlayers).collect(Collectors.toList());
             System.out.println("Players Count "+playersList.size());
             return playersList;
    }
   // static int i= 0;
    static int generateID(){
        return 1;       
    }
}
