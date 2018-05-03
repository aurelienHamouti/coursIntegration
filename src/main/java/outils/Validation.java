package outils;


public class Validation
{
    public Validation() {}


    public static boolean isIntValid(String paramString)
    {
        try
        {
            Integer.parseInt(paramString); } catch (NumberFormatException localNumberFormatException) { return false; }
        return true;
    }

    public static boolean isDoubleValid(String paramString) {
        try {
            Double.parseDouble(paramString); } catch (NumberFormatException localNumberFormatException) { return false; }
        return true;
    }
}