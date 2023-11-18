public class MyGenereteId {
    private static long counter = 0;
    public static long geneteId(){
        return ++counter;
    }
}
