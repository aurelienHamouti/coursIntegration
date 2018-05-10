package domaine;

public class Sport {
    private int no;
    private String nom;
    
    public Sport(int no, String nom) { this.no=no; this.nom=nom; }
    public Sport(int no) { this(no, ""); }
    public Sport(){}
    
    //public int getNo() { return no; }
    //public String getNom() { return nom; }
    
    public boolean equals(Object obj) {
        return this.no == ((Sport)obj).no;
    }
    public String toString() { return nom; }

    public boolean compareStringTest(String s1,String s2){
        int cmpVal = s1.compareTo(s2);

        if (cmpVal == 0) // The strings are the same.
            return true;
        else {
            return false;}
    }

    public String concatenerString(String ... strings){
        String conca ="";
        for (int i=0;i<strings.length; i++){
            conca += strings[i].toString();
        }
        return conca;
    }
}