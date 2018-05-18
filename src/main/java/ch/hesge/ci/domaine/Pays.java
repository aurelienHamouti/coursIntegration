package domaine;

public class Pays {
    private int no;
    private String code;
    private String nom;
    
    public Pays(int no, String codePays, String nomPays) { this.no=no; this.code=codePays; this.nom=nomPays; }
    public Pays(int no) { this(no, "", ""); }
    public Pays(){}
    
    //public int getNo() { return no; }
    //public String getCode() { return code; }
    //public String getNom() { return nom; }
    
    public boolean equals(Object obj) { return this.no == ((Pays)obj).no; }
    public String toString() { return nom; }
}