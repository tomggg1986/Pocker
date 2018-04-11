
package cards;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import people.People;


public class WinnerCollector implements BiConsumer<List<WinnerCollector>, People>{
    
    private Map<Integer,Long> winnerMap;
    private People player;
    private int result;
    
    public WinnerCollector(){
        this.winnerMap = new HashMap<>();       
        this.player = null;
    }
     public WinnerCollector(Map<Integer,Long> winnerMap, People people){
        this.winnerMap = winnerMap;
        this.player = people;
       //result = this.getResult();
    }
    public Map<Integer, Long> getWinnerMap() {
        return winnerMap;
    }

    public void setWinnerMap(Map<Integer, Long> winnerMap) {
        this.winnerMap = winnerMap;
    }
    public void sortCards(){
        Collections.sort(this.player.getCards(),(c1, c2) -> (int)c2.getValue() - (int) c1.getValue());
    }
    public List<Card> getCards(){
        return this.player.getCards();
    }
    public int getResult(){
        int result = 0;
        result = this.checkPoker();
        if(result != 0){
            return result;
        }else{
            return this.checkPair();
        }       
    }
    public People getPlayer(){
        return this.player;
    }
     private int checkPoker(){
         LinkedList<Card> cards = (LinkedList)this.player.getCards();
       int poker = 0;
       LinkedList<Card>inPlay = new LinkedList<>();
       int i = cards.size()-1;
       int start = i;
       int sum = 0;
       int color = 0;
       for(int j = i;j>=1;j--){
           if(poker <5){
               if((int)cards.get(j).getValue() ==(int) cards.get(j-1).getValue()+1){
                  poker++;
                  sum = sum +((int)cards.get(j).getValue() + (int) cards.get(j-1).getValue());
                  if(cards.get(j).getSuit().equals(cards.get(j-1).getSuit())){
                      color++;
                  }
               //   System.out.println(cards.get(j).getValue()+" "+cards.get(j-1).getValue()+"Poker "+poker+" "+" sum "+sum+" color "+color);
           }else{
               poker = 0;
               start = j-1;
               sum = 0;
               color = 0;
          }
          }else{
               System.out.println("Poker!!!!!!");
               break;
          }
       }
       int result =0;
       if(poker >=5){
           if(color>=5){
               result  = 10000 + sum;
           }else{
               result = 5000 + sum;
           }          
       }
       return result;
   }
   private int checkPair(){           
           LinkedList<Entry<Integer,Long>> listE = new LinkedList<>(this.winnerMap.entrySet());
           Collections.sort(listE, EntryCompare);      
//           System.out.println("After sort");
//           listE.forEach(l -> System.out.print(l+" "));
           int result = 0;
              Map.Entry<Integer,Long> entry = listE.pollFirst();
            if(entry.getValue().intValue() == 4){
                result = entry.getValue().intValue() * entry.getKey();
                result += listE.pollFirst().getKey();
                return result +8000;
            }
            if(entry.getValue().intValue() == 3){
                result = entry.getValue().intValue() * (entry.getKey() * 5);
                entry = listE.pollFirst();
                if(entry.getValue().intValue() == 2){
                    result += (entry.getValue().intValue() * (entry.getKey() * 10)) + 7000;
                }else{
                    result += entry.getKey() + listE.pollFirst().getKey() +4000;
                }
                return result;
            }
            if(entry.getValue().intValue() == 2){
                result = entry.getValue().intValue() *  (entry.getKey() * 10);
                entry = listE.pollFirst();
                if(entry.getValue().intValue() == 2){
                    result += entry.getValue().intValue() * (entry.getKey() * 10);
                    result += listE.pollFirst().getKey() + 3000;
                }else{
                    result += entry.getKey();
                    result += listE.pollFirst().getKey() + listE.pollFirst().getKey() + 2000;
                }
                return result;
            }
            if(entry.getValue().intValue() == 1){
                result = entry.getKey();
                for(int i = 0; i<4;i++){
                    result += listE.peekFirst().getKey();
                }
                return result + 1000;
            }
      return 0;
   }
   
     public Comparator<Map.Entry<Integer,Long>> EntryCompare = new Comparator<Map.Entry<Integer,Long>>(){      
        @Override
        public int compare(Map.Entry<Integer, Long> t, Map.Entry<Integer, Long> t1) {
            
            int returnValue =  t1.getValue().intValue() - t.getValue().intValue();
            if( returnValue == 0){
                returnValue = t1.getKey() - t.getKey();
            }
           return returnValue;
        }
     };

    @Override
    public void accept(List<WinnerCollector> winner, People player) {
        winner.add(new WinnerCollector(player.getCards()
                        .stream()
                        .collect(Collectors.groupingBy(c ->(int)c.getValue(), Collectors.counting())),player)
        );
      
    }
    @Override
    public String toString() {
        return player.getName()+" "+player.getLastName()+" " + "Cards: \n" 
                + winnerMap.entrySet().stream().map(w -> w.getValue().toString() 
                        + " = "+w.getKey().toString()).collect(Collectors.toList())+"\n" ;
    }
    
}
