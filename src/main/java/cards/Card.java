
package cards;


public interface Card extends Comparable<Card>{
   
    String getColor();
    String getSuit();
     <T> T getValue();
     static  void  displayCard(Card card){
         String color = card.getColor().equals("red") ? "\u001B[31m" : "\u001B[30m";
         StringBuilder cardView = new StringBuilder();
         cardView.append(color);
         cardView.append(card.getValue().toString());
         for(int i = 0;i<(15-card.getSuit().length());i++){
             cardView.append("-");
         }
         cardView.append(card.getSuit());
         cardView.append("\n");
         cardView.append(color);
         cardView.append("|");
         for(int i = 0;i<14;i++){
             cardView.append(" ");
         }
         cardView.append("|");
         cardView.append("\n");
         cardView.append(color);
         cardView.append("|");
         cardView.append(card.getColor());
         cardView.append("|");
         cardView.append("\n");
         cardView.append(color);
         cardView.append("|");
         for(int i = 0;i<14;i++){
             cardView.append(" ");
         }
         cardView.append("|");
         cardView.append("\n");
         cardView.append(color);
         cardView.append(card.getSuit());
         for(int i = 0;i<(15-card.getSuit().length());i++){
             cardView.append("-");
         }
         cardView.append(card.getValue().toString());
         System.out.println(cardView.toString());
     }
}
