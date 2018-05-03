package vue;

import java.util.Observable;
import java.util.Observer;
import java.awt.TextField;
import metier.ListeAthletes;
import metier.Action;
import domaine.Athlete;

public class ObsPourDetail implements Observer {
    private TextField tfNo, tfPrenom, tfNom, tfPays, tfSport;

    public ObsPourDetail(TextField tfNo, TextField tfPrenom, TextField tfNom, TextField tfPays, TextField tfSport) {
        this.tfNo=tfNo; this.tfPrenom=tfPrenom; this.tfNom=tfNom; this.tfPays=tfPays; this.tfSport=tfSport;
    }

    public void update(Observable o, Object arg) {
        if (((Action)arg).getAction() == Action.SEL) {
            if (((Action)arg).getPos() != ListeAthletes.NO_POS) {
                Athlete a = ((ListeAthletes)o).getAthlete();
                tfNo.setText(String.valueOf(a.getNo()));
                tfPrenom.setText(a.getPrenom());
                tfNom.setText(a.getNom());
                tfPays.setText(a.getPays().toString());
                tfSport.setText(a.getSport().toString());
            } else {
                tfNo.setText(null); tfPrenom.setText(null); tfNom.setText(null); tfPays.setText(null); tfSport.setText(null);
            }
        }
    }
}