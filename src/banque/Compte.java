package banque;

import java.time.LocalDate;


public class Compte {
    private  int idCompte;
    private double solde;
    private LocalDate d_creation;
    private String[] journalisation = new String[10];
    public int  j=0;
    private Client client;


    public Compte(){}
    public Compte(int idCompte,double solde, Client client) {
        this.idCompte=idCompte;
        this.solde = solde;
        this.d_creation = LocalDate.now();
        this.client = client;

        journalisation[j] = "Compte id : " + idCompte + " a ete crere le : " + d_creation;
        j++;

    }

    public Compte(int idCompte,double solde) {
        this.idCompte=idCompte;
        this.solde = solde;
        this.d_creation = LocalDate.now();

        journalisation[j] = "Compte id : " + idCompte + " a ete crée le : " + d_creation;
        j++;

    }


    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        if(solde>0)
        {
            journalisation[j] = "Compte id : " + idCompte + ", le solde a ete modifié de : " + this.solde+" a : "+solde;
            j++;
            this.solde = solde;
        }

    }

    public LocalDate getD_creation() {
        return d_creation;
    }

    public void setD_creation(LocalDate d_cration) {
        this.d_creation = d_cration;
    }

    public String[] getJournalisation() {
        return journalisation;
    }

    public void setJournalisation(String[] journalisation) {
        this.journalisation = journalisation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        {
            journalisation[j] = "Compte id : " + idCompte + " est lie au Client : " + client.getIdClient();
            j++;
            this.client = client;
        }

    }

    @Override
    public String toString() {
        String r="<<< Compte >>>\n";
        r+="    Id              : "+idCompte+"\n";
        r+="    solde           : "+solde+"\n";
        r+="    date de cration : "+d_creation+"\n";
        if(client!=null)
            r+="    |->"+client.toString()+"\n";
        r+="=============================================\n";
        return r;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Compte)
            return  false;
        Compte o= (Compte) obj;
        if (this.getIdCompte()==o.getIdCompte())
            return true;
        else return false;
    }
}
