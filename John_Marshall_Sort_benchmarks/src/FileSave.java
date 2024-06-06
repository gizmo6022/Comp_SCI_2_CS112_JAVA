import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

//saves test results to a txt file

public class FileSave {
    public static void saveResults(String fileName, String SortType, double[] timeArray, int ArraySize, int IntegerSize,
                                   int numberOfPasses){

        //timestamp for file Name
        String stamp = new SimpleDateFormat("_MM_dd_yy_HH_mm_ss").format(new java.util.Date());

        try {
            //create File
            java.io.File file = new File(fileName +"_"+ SortType +"_"+ stamp + ".csv");
            java.io.PrintWriter pw = new PrintWriter(file);

            //print test information
            pw.println("Integer Size: " + IntegerSize + ",");
            pw.println("Array Size: "+ ArraySize + ",");
            pw.println("Number Of Passes: "+ numberOfPasses + ",");

            int count = 0;

            while (count < timeArray.length){
                pw.println(timeArray[count] + ",");
                count++;
            }

            pw.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }//end catch
    }//End saveResults
}
