import java.util.Scanner;

public class Kopich_Final_Class {
    //variables
    String yourClass;
    int hitDice;
    int[]savingThrowProf={0,0,0,0,0,0};
    int level;
    int spellLevel;




    public Kopich_Final_Class(){
        this.yourClass="no class";
        this.hitDice=20;
        this.level=0;
        for(int i=0;i<6;i++){
        this.savingThrowProf[i]=0;
        }

    }
    public Kopich_Final_Class(String yourClass, int level){
        this.yourClass=yourClass;
        this.level=level;
        

        

    }
    public void getSavingThrowProficiencies(){
        switch(yourClass){
            case "Fighter":
            this.savingThrowProf[0]=1;
            this.savingThrowProf[2]=1;

            break;
        }

    }
    public int getHitDice(){
        switch(this.yourClass){
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
    public int getHealth(int ConModifier){
        int health=0;
        if(this.level<1){
            health=1;//minimum 1 health
        }
        else{
            health=this.hitDice+ConModifier; //at level 1 you get your full hit dice+con as health
            for (int i=1;i<level;i++){//subsequent levels are 1/2 your hit dice rounded up+con
                health+=((hitDice/2)+1+ConModifier);
            }
        }


        return hitDice;

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
}
