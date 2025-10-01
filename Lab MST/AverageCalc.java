import java.util.*;

class AverageCalc {

    public static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while(true){

            if(sc.hasNextInt()){
                int x   = sc.nextInt();
                numbers.add(x);
            }
            else{
                String inp = sc.nextLine();
                if (inp.equals("done")) {
                    break;
                }else{
                    System.out.println("Invalid input");
                
                }
            }

        }

        int sum = 0;
        for(int num : numbers){
            sum += num;
        }
        
        try{
            float avg = (float)sum/numbers.size();
            System.out.println(avg);
        }
        catch(ArithmeticException e){
            System.out.println("Invalid input");
        }finally{
            sc.close();
        }
    }
}

