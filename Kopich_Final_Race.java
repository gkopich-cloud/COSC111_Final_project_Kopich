//@version fall 2025
//@author Greg Kopich
//this class file is for information related to a characers race
import java.util.Scanner;

public class Kopich_Final_Race {
    String race;
    String subrace;
    int[] raceBonus;//bonus that will be added to the 6 core stats(Strength, Dexterity,etc...)
    String[] raceFeatures=new String[20];//additional abilities related to race
    int speed;//movement speed
    public Kopich_Final_Race(){
        //initialization
        this.race="none";
        this.subrace="subrace";
        //this.raceBonus=[0,0,0,0,0,0];
        this.raceFeatures=new String[20];
        this.speed=5;
    }
    public Kopich_Final_Race(String race,String subrace,int[] raceBonus, String[] raceFeatures,int speed){
        //initialization 2: electric boogaloo
        this.race=race;
        this.subrace=subrace;
        this.raceBonus=raceBonus;
        this.raceFeatures=raceFeatures;
        this.speed=speed;
        //defining object
    }
    public void selectRace(String race,String subrace,int[] raceBonus, String[] raceFeatures,int speed){
        //initialization 2: electric boogaloo
        this.race=race;
        this.subrace=subrace;
        this.raceBonus=raceBonus;
        this.raceFeatures=raceFeatures;
        this.speed=speed;
        //defining object
    }
    public void addStats(){
        //this will get the appropriate stats from race to add to our total

    }
    public void setSubrace(){
        //this is a large list of checks to edit non repeating data
        //not to be confused with the equally large list of similar data
        //this one is for the subrace only
        Scanner kb=new Scanner(System.in);
        System.out.println(this.subrace);
        if ("Human".equals(this.subrace)||"Half Elf".equals(this.subrace)||"Half Orc".equals(this.subrace)||"Tiefling".equals(this.subrace)){
            System.out.println("You do not have a subrace");

        }
        else{
    System.out.println("Chose a subrace: ");
    String subrace;
    
        if("Elf".equals(race)){
            
            System.out.println("1. Dark elf");
            System.out.println("2. High elf");
            System.out.println("3. Wood elf");
            int choice=kb.nextInt();
            switch(choice){
                default://taken from ai
                case 1:
                this.subrace="Dark elf";
                this.raceBonus[5]=1;
                raceFeatures[5]="Superion Darkvision: You can see in the dark up to 120ft.";
                raceFeatures[6]="Sunlight Sensitivity. You have disadvantage on attack rolls and Wisdom (Perception) checks that rely on sight when you, the target of the attack, or whatever you are trying to perceive is in direct sunlight.";
                raceFeatures[7]="Drow Magic. You know the Dancing Lights cantrip. When you reach 3rd level, you can cast the Faerie Fire spell once with this trait and regain the ability to do so when you finish a long rest. When you reach 5th level, you can cast the Darkness spell once and regain the ability to do so when you finish a long rest. Charisma is your spellcasting ability for these spells.";
                raceFeatures[8]="Drow Weapon Training. You have proficiency with rapiers, shortswords, and hand crossbows.";
                break;
                case 2:
                this.subrace="High elf";
                this.raceBonus[3]=1;
                raceFeatures[5]="Cantrip. You know one cantrip of your choice from the Wizard spell list. Intelligence is your spellcasting ability for it.";
                raceFeatures[6]="Elf Weapon Training. You have proficiency with the longsword, shortsword, shortbow, and longbow.";
                raceFeatures[7]="Extra Language. You can read, speak, and write one additional language of your choice.";
                
                break;
                case 3:
                this.subrace="Wood elf";
                this.raceBonus[4]=1;
                raceFeatures[5]="Fleet of Foot. Your base walking speed increases to 35 feet.";
                raceFeatures[6]="Elf Weapon Training. You have proficiency with the longsword, shortsword, shortbow, and longbow.";
                raceFeatures[7]="Mask of the Wild. You can attempt to hide even when you are only lightly obscured by foliage, heavy rain, falling snow, mist, and other natural phenomena.";
                this.speed=35;
                break;
            }
        }
        else if("Gnome".equals(race)){
            
            System.out.println("1. Forest gnome");
            System.out.println("2. Rock gnome");
            int choice=kb.nextInt();
            switch(choice){
                default://taken from ai
                case 1:
                this.subrace="Forest";
                this.raceBonus[1]=1;
                raceFeatures[5]="Natural Illusionist. You know the Minor Illusion cantrip. Intelligence is your spellcasting modifier for it.";
                raceFeatures[6]="Speak with Small Beasts. Through sound and gestures, you may communicate simple ideas with Small or smaller beasts.";
                break;
                case 2:
                this.subrace="Rock";
                this.raceBonus[2]=1;
                raceFeatures[5]="Artificer's Lore. Whenever you make an Intelligence (History) check related to magical, alchemical, or technological items, you can add twice your proficiency bonus instead of any other proficiency bonus that may apply.";
                raceFeatures[6]="Tinker. You have proficiency with artisan tools (tinker's tools). Using those tools, you can spend 1 hour and 10 gp worth of materials to construct a Tiny clockwork device (AC 5, 1 hp). The device ceases to function after 24 hours";     
                break;
                case 3:
                
            }
        }
        else if("Dwarf".equals(race)){
            
            System.out.println("1. Hill dwarf");
            System.out.println("2. Mountain dwarf");
            int choice=kb.nextInt();
            switch(choice){
                default://taken from ai
                case 1:
                this.subrace="Hill dwarf";
                this.raceBonus[4]=1;
                //raceFeatures[5]="Ability Score Increase. Your Wisdom score increases by 1.";
                raceFeatures[6]="Dwarven Toughness. Your hit point maximum increases by 1, and it increases by 1 every time you gain a level.";
                 
                break;
                case 2:
                this.subrace="Mountain dwarf";
                this.raceBonus[0]=2;
                //raceFeatures[5]="Ability Score Increase. Your Strength score increases by 2.";
                raceFeatures[6]="Dwarven Armor Training. You have proficiency with light and medium armor.";   
                              
                break;
                
            }
        }
        
    }
        //!add
    }
    public void describeRace(){
        String[] statNames={"Strength","Dexterity","Constitution","Intelligence","Wisdom","Charisma"};
        System.out.print("You are a");
        if(this.subrace!="none"){
            System.out.print(" " +this.subrace);
        }
        System.out.println(" "+this.race+".");
        System.out.print("You have a +2 bonus to the following: ");
        for(int i=0;i<6;i++){
            if (raceBonus[i]==2){
                System.out.print(statNames[i]+ " ");
            }
        }
        System.out.println("");
        System.out.print("You have a +1 bonus to the following: ");
        for(int i=0;i<6;i++){
            if (raceBonus[i]==1){
                System.out.print(statNames[i]+ " ");
            }
        }
        System.out.println("");
        System.out.println("Your movement speed is "+this.speed+" feet");
        System.out.println("Your race gives you the following traits: ");
        for(int i=0;i<raceFeatures.length;i++){
            if (raceFeatures[i]!=null){//makes it so nothing is printed if there is an empty spot in the list
            System.out.println(raceFeatures[i]);
            }
        }

    }
    public int getSpeed(){
        return speed;
    }
    public int[] getRaceBonus(){
        return this.raceBonus;
    }
    public String[] getRaceFeatures(){
        return raceFeatures;
    }
    
    public String getSubrace(){
        if (subrace=="subrace"||subrace=="none"){
            return race;
        }
        else{
            return subrace;
        }
    }
    
}
