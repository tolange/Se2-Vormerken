package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Mit Hilfe von Vormerkkarten werden beim Vormerken eines Mediums alle relevanten
 * Daten notiert.
 * 
 * Sie beantwortet die folgenden Fragen: Welches Medium wurde vorgemerkt? Wer
 * hat das Medium vorgemerkt? Ist die Vormerkkarte voll?
 * 
 * Vorgemerkte Medien dürfen nur an die Vormerker ausgeliehen werden. Um die Verwaltung der Karten kümmert sich der VerleihService
 * 
 * @author TECP
 * @version SoSe 2017
 */
public class VormerkKarte
{
    private Queue<Kunde> _vormerker;
    private int MAXVORMERKERZAHL = 3;

    public VormerkKarte()
    {
        _vormerker = new PriorityQueue<Kunde>();
    }
    // Eigenschaften einer Vormerkkarte

    /*
     * Gibt Information darüber, ob die Vormerkkarte voll ist. Ist eine Vormerkkarte voll, 
     * so kann das zugehörige Medium nicht mehr vorgemerkt werden.
     */
    public boolean istKarteVoll()
    {
        return _vormerker.size() > (MAXVORMERKERZAHL - 1);
    }

    /*
     * Gibt den Kunden zurück, der das Medium als nächstes ausleihen darf.
     */
    public Kunde getNaechsterVormerker()
    {
        return _vormerker.peek();
    }

    /*
     * Merkt den übergebenen Kunden auf der Vormerkkarte für die Ausleihe vor.
     * 
     * @param Kunde k Der Kunde, der vorgemerkt wird
     * 
     * @ensure  
     */
    public void merkeVor(Kunde k)
    {
        assert !istKarteVoll()
                && !istKundeVormerker(k) : "Vormerkkarte voll oder Kunde ist bereits vorgemerkt";

        _vormerker.add(k);
    }

    /*
     * Gibt zurück, ob der Kunde bereits in der Liste der Vormerker enthalten ist.
     * 
     * @param Kunde k Der Kunde, welcher Überpruft wird als Vormerker
     */
    public boolean istKundeVormerker(Kunde k)
    {
        return _vormerker.contains(k);
    }

    /*
     * Entfernt den nächsten Vormerker
     */
    public void removeNextVormerker()
    {
        _vormerker.poll();
    }
}