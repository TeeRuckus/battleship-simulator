public class stringSplit
{
    public static void main(String []args)
    {
        String [] parts = new String[2];
        String number = "123.456";
        parts = number.split("\\.");
        System.out.println(parts[0]);
        System.out.println(parts[1]);

    }
}
