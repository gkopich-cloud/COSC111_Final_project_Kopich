//@author Greg Kopich
//@version fall 2025
//this class file will be for parts related to a character's class
//the name can be confusing as dnd classes are not java classes

import java.util.Arrays;
import java.util.Scanner;

public class Kopich_Final_Class {
    //variables
    String yourClass;
    int hitDice;
    int[]savingThrowProf={0,0,0,0,0,0};
    int level;
    int spellLevel;
    int[] classProficiencies=new int[18];
//    String[] availableSkills=new String[16];
    String[] chosenSkills=new String[4];
    String[] equipment=new String[20];





    public Kopich_Final_Class(){
        this.yourClass="no class";
        this.hitDice=20;
        this.level=0;
        for(int i=0;i<6;i++){
        this.savingThrowProf[i]=0;
        }
        for (int i=0;i<20;i++){
            this.equipment[i]="";
        }

    }
    public Kopich_Final_Class(String yourClass, int level){
        this.yourClass=yourClass;
        this.level=level;
        

        

    }
    public int[] getSavingThrowProficiencies(){
        //System.out.println(yourClass);
        switch(yourClass){
            default://taken from ai
            case "Fighter":
            this.savingThrowProf[0]=1;
            this.savingThrowProf[2]=1;

            break;
            case "Wizard":
                this.savingThrowProf[3]=1;
                this.savingThrowProf[4]=1;
               // System.out.println("DEBUGGING");
        }
        return savingThrowProf;
    }
    public int getHitDice(){
        switch(this.yourClass){
            default://taken from ai
            case "Fighter":
                this.hitDice=10;
                break;
            case "Wizard":
                this.hitDice=6;
                break;
        }
        this.level=level;

        return hitDice;

    }
    //calculates health of character
    public int getHealth(int ConModifier, int level){
        int health=0;
        if(level<1){
            health=1;//minimum 1 health
        }
        else{
            health=hitDice+ConModifier; //at level 1 you get your full hit dice+con as health
            for (int i=1;i<level;i++){//subsequent levels are 1/2 your hit dice rounded up+con
                health+=((hitDice/2)+1+ConModifier);
            }
        }


        return health;

    }
    
