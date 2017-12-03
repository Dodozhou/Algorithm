package generic;

public class GenericMethod {
    public static <T> boolean contains(T[] arr,T x){
        for(T val:arr){
            if(x.equals(val))
                return true;
        }
        return false;
    }

}
