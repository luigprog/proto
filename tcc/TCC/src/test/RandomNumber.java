package test;

public class RandomNumber {

    public static void main(String[] args) {
        while(true){
            int i = (int) ((int) 1 + (Math.random() * 2));    
            System.out.println(i);
        }
    }
    
}