    public int getSpellProgression(){
        if(this.yourClass.equals("Wizard")||this.yourClass.equals("Bard")||this.yourClass.equals("Cleric")||this.yourClass.equals("Druid")||this.yourClass.equals("Sorcerer")){
            spellLevel=1*this.level;
        }
        else if(this.yourClass.equals("Paladin")||this.yourClass.equals("Ranger")){
            spellLevel=(int) (this.level*0.5);//half casters gain spell progression at half rate rounded down
        }
        else{
            spellLevel=0;//not all classes can cast spells
        }

    return spellLevel;
    }
    public String getYourClass(){
       // System.out.println("your class is"+yourClass);
        return this.yourClass;

    }
    public void setClass(String yourClasss){
        this.yourClass=yourClasss;
    }
    //ask proficiencies
    public void askProficiencies(int numberOfSkillProficiencies){
        String[] proficienciesList={"acrobatics","animalHandling","arcana","athletics","deception","history","insight","intimidation","investigation","medicine","nature","perception","performance","persuasion","religion","sleight","stealth","survival"};
        //int[] availableSkills=new int[16];
        //String[] selectedSkills=new String[4];
        Scanner kb=new Scanner(System.in);
        //int choice=42;
        //String[] classSkillsAsString=new String[16];
        
        System.out.println("Choose "+numberOfSkillProficiencies+" skills from the following list to be proficient in:");
        String[] usableArray=new String[18];
        switch(yourClass){
            default://taken from ai
            case "Fighter":
                String[] fighterSkills={"acrobatics","animalHandling","athletics","history","insight","intimidation","perception","survival"};
                for(int i=0;i<fighterSkills.length;i++){
                    usableArray[i]=fighterSkills[i];}
                break;
            case "Wizard":
                String[] wizardSkills={"arcana","history","insight","investigation","medicine","religion"};
                for(int i=0;i<wizardSkills.length;i++){
                    usableArray[i]=wizardSkills[i];}
                break;
        }
        //String[] chosenSkills= new String[4];
        for (int i=0;i<numberOfSkillProficiencies;i++){
            int count=0;
            for(int j=0;j<18;j++){
                //array aslist taken from ai fro the purpose of checking if string is in list
                if (Arrays.asList(usableArray).contains(proficienciesList[j])){
                    //this prevents us from printing what we have already selected
                    if(Arrays.asList(chosenSkills).contains(proficienciesList[j])==false){
                    System.out.println(count+1+". "+proficienciesList[j]);

                count+=1;
                    }
                    else{
                        count+=1;
                    }
            }
            
        }
        int temp=kb.nextInt();
        this.chosenSkills[i]=usableArray[temp-1];


    }
    //System.out.print("You have proficiency in the following: ");
    // for (int i=0;i<chosenSkills.length;i++){
    //     System.out.print(chosenSkills[i]+" ");
    // }
    // System.out.println("");
                
    }
    public String[] GetClassProficiencies(){
        //System.out.println(chosenSkills[0]);
        return this.chosenSkills;

    }
    public void askEquipment(){
        Scanner kb=new Scanner(System.in);
        int choice;
        for (int i=0;i<20;i++){
            equipment[i]="";
        }
        System.out.println("Choose one from the following:");
        switch(yourClass){
            default://taken from ai
            case "Fighter":
                System.out.println("Equipment 1/4");
                System.out.println("1. chain mail");
                System.out.println("2. leather armor and a longbow");
                choice=kb.nextInt();
                if(choice==1){
                    equipment[0]="chainmail";
                }
                else{
                    equipment[0]="leather armor";
                    equipment[1]="longbow";
                }

                System.out.println("Equipment 2/4");
                System.out.println("1. a longsword and shield");
                System.out.println("2. two shortswords");
                choice=kb.nextInt();
                if(choice==1){
                    equipment[2]="longsword";
                    equipment[3]="shield";
                }
                else{
                    equipment[2]="shortsword";
                    equipment[3]="shortsword";
                }
                System.out.println("Equipment 3/4");
                System.out.println("1. a light crossbow");
                System.out.println("2. two handaxes");
                choice=kb.nextInt();
                if(choice==1){
                    equipment[4]="lightCrossbow";
                    
                }
                else{
                    equipment[4]="handaxe";
                    equipment[5]="handaxe";
                }
                System.out.println("Equipment 4/4");
                System.out.println("1. a dungeoneer's pack");
                System.out.println("2. an explorer's pack");
                choice=kb.nextInt();
                if(choice==1){
                    equipment[6]="dungeoneer's pack";
                }
                else{
                    equipment[6]="explorer's pack";
                }


            break;
            case "Wizard":
                System.out.println("Equipment 1/3");
                System.out.println("1. a quarterstaff");
                System.out.println("2. a dagger");
                choice=kb.nextInt();
                if(choice==1){
                    equipment[0]="quarterstaff";
                }
                else{
                    equipment[0]="dagger";
                }
                 System.out.println("Equipment 2/3");
                System.out.println("1. a component pouch");
                System.out.println("2. an arcane focus");
                choice=kb.nextInt();
                if(choice==1){
                    equipment[1]="component pouch";
                }
                else{
                    equipment[1]="arcane focus";
                }
                 System.out.println("Equipment 3/3");
                System.out.println("1. a scholar's pack");
                System.out.println("2. an explorer's pack");
                choice=kb.nextInt();
                if(choice==1){
                    equipment[2]="scholar's pack";
                }
                else{
                    equipment[2]="explorer's pack";
                }
                equipment[3]="spellbook";

            break;
        }
        
    }
    public String[] getEquipment(){
        return equipment;
    }
}
