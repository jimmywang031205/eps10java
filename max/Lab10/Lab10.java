    
    /**
     * Write a description of class Lab10 here.
     *
     * @author Max
     * @version 2019-03-06
     */
    public class Lab10
    {
        // instance variables - replace the example below with your own
        private Input MyInput;
        /**
         * Constructor for objects of class Lab10
         */
        public Lab10()
        {
            // initialise instance variables
            MyInput=new Input();
        }
        public void main()
        {
            System.out.print("Enter a number: ");
            int n=MyInput.getInt();
            
            System.out.print("Prime factors: ");
            Prime(n);
        }
        
        public static void Prime(int n) 
        {
            int sqrt = (int)Math.sqrt(n);
            for (int i = 2; i <= sqrt; i++)
            {
                if(n % i == 0)
                {
                    //return false;
                    System.out.print(i+",");
                    n/=i;
                }
          
            }
            System.out.print(n);
        }
}
