package controller;

import model.GettingPowerable;
import model.Model;
import model.MovingAppliance;
import model.NonMovingAppliance;
import view.TextConstant;
import view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 * Created by Vitalii_Mamchur on 01.12.2019.
 */
public class Controller {
    Model model = new Model();
    View view = new View();

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        ArrayList<GettingPowerable> DBArray = new ArrayList<GettingPowerable>();

        initialization(sc);

        fillingOfDB(DBArray);

        sortByConsumptionPower(DBArray);

        search(0);

        view.printMessage(TextConstant.FINISH_OF_PROGRAM);


    }

    /*                                                                                                  *
     * In this method the program initializes start of the program. The user has to input the initialization key to continue
     * work with the program. In this case, the KEY is "1"
     * @param sc
     */
    public void initialization(Scanner sc) {
        view.printMessage(TextConstant.INITIALIZATION_TEXT);
        while (true) {
            if (sc.nextLine().equals(TextConstant.INITIALIZATION_KEY)) {
                System.out.println(TextConstant.SUCCESSFUL_INITIALIZATION);
                break;
            } else {
                System.out.println(TextConstant.WRONG_INITIALIZATION_INPUT);
            }
        }
    }

    /**
     * In this method the Array which play the role of "DataBase" is filling up by the elements of the enum
     * "MovingAppliance" and "NonMovingAppliance"
     * @param DBArray
     */
    public void fillingOfDB(ArrayList<GettingPowerable> DBArray) {
        DBArray.addAll(Arrays.asList(MovingAppliance.values()));
        DBArray.addAll(Arrays.asList(NonMovingAppliance.values()));
        view.printMessage(TextConstant.DB_FILLING_SUCCESS);
    }

    /**
     * In this method the program sends the DBArray as parameter to let it be sorted by the chosen algorithm
     * and then be printed on the screen
     * @param DBArray
     */
    public void sortByConsumptionPower(ArrayList<GettingPowerable> DBArray) {
        for (int i = DBArray.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                GettingPowerable enum1 =  DBArray.get(j);
                GettingPowerable enum2 =  DBArray.get(j + 1);

                if (enum1.getConsumptionPower() > enum2.getConsumptionPower()) {
                    GettingPowerable tmp = DBArray.get(j);
                    DBArray.set(j,DBArray.get(j + 1));
                    DBArray.set(j+1,tmp);
                }
            }
        }

        view.printMessage(TextConstant.ARRAY_LIST_IS_SORTED);

        for(GettingPowerable a : DBArray)
        {
            System.out.println(a);
        }
        System.out.println();
    }

    /**
     * In this method the program makes a search of element by the given parameter. To do this we create new ArrayList
     * to add there elements which have the necessary parameter. If there won't be no element that
     * suit to the condition. The program will print the messagem that no one appliance has that parameter
     * @param power
     */
    public void search(int power) {

        view.printMessage(TextConstant.SEARCH_ELEMENT);
        ArrayList<Enum> searchResult = new ArrayList<Enum>();
        
        for (MovingAppliance currentElement : MovingAppliance.values()) {
            if (currentElement.getConsumptionPower() == power) {
                searchResult.add(currentElement);
            }
        }

        for (NonMovingAppliance currentElement : NonMovingAppliance.values()) {
            if (currentElement.getConsumptionPower() == power) {
                searchResult.add(currentElement);
            }
        }
        if ((searchResult.isEmpty())) {
            view.printMessage(TextConstant.NO_APPLIANCE_FOUND);
        } else {
            printingResultsOfSearch(searchResult);
        }
        System.out.println();

    }

    /**
     * This method just print all element which is suitable to the given condition in the method above
     * @param searchResult
     */
    public void printingResultsOfSearch(ArrayList<Enum> searchResult) {
        for (int i = 0; i < searchResult.size(); i++) {
            view.printMessage(searchResult.get(i).toString());
        }
    }
}
