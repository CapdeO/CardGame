
package com.spicecap.cardgame;

import java.util.Random;


public class Card {

    public int attack;
    public int defense;
    public String type = "value";
    public boolean active = false;
    
    public void generateCard() {
        Random rnd = new Random();
        
        attack = (rnd.nextInt(100)+1);
        defense = (rnd.nextInt(100)+1);
        
        if (attack > 95 || defense > 95 ) {
            type = "King";
        }
        else if (attack > 80 || defense > 80 ) {
            type = "Mage";
        }
        else if (attack > 60 || defense > 60 ) {
            type = "Knight";
        }
        else if (attack > 40 || defense > 40 ) {
            type = "Archer";
        }
        else if (attack > 20 || defense > 20 ) {
            type = "Artilleryman";
        }
        else {
            type = "Soldier";
        }
    }
    
    //Método para mostrar tipo, ataque y defensa de una carta
    public void showCard(int n) {
        System.out.println(n + "(" + type + " Attack " + attack + " Defense " + defense + "), ");
    }
    
    //Método que genera todas las cartas del usuario
    public static void generateCards() {
        card1.generateCard();
        card2.generateCard();
        card3.generateCard();
        card4.generateCard();
        card5.generateCard();
    }
    
    //Método que genera todas las cartas del oponente
    public static void generateCardsOpponent() {
        card01.generateCard();
        card02.generateCard();
        card03.generateCard();
        card04.generateCard();
        card05.generateCard();
    }
    
    //Método para mostrar todas sus cartas al usuario
    public static void showCards() {
        card1.showCard(1);
        card2.showCard(2);
        card3.showCard(3);
        card4.showCard(4);
        card5.showCard(5);
    }
    
    //Método para mostrar todas sus cartas del oponente
    public static void showCards0() {
        card01.showCard(1);
        card02.showCard(2);
        card03.showCard(3);
        card04.showCard(4);
        card05.showCard(5);
    }
    
    //Método para resetear las cartas activas al final de una ronda
    public static void resetActives() {
        //Cartas usuario
        card1.active = false;
        card2.active = false;
        card3.active = false;
        card4.active = false;
        card5.active = false;
        //Cartas oponente
        card01.active = false;
        card02.active = false;
        card03.active = false;
        card04.active = false;
        card05.active = false;
    }
    
    //Instanciamos todas las cartas del usuario
    public static Card card1 = new Card();
    public static Card card2 = new Card();
    public static Card card3 = new Card();
    public static Card card4 = new Card();
    public static Card card5 = new Card();
    
    //Instanciamos todas las cartas del oponente
    public static Card card01 = new Card();
    public static Card card02 = new Card();
    public static Card card03 = new Card();
    public static Card card04 = new Card();
    public static Card card05 = new Card();
    
}
