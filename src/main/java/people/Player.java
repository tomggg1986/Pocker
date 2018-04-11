package people;

import cards.Card;
import cards.NumberCard;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Objects;

public class Player implements People{
    
    private int id;
    private String name;
    private String lastName;
    private String Address;
    private LocalDate date;
    private LinkedList<Card> cards;
    
    public Player(){
        System.out.println("Constructor");
    }

    public Player(int id, String name, String lastName, String Address, LocalDate date) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.Address = Address;
        this.date = date;
        this.cards = new LinkedList<>();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getAdress() {
        return this.Address;
    }

    @Override
    public LinkedList<Card> getCards() {
        return this.cards;
    }

    @Override
    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public boolean hasCards() {
        return  this.cards.size()> 0 ? true : false;
    }

    @Override
    public int cardNumber() {
        return this.cards.size();
    }
    @Override
    public Card getOneCard(){
        return this.cards.getLast();
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setAddress(String address) {
        this.Address = address;
    }

    @Override
    public void setCards(LinkedList<Card> cards) {
        this.cards = cards;
    }
    @Override
    public void setCard(Card card){
        this.cards.add(card);
    }
    @Override
    public void setDate(LocalDate date){
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.lastName);
        hash = 67 * hash + Objects.hashCode(this.Address);
        hash = 67 * hash + Objects.hashCode(this.date);
        hash = 67 * hash + Objects.hashCode(this.cards);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.Address, other.Address)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.cards, other.cards)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", name=" + name + ", lastName=" + lastName + ", Address=" + Address + ", date=" + date + ", cards=" + cards + '}';
    } 
}
