class StaticOuter{
    String a="Static Outer String";
    static String b = "Static Outer static string";
    void seeStaticinner(){
            //System.out.println(nonstatic);
            //System.out.println(StaticInner.nonstatic); 
            System.out.println(new StaticInner().nonstatic);//OK 
            System.out.println(StaticInner.s);//OK, s is static
        }
    static class StaticInner{
        String nonstatic="Static Inner non static string";
        static String s="Static Inner static string";
        public static void main(String[] args){
            StaticInner i=new StaticInner();
            System.out.println(i.nonstatic);
            System.out.println(StaticInner.s);
            System.out.println(b);
        }
    }   
        
        public static void main(String[] args){
//Doesn't compiles without writing the exact location of s //3. 
            //System.out.println(s); 
            System.out.println(StaticInner.s);
            StaticOuter so = new StaticOuter();
            so.seeStaticinner();
    }
    
}
class SomeOther{
public static void main(String[]args){ //Write the

System.out.println(StaticOuter.StaticInner.s);
//To access nonstatic members we need an object or 'this' 
StaticOuter.StaticInner si = new StaticOuter.StaticInner(); //No 'this' exists in static context! 
System.out.println(si.nonstatic); 
//System.out.println(si.s);
} }