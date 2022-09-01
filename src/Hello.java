import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;

public class Hello {

    public static void main(String[] args)  {
        String sDate1="20130720";
        System.out.println(transformDateFormat(Arrays.asList("2010/02/20")));

    }
    public static List<String> transformDateFormat(List<String> dates) {


        List<Date> validDates = new ArrayList<>();

        List<String> validDatesString = new ArrayList<>();

        for(String d:dates){

            if(!d.contains("/")){
                continue;
            }

            System.out.println(d.substring(0,d.indexOf("/")).length());
            if((d.substring(0,d.indexOf("/")).length()!=4)){
                continue;
            }

            Date date1= null;
            try {

                date1 = new SimpleDateFormat("YYYY/MM/DD").parse(d);
            }catch (Exception e){
                continue;
            }
            validDates.add(date1);

        }

        for(String d:dates){


            if((d.substring(0,d.indexOf("/")).length()!=2)){
                continue;
            }

            Date date1= null;
            try {
                date1 = new SimpleDateFormat("DD/MM/YYYY").parse(d);
            }catch (Exception e){
                continue;
            }
            validDates.add(date1);
        }

        for(String d:dates){

            if(!d.contains("-")){
                continue;
            }

            Date date1= null;
            try {
                date1 = new SimpleDateFormat("MM-DD-YYYY").parse(d);
            }catch (Exception e){
                continue;
            }

            validDates.add(date1);
        }

        SimpleDateFormat formatter = new SimpleDateFormat("YYYYMMDD");

        for(Date f : validDates) {
            String format = formatter.format(f);
            validDatesString.add(format);
        }

        return validDatesString;


    }

    public static boolean isValid(String df, String dateStr) {
        DateFormat sdf = new SimpleDateFormat(df);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
