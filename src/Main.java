import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    private static Scanner in = new Scanner(System.in);
    private static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args)
    {
        String cmd = "";
        String menuPrompt = "A - Add  D - Delete  P - Print  Q - Quit";
        boolean done = false;
        do
        {
            print();
            cmd = SafeInput.getRegExString(in,menuPrompt,"[AaDdPpQq]");
            cmd = cmd.toUpperCase();
            switch(cmd)
            {
                case "A":
                    add();
                    break;
                case "D":
                    delete();
                    break;
                case "P":
                    print();
                    break;
                case "Q":
                    quit();
                    break;
            }
        } while(!done);
    }

    /**
     * Add an item to the list (NOT insert)
     */
    private static void add()
    {
        String listItem = SafeInput.getNonZeroLenString(in,"Enter the new list item");
        list.add(listItem);
    }

    /**
     * Delete an item from the list (numbered list displayed)
     */
    private static void delete()
    {
        if(list.size() == 0)
        {
            System.out.println("\nNothing to delete\n");
        }
        else
        {
            int i = 1;
            for(String l : list)
            {
                System.out.println(l + "\t" + i);
                i++;
            }
            int target = SafeInput.getRangedInt(in,"Enter the number of the line to delete",1,list.size());
            target--;
            list.remove(target);
        }
    }

    /**
     * Print (display) the list
     */
    private static void print()
    {
        System.out.println();
        if(list.size() == 0)
            System.out.println("The list is currently empty.");
        else
        {
            for(String l : list)
                System.out.print(l + "\t");
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Quit the program (prompt for confirmation)
     */
    private static void quit()
    {
        boolean quitYN = SafeInput.getYNConfirm(in,"Are you sure you want to quit?");
        if(quitYN)
            System.exit(0);
    }
}