// importing the libabary need to for implementing the stack and its functionality
import java.util.Stack;

// public class of the program named RateLimit
public class RateLimitService{

    // creating a private function called isValid with parameters R, S, request
    // This function is used to perfrom the sliding window protocol and ensure wherether the request is allowed or blocked
    private static void isValid(int R, int S, int[] request){

        // ensure the value of S is not 0
        // if S is 0 or less than zero print error message and stop the program.
        if(S <= 0){
            System.out.println("\nError: The value of S - (Sliding window time period) can't be 0 or less than 0.");
            System.exit(1);
        }

        // ensure the value of R is not 0
        // if R is 0 or less than zero print error message and stop the program.
        if(R <= 0){
            System.out.println("\nError: The value of R - (Sliding window) can't be 0 or less than 0.");
            System.exit(1);
        }
        
        // initilaize the counter to 0
        int counter = 0;
        
        // declare a Stack named accpet to store all the accepeted request timestamp value in it
        Stack<Integer> accept = new Stack<>();

        // looping through the request.
        for(int i = 0; i<request.length; i++){

            // adding the allowed value to the accept variable
            accept.push(request[i]);

            // increment the counter
            counter++;
            
            // if the counter is equal to R (size of Sliding window), then
            // block(ignore) the remaining request for S (sliding window time peroid)
            // set counter to 0, for starting the sliding window after the sliding window time period
            if(counter == R){
                i = i+(S-counter);
                counter = 0;
            }
        } // end of the loop

        // loop through request
        for(int i = 0; i<request.length; i++){

            // check whether the request value is present in the accept variable
            // if the value is presented then print the request value is allowed
            if(accept.contains(request[i])){
                System.out.println(request[i]+" allowed");
            }

            // if the requested value is not presented in the accept then print the request value if blocked
            else{
                System.out.println(request[i]+" blocked");
            }
        } // end of the loop
    }

    // main function of the program with void as a return type
    public static void main(String args[]){

        // getting the values from the command line arguments
        
        // the 0th command line argument denote the value for R
        // where R - Maxmium number of request allowed in sliding window
        // converting the argument into integer datatype since command line passes the arugument as string type
        int R = Integer.parseInt(args[0]);


        // the 1st command line argument denote the value for S
        // where S - Sliding window time peroid in seconds
        // converting the argument into integer datatype since command line passes the arugument as string type
        int S = Integer.parseInt(args[1]);

        // the remaining arguments from 2nd argument were considered as a sequence of timestamps in ascending order
        // storing the sequence of timestamp into the array data structure by con
        int request[] = new int[args.length-2];
        for(int i = 0; i<request.length; i++){
            request[i] = Integer.parseInt(args[i+2]);
        }

        // calling the isValid() to ensure wherether the sequence timestamp is allowed or blocked
        isValid(R, S, request);
    }
   
}
