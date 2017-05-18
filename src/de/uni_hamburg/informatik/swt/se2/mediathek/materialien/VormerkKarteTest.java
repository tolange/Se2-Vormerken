package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Datum;
import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Geldbetrag;
import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Kundennummer;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.CD;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;


public class VormerkKarteTest {
	
private Kunde _kunde1;
private Kunde _kunde2;
private Kunde _kunde3;

private Medium _medium;

private VormerkKarte _vormerkKarte;

public VormerkKarteTest() {
	
	 _kunde1 = new Kunde(new Kundennummer(123456), "eins", "1");
	 _kunde1 = new Kunde(new Kundennummer(23456), "zwei", "2");
	 _kunde1 = new Kunde(new Kundennummer(3456), "drei", "3");

	 _medium  = new  CD("bar", "baz", "foo", 123);
	 
	 _vormerkKarte = new VormerkKarte(_medium);
	 
	 _vormerkKarte.merkeVor(_kunde1);
	 _vormerkKarte.merkeVor(_kunde2);
	 _vormerkKarte.merkeVor(_kunde3);
}

@Test
testeIstKarteVoll(){
	assertTrue(_vormerkKarte.istKarteVoll());
}
@Test
testIstKundeVormerker() {
	assertTrue(_vormerkKarte.istKundeVormerker());
}

@Test
testeGetNaechsterVormerker(){ 
	assertEquals(_kunde1, _vormerkKarte.getNaechsterVormerker());	
}

@Test
testeRemoveNextVormerker(){
	_vormerkKarte.removeNextVormerker();
	assertEquals(_kunde2, _vormerkKarte.getNaechsterVormerker());	
}

@Test
testeMerkeVor() {
	_vormerkKarte.merkeVor(_kunde1);
	_vormerkKarte.removeNextVormerker();
	_vormerkKarte.removeNextVormerker();
	assertEquals(_kunde1, _vormerkKarte.getNaechsterVormerker());	
}





