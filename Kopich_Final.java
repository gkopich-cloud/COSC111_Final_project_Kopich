/**
 * @author Greg Kopich
 * @version fall 2025
 * this program will make a dnd character from the information
 * a user enters, then put that information on a character sheet
 * 
 * @version PHASE 1 has fully completed(name,level,background), mostly completed(stats,race),partially completed(finish), and has not started(class,spells)
 * @version PHASE 2 has fully completed(name,level,background), mostly completed(stats,race,class,finish), and have not started on (spells)
 * race just has an issue with class creation, stats needs an optional addition, class just needs to ask for an inventory, and finish needs to edit all that in
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;
import javax.imageio.ImageIO;
//testing push
//test 2 electrig boolgaloo
public class Kopich_Final {
    static Kopich_Final_Class selectedClass=new Kopich_Final_Class();

    public static String chooseName(){
        String name;
        Scanner kb=new Scanner(System.in);
        System.out.println("What would you like to name your character?: ");

        name=kb.nextLine();
        return name;
    }
public static int chooseLevel(String name){
        int level;
        Scanner kb=new Scanner(System.in);
        System.out.println("What level will "+name+" be?: ");

        level=kb.nextInt();
        return level;
}
public static int random6(){
    int rand=20;
    while(rand > 6||rand==0){
        rand=((int)(Math.random()*10));
        //System.out.println((Math.random()*10));
    }
    return rand;
}
public static int[] chooseStats(){
System.out.println("Now, how would you like to get your characters stats?");
        System.out.println("1.Roll 4d6 drop the lowest");
        System.out.println("2.Roll 3d6");
        System.out.println("3.Standard array");
        System.out.println("4.Point buy(not implimented)");
        Scanner kb=new Scanner(System.in);
        int choice=kb.nextInt();
        int[] returnedStats={0,0,0,0,0,0};
        int[] stats={15,14,13,12,10,8};
        int[] fourRolls=new int[4];
        int[] threeRolls=new int[3];
        switch (choice){
            //4d6
        case 1:
        
        stats[0]=0;//placeholder
        for (int j=0;j<6;j++){
        for (int i=0;i<4;i++){
            fourRolls[i]=random6();
            //System.out.println(random6());
        }
        //sort fourRolls
        int temp=0;
        for(int i=0;i<3;i++){
            for(int k=i;k<3;k++){
                if(fourRolls[k]>fourRolls[k+1]){
                    temp=fourRolls[k];
                    fourRolls[k]=fourRolls[k+1];
                    fourRolls[k+1]=temp;
                }
            }
        }
        
        stats[j]=(fourRolls[1]+fourRolls[2]+fourRolls[3]);
    }
        break;

        case 2:
        stats[0]=0;//placeholder
        for(int j=0;j<6;j++){
        for (int i=0;i<3;i++){
            threeRolls[i]=random6();
            //System.out.println(random6());
        }
        stats[j]=threeRolls[0]+threeRolls[1]+threeRolls[2];

    }

        break;

        case 3:
        //default case, no code needed
        break;
        case 4:
        stats[0]=0;//placeholder

        break;
        }
        
        String[] statNames={"Strength","Dexterity","Constitution","Intelligence","Wisdom","Charisma"};
        //set storage variable
        boolean selectingValues=true;
        while(selectingValues){
            
        
        for(int i=0;i<6;i++){
            //display stats remaining
            System.out.print("Your stats are: ");
                for(int k=0;k<6;k++){
                System.out.print(stats[k]+" ");
                }

        System.out.println("");
        System.out.println("Which value would you like to put for "+statNames[i]+"?: ");
        //search array
        int key=kb.nextInt();
        boolean foundStat=false;
        int foundJ=0;
        for (int j=0;j<6;j++){
            //System.out.println("key is "+key+", j is "+j+", and stats[j] is "+stats[j]);
            if(key==stats[j]){
                foundStat=true;
                foundJ=j;//so we can find where in the search our value is
                break;
            }
        }
        if (foundStat==false){
            System.out.println("You don't have that value, try again.");
            i-=1;
            //error, try again
        }
        else{
            
            returnedStats[i]=stats[foundJ];
            System.out.println("Your "+ statNames[i]+" is now "+returnedStats[i]);
            stats[foundJ]=0;
            
        }
    }
    selectingValues=false;
        }

    
return returnedStats;


}
public static void choseRace(){
    Scanner kb=new Scanner(System.in);
    
    //Kopich_Final_Race KopichRaceConstructor=Kopich_Final_Race("Human","None",temp={1,1,1,1,1,1},"abilities",30);
    System.out.println("What race would you like to pick?: ");
    String[]racesList={"Human","Elf","half elf","Half orc","Halfling","Dwarf","Gnome","Tiefling"};
    
    for(int i=0;i<racesList.length;i++){
        System.out.println(i+1+". "+racesList[i]);
    }
    int choice=kb.nextInt();
    int[]raceBonus={0,0,0,0,0,0};
    String[] raceFeatures=new String[10];
    switch(choice){
        case 1:
        for(int i=0;i<6;i++){
            raceBonus[i]=1;
        }
            
            raceFeatures[0]="Languages: You know common and 1 other language.";
            Kopich_Final_Race human= new Kopich_Final_Race("Human","none",raceBonus, raceFeatures,30);
            human.describeRace();
        
        break;
        case 2:
        
            raceBonus[1]=2;
        
            raceFeatures[0]="Darkvision: You can see in the dark up to 60ft.";
            raceFeatures[1]="Fey Ancestry. You have advantage on saving throws against being charmed, and magic can't put you to sleep.";
            raceFeatures[2]="Trance: You only need 4 hours of rest to gain the benifits of a long rest.";
            raceFeatures[3]="Keen Senses. You have proficiency in the Perception skill.";
            raceFeatures[4]="Languages. You know Common and Elven.";
            Kopich_Final_Race elf= new Kopich_Final_Race("Elf","none",raceBonus, raceFeatures,30);
            //ask
            elf.setSubrace();
            elf.describeRace();
        break;
        case 3:
        raceBonus[5]=2;//half elf
        //half elves get to add 2 +1 bonuses to stats of their chooseing
        for (int j=0;j<2;j++){
        System.out.println("("+j+"/2) Choose an ability to gain a +1 bonus in");
        String[] statNames={"Strength","Dexterity","Constitution","Intelligence","Wisdom"};
        for(int i=0;i<5;i++){
            System.out.print(i+1+"."+ statNames[i]+" ");
        }
        int input=kb.nextInt();
        if(raceBonus[input]==0){
        raceBonus[input-1]=1;
        System.out.println(statNames[input-1]+" has increased");
        }
        else{
            System.out.println("Please chose a different stat");
            j--;
        }
    }
        
            raceFeatures[0]="Darkvision: You can see in the dark up to 60ft.";
            raceFeatures[1]="Fey Ancestry. You have advantage on saving throws against being charmed, and magic can't put you to sleep.";
            raceFeatures[2]="Trance: You only need 4 hours of rest to gain the benifits of a long rest.";
            raceFeatures[3]="Skill Versatillity:You gain proficiency in two additional skills.";
            raceFeatures[4]="Languages. You know Common, Elven, and 1 additional language";
            Kopich_Final_Race halfElf= new Kopich_Final_Race("Half Elf","none",raceBonus, raceFeatures,30);
            halfElf.setSubrace();
            halfElf.describeRace();
        break;
        case 4://half orc
        raceBonus[0]=2;
        raceBonus[2]=1;
            raceFeatures[0]="Darkvision: You can see in the dark up to 60ft.";
            raceFeatures[1]="Menacing. You gain proficiency in the Intimidation skill.";
            raceFeatures[2]="Relentless Endurance. When you are reduced to 0 hit points but not killed outright, you can drop to 1 hit point instead. You can't use this feature again until you finish a long rest.";
            raceFeatures[3]="Savage Attacks. When you score a critical hit with a melee weapon attack, you can roll one of the weapon's damage dice one additional time and add it to the extra damage of the critical hit.";
            raceFeatures[4]="Languages. You know Common and Orc.";
            Kopich_Final_Race halfOrc= new Kopich_Final_Race("Half Orc","none",raceBonus, raceFeatures,30);
            halfOrc.setSubrace();
            halfOrc.describeRace();
        break;
        case 5://halfling
        raceBonus[1]=2;
        
            raceFeatures[0]="Short: You have a base movement speed of 0.";
            raceFeatures[1]="Lucky. When you roll a 1 on an attack roll, ability check, or saving throw, you can reroll the die. You must use the new result, even if it is a 1.";
            raceFeatures[2]="Brave. You have advantage on saving throws against being frightened.";
            raceFeatures[3]="Nimble. You can move through the space of any creature that is of a size larger than yours.";
            raceFeatures[4]="Languages. You know Common and Halfling.";
            Kopich_Final_Race halfling= new Kopich_Final_Race("Half Elf","none",raceBonus, raceFeatures,30);
            halfling.setSubrace();
            halfling.describeRace();
        break;
    
    case 6:
        raceBonus[2]=2;//dwarf
        
            raceFeatures[0]="Darkvision: You can see in the dark up to 60ft.";
            raceFeatures[1]="Dwarven Resilience. You have advantage on saving throws against poison, and you have resistance against poison damage.";
            raceFeatures[2]="Dwarven Combat Training. You have proficiency with the battleaxe, handaxe, light hammer, and warhammer.";
            raceFeatures[3]="Stonecunning: You have expertise in history checks related to the origin of stoneworks.";
            raceFeatures[4]="Short. You have a base movement speed of 25 feet.";
            raceFeatures[5]="Languages. You know Common and Dwarvish.";
            Kopich_Final_Race dwarf= new Kopich_Final_Race("Dwarf","none",raceBonus, raceFeatures,25);
            dwarf.setSubrace();
            dwarf.describeRace();
        break;
    case 7://gnome
        raceBonus[3]=2;
        
            raceFeatures[0]="Darkvision: You can see in the dark up to 60ft.";
            raceFeatures[1]="Short. You have a base movement speed of 25 feet.";
            raceFeatures[2]="Gnome Cunning. You have advantage on all Intelligence, Wisdom, and Charisma saves against magic.";
            raceFeatures[4]="Languages. You know Common and Gnomish.";
            Kopich_Final_Race gnome= new Kopich_Final_Race("Gnome","none",raceBonus, raceFeatures,30);
            gnome.setSubrace();
            gnome.describeRace();
        break;   
        case 8://tiefling
        raceBonus[5]=2;
        raceBonus[3]=1;
        //Apparently, in the 2014 phb, tieflings don't have subraces
        
            raceFeatures[0]="Darkvision: You can see in the dark up to 60ft.";
            raceFeatures[1]="Hellish Resistance. You have resistance to fire damage.";
            raceFeatures[4]="Languages. You know Common and Infernal.";
            Kopich_Final_Race tiefling= new Kopich_Final_Race("Tiefling","none",raceBonus, raceFeatures,30);
            tiefling.setSubrace();
            tiefling.describeRace();
        break; 
    }
}
public static String chooseClass(int level){
    Scanner kb=new Scanner(System.in);
    System.out.println("What class would you like to make your character?:");//multiclassing not available in this version, where we would spread levels between classes
    String[] classesList={"Barbarian", "Bard" ,"Cleric" ,"Druid" ,"Fighter" ,"Monk", "Paladin" ,"Ranger", "Rogue", "Sorcerer", "Warlock" , "Wizard." };
    String yourClass="none";
    //int hitDice=8;
    int[]savingThrowProf={0,0,0,0,0,0};
    String[] classProficiencyList=new String[18];
        String[] proficienciesList={"acrobatics","animalHandling","arcana","athletics","deception","history","insight","intimidation","investigation","medicine","nature","perception","performance","persuasion","religion","sleight","stealth","survival"};

    double spellProgression;//traks what spell

    for (int i=0;i<classesList.length;i++){
       // System.out.println(i+1+": "+classesList[i]);
       //would show all classes, but for times sake, we will only have 2 functional
    }
    System.out.println("1: Fighter");
    System.out.println("2: Wizard");
    int choice=kb.nextInt();
    switch(choice){
        case 1:
            yourClass=classesList[4];//string fighter
            selectedClass.setClass(yourClass);

            System.out.println(selectedClass.getYourClass());
            //hitDice=10;
            //spellProgression=0;
            //classProficiencyList[0]="test";//do in for loop
            //savingThrowProf[0]=1;
            //savingThrowProf[2]=1;//maybe assign in class?
            break;
        case 2:
            yourClass=classesList[11];//string wizard
            //hitDice=6;
            break;
    }
    //class class(yourClass,level)
    //class methods
    //ask what proficiencies from list
    //set health
    //get spell level(for spell list)
    return yourClass;
}
public static String chooseBackground(){
    System.out.println("What background will your character be?: ");
    Scanner kb=new Scanner(System.in);
    String[] backgrounds={"Acolyte","Charlatan","Criminal","Entertainer","Folk Hero","Guild Artisan","Hermit","Noble","Outlander","Sage","Sailor","Soldier", "Urchin"};
    
    for(int i=0;i<backgrounds.length;i++){
        System.out.println(i+1+": "+backgrounds[i]);
    }
    
    int choice=kb.nextInt();
    
        String background=backgrounds[choice-1];

        return background;

    
}
public static String[] BackgroundProficiencyGetter(String background){
    String[] backgrounds={"Acolyte","Charlatan","Criminal","Entertainer","Folk Hero","Guild Artisan","Hermit","Noble","Outlander","Sage","Sailor","Soldier", "Urchin"};
    String[] proficienciesList={"acrobatics","animalHandling","arcana","athletics","deception","history","insight","intimidation","investigation","medicine","nature","perception","performance","persuasion","religion","sleight","stealth","survival"};
    int[] proficiencyBackground=new int[18];//will give a 1 if proficient, 0 if not. this will be based on background
    int choice=0;
    for(int i=0;i<backgrounds.length;i++){
        if(backgrounds[i].equals(background)){
            choice=i;
        }
    }
    switch(choice){
        case 1:
        proficiencyBackground[14]=1;
        proficiencyBackground[6]=1;
        break;
        case 2:
        proficiencyBackground[4]=1;
        proficiencyBackground[15]=1;
        break;
        case 3:
        proficiencyBackground[4]=1;
        proficiencyBackground[16]=1;
        break;
        case 4:
        proficiencyBackground[0]=1;
        proficiencyBackground[12]=1;
        break;
        case 5:
        proficiencyBackground[1]=1;
        proficiencyBackground[17]=1;
        break;
        case 6:
        proficiencyBackground[6]=1;
        proficiencyBackground[13]=1;
        break;
        case 7:
        proficiencyBackground[9]=1;
        proficiencyBackground[14]=1;
        break;
        case 8:
        proficiencyBackground[5]=1;
        proficiencyBackground[13]=1;
        break;
        case 9:
        proficiencyBackground[3]=1;
        proficiencyBackground[17]=1;
        break;
        case 10:
        proficiencyBackground[2]=1;
        proficiencyBackground[5]=1;
        break;
        case 11:
        proficiencyBackground[3]=1;
        proficiencyBackground[11]=1;
        break;
        case 12:
        proficiencyBackground[3]=1;
        proficiencyBackground[7]=1;
        break;
        case 13:
        proficiencyBackground[15]=1;
        proficiencyBackground[16]=1;
        break;
        
}
System.out.print("As a "+background+" you gain proficiency in the following: ");
        for(int i=0;i<proficiencyBackground.length;i++){
        
        if (proficiencyBackground[i]==1){
            System.out.print(proficienciesList[i]+" ");
        }
    }
    System.out.println("");
    return proficienciesList;
        

}

public static void printFile(String name,int level, String yourClass, String background,int[] stats){
    //edits a png with all our information
    try{
        File input=new File("charactersheet.png");
        BufferedImage image=ImageIO.read(input);

        //getting proficiency bonus from level
        int profBonus=2;
        if(level>4){
            profBonus=3;
            if(level>8){
                profBonus=4;
                if(level>12){
                    profBonus=5;
                    if(level>16){
                        profBonus=6;
                    }
                }
            }
        }
        String positiveSign="";

        //editing options like size,color, and font
        Graphics2D g2d=image.createGraphics();
        g2d.setFont(new Font("Arial",Font.PLAIN,40));
        g2d.setColor(Color.BLACK);

        //editing the file
        g2d.drawString(name,160,210);
        g2d.drawString(""+level+" "+yourClass,750,170);
        g2d.drawString(""+background+" ",950,170);
        g2d.drawString("+"+profBonus,280,500);
        //drawing stats and caculating modifier
        double tempMod;
        int[] mods={0,0,0,0,0,0};
        for(int i=0;i<6;i++){
            g2d.drawString(""+stats[i],140,(550+200*i));
            tempMod=(stats[i]-10)/2;
            mods[i]=(int)tempMod;
            if(mods[i]>=0){
                positiveSign="+";
            }
            else{
                positiveSign="";
            }
            g2d.drawString(""+positiveSign+mods[i],140,(470+200*i));


        }

        //more code will go here

        //putting new file as output
        g2d.dispose();
        File output=new File("completed_charactersheet.png");
        ImageIO.write(image,"png",output);
        System.out.print("Your character was successfully made.");

    }
    catch(IOException e){
        System.out.println("Error: "+e.getMessage());
        
    }
}
    public static void main (String[] args){
        //variables
        Scanner kb=new Scanner(System.in);
        //public String name;
        //int level;
        int armorClass;
        int level=0;
        int health;
        int initiative;
        int profBonus;
        boolean inProgress=true;
        String name="default";
        String yourClass="no class";
        String background="no bakcgorund";
        int[] stats={0,0,0,0,0,0};
        //Kopich_Final_Class selectedClass=new Kopich_Final_Class();



        //main menu, organizaed to be able to work in any order or edit previous parts
        //and for me to test each section individually

        System.out.println("Welcome to Greg's DnD character creator!");
        while (inProgress==true){
            System.out.println("What part would you like to edit?: ");
            System.out.println("1. Name");
            System.out.println("2. Level");
            System.out.println("3. Stats");
            System.out.println("4. Race");//mostly finished
            System.out.println("5. Class");//not started
            System.out.println("6. Background");
            System.out.println("7. Spells");//not started
            System.out.println("8. Finish");//not complete
            int choice=kb.nextInt();
            switch(choice){

                case 1:
                name=chooseName();
                break;
                case 2:
                level=chooseLevel(name);
                break;
                case 3:
                stats=chooseStats();
                break;
                case 4:
                choseRace();
                break;
                case 5:
                yourClass=chooseClass(level);
                break;
                case 6:
                background=chooseBackground();//brokern into 2 parts so i could return string background and string[] proficiencies
                String[] backgroundProficiencies= BackgroundProficiencyGetter(background);
                break;
                case 8:
                printFile(name,level, selectedClass.getYourClass(),background,stats);//we will eventaully bring most data through here, but only these are implemented for demonstration purposes
                inProgress=false;
                break; 
            }
        }
        //String name=chooseName();
        
        //chooseStats();



        kb.close();
    }
    
}
