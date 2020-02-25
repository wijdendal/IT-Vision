
import Entities.Challenge;
import Entities.Event;
import Entities.Participant_com;
import Entities.post_challenge;
import Services.ServiceChallenge;
import Services.ServiceEvent;
import Services.ServiceParticipants_com;
import Services.Servicepost_ch;
import View.Launch;
import java.text.ParseException;
import  javafx.application.Application;
import View.Launch;
import entities.gclient;
import  static javafx.application.Application.launch;
import services.crudClient;
import services.cruduser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author user
 */
public class Programme3a9  {
   
    
    public static void main (String[]args) throws ParseException
    {
//gclient p1 = new gclient (2,"jurin","jeddey","inesgmailcom","azerty","ariana",752,"pic");        
//crudClient cu = new crudClient();
//        cu.ajouterPersonne(p1);
//        Participant_com pc = new Participant_com(4, 1, nomP, PrenomP, nomE, 0, type)
        ServiceParticipants_com SP = new ServiceParticipants_com();
        SP.afficherParticipant();
    }
    }

