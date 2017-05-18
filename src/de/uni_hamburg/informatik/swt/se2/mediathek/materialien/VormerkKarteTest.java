package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Kundennummer;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;


public class VormerkKarteTest {
	
private Kunde _kunde1;
private Kunde _kunde2;
private Kunde _kunde3;

private Medium _medium;

private VormerkKarte _vormerkKarte;

public VormerkKarteTest() {
	
	 _kunde1 = new Kunde(new Kundennummer(123456), "eins", "1");
	 _kunde2 = new Kunde(new Kundennummer(234561), "zwei", "2");
	 _kunde3 = new Kunde(new Kundennummer(345612), "drei", "3");
 
	 _vormerkKarte = new VormerkKarte();
	 
	 _vormerkKarte.merkeVor(_kunde1);
	 _vormerkKarte.merkeVor(_kunde2);
	 _vormerkKarte.merkeVor(_kunde3);
}

@Test
public void testeIstKarteVoll(){
	assertTrue(_vormerkKarte.istKarteVoll());
}
@Test
public void testIstKundeVormerker() {
	assertTrue(_vormerkKarte.istKundeVormerker(_kunde1));
}

@Test
public void testeGetNaechsterVormerker(){ 
	assertEquals(_kunde1, _vormerkKarte.getNaechsterVormerker());	
}

@Test
public void testeRemoveNextVormerker(){
	_vormerkKarte.removeNextVormerker();
	assertEquals(_kunde2, _vormerkKarte.getNaechsterVormerker());	
}

@Test
public void testeMerkeVor() {
	_vormerkKarte.merkeVor(_kunde1);
	_vormerkKarte.removeNextVormerker();
	_vormerkKarte.removeNextVormerker();
	assertEquals(_kunde1, _vormerkKarte.getNaechsterVormerker());	
}
}	





