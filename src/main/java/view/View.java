package view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Vitalii_Mamchur on 01.12.2019.
 */
public class View implements TextConstant {
//    Locale localeUS = Locale.US;
//    Locale localeUA = new Locale("ua", "UA");
//    public final ResourceBundle bundle =
//            ResourceBundle.getBundle(
//                    "messages", localeUS);
//                    //"messages_ua", localeUA);

    public void printMessage(String message) {
        System.out.println(message);
    }


    public String concatenationString(String... message){
        StringBuilder concatString = new StringBuilder();
        for(String v : message) {
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }

    //public void printBundleMessage() {
//        printMessage(bundle.getString(INITIALIZATION_TEXT));
//    }

}
