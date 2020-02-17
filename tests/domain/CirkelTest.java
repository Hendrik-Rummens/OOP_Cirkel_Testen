package domain;

import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class CirkelTest {

    private double geldigeStraal;
    private Point2D.Double geldigMiddelpunt;
    private Point2D.Double gegevenPuntBuitenCirkel, gegevenPuntBinnenCirkel;
    private Cirkel cirkel;
    private final double delta = 1E-10;

    @org.junit.Before
    public void setUp() throws Exception {

        geldigMiddelpunt = new Point2D.Double(5,8);
        geldigeStraal = 2;
        gegevenPuntBuitenCirkel = new Point2D.Double(10,15);
        gegevenPuntBinnenCirkel = new Point2D.Double(4,7);
        cirkel = new Cirkel(geldigMiddelpunt, geldigeStraal);

    }

    //Cirkel//

    @Test(expected = IllegalArgumentException.class)
    public void Cirkel_met_middelpunt_null_Gooit_exeption(){
        new Cirkel(null, geldigeStraal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Cirkel_met_straal_negatief_Gooit_exeption(){
        new Cirkel(geldigMiddelpunt, -5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Cirkel_met_straal_groter_dan_Xmid_Gooit_exeption(){
        new Cirkel(geldigMiddelpunt, 8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Cirkel_met_straal_grote_dan_Ymid_Gooit_exeption(){
        new Cirkel(geldigMiddelpunt, 9);
    }

    @Test
    public void Cirkel_met_juist_middelpunt_en_juiste_straal_Maakt_Cirkel_met_correcte_eigenschappen() {
        Cirkel cirkel = new Cirkel(geldigMiddelpunt, geldigeStraal);
        assertNotNull(cirkel);
        assertEquals(geldigMiddelpunt, cirkel.getMiddelpunt());
        assertEquals(geldigeStraal, cirkel.getStraal(), delta);
    }
    
    //berekenOppervlakte//
    @Test
    public void Cirkel_met_geldige_straal_en_geldig_middelpunt_geeft_Oppervlakte(){
        assertEquals(12.56, cirkel.berekenOppervlakte(), delta);
    }

    //ligtPuntInCirkel//

    @Test
    public void Cirkel_met_punt_binnen_cirkel_geeft_true(){
        assertTrue(cirkel.ligtPuntInCirkel(gegevenPuntBinnenCirkel));
    }
    @Test
    public void Cirkel_met_gegeven_punt_buiten_cirkel_geeft_false(){
        assertFalse(cirkel.ligtPuntInCirkel(gegevenPuntBuitenCirkel));
    }

    //vergrootStraal//
    @Test(expected = IllegalArgumentException.class)
    public void Factor_negatief_Gooit_Exeption(){
        cirkel.vergrootStraal(-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void VergrootStraal_met_XY_groter_dan_middelpunt_Gooit_Exeption(){
        cirkel.vergrootStraal(5);
    }

    @Test
    public void VergrootStraal_met_correcte_straal(){
        cirkel.vergrootStraal(1.5);
        assertEquals(3, cirkel.getStraal(), delta);
    }
}