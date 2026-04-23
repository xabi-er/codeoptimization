/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dam.codeoptimization.fantasy;
import es.dam.codeoptimization.PlayerStats;

/**
 * THE CLASS YOU HAVE TO MODIFY
 * @author Your Name
 */
public class FantasyCalculator {

    // Method to calculate the points
    public static int calcP(PlayerStats s) {
        int total = 0; 
        int punts = 0;
        
        int minutes = s.minutes;
        int goals = s.goals;
        int assits = s.assists;
        boolean yellowCard = s.yellowCard;
        boolean redCard = s.redCard;
        int saves = s.saves;
        int goalsAgainst = s.goalsAgainst;
        char result = s.matchResult;
        String positionString = s.position;

        // --- GOALKEEPER LOGIC ---
        if (positionString.equals("PORTERO")) {
            if (minutes > 0 && minutes < 60) {
                total = total + 3;
            } else if (minutes >= 60) {
                total = total + 5;
            }

            for (int i = 0; i < goals; i++) {
                total = total + 5;
            }

            total = total + (assits * 6);

            // 1 point per save
            total = total + saves; 
            
            if (goalsAgainst == 0) {
                total = total + 5; 
            } else if (goalsAgainst == 1) {
                total = total + 3;
            } else if (goalsAgainst == 2) {
                total = total + 1;
            }

            if (yellowCard == true) total = total - 3; 
            if (redCard == true) total = total - 5;
            
            if (result == 'G') {
                total = total + 5;
            } else if (result == 'E') {
                total = total + 2;
            }

        // --- DEFENDER LOGIC ---
        } else if (positionString.equals("DEFENSA")) {
            if (minutes > 0 && minutes < 60) {
                total = total + 3;
            } else if (minutes >= 60) {
                total = total + 5;
            }

            for (int i = 0; i < goals; i++) {
                total = total + 5;
            }

            total = total + (assits * 6);

            if (goalsAgainst == 0) {
                total = total + 5; 
            } else if (goalsAgainst == 1) {
                total = total + 3;
            } else if (goalsAgainst == 2) {
                total = total + 1;
            }

            if (yellowCard == true) total = total - 3;
            if (redCard == true) total = total - 5;
            
            if (result == 'G') {
                total = total + 5;
            } else if (result == 'E') {
                total = total + 2;
            }

        // --- MIDFIELDER LOGIC ---
        } else if (positionString.equals("MEDIO")) {
            if (minutes > 0 && minutes < 60) {
                total = total + 3;
            } else if (minutes >= 60) {
                total = total + 5;
            }

            for (int i = 0; i < goals; i++) {
                total = total + 5;
            }

            total = total + (assits * 6);

            if (yellowCard == true) total = total - 3;
            if (redCard == true) total = total - 5;
            
            if (result == 'G') {
                total = total + 5;
            } else if (result == 'E') {
                total = total + 2;
            }

        // --- FORWARD LOGIC ---
        } else if (positionString.equals("DELANTERO")) {
            if (minutes > 0 && minutes < 60) {
                total = total + 3;
            } else if (minutes >= 60) {
                total = total + 5;
            }

            for (int i = 0; i < goals; i++) {
                total = total + 6;
            }

            total = total + (assits * 5);

            if (yellowCard == true) total = total - 3;
            if (redCard == true) total = total - 5;
            
            if (result == 'G') {
                total = total + 5;
            } else if (result == 'E') {
                total = total + 2;
            }
        }

        return total;
    }
}
// Commit Prueba