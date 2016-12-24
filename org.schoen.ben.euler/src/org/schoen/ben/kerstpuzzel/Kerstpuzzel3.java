package org.schoen.ben.kerstpuzzel;

/**
 * Created by ben on 21-12-16.
 */
public class Kerstpuzzel3 {

    TextRotator m_rotator = new TextRotator();

    public static void main(String[] args) {
        Kerstpuzzel3 kerstpuzzel3 = new Kerstpuzzel3();
        kerstpuzzel3.run();
        kerstpuzzel3.runC();
    }

    private void runC() {
        String text = "ER IUUH VUI ER NJJP\n" +
                "SNHHQ PE SNMTVMBEIS\n" +
                "ZHSQ HJ DULF RSUO\n" +
                "VFR FQ RP DEKB UMMP UFPBFKFE VMMIL? WMMQPTTH WMMQVJJQ\n" +
                "OCUIQIRRI";
        m_rotator.printRotatedText(text);
    }

    private void run() {
        String text = "TCJN, XDAAW MNZLYOMN, ACN AQISJWQ, JQ SOT WDPNE HJNNQ EDWC, QLMJR KOODSY, CIICP, PQTQKJG QJ PQTQKJG";

        for(int i = 0; i < 26; i++) {
            System.out.println(i + ": " + m_rotator.rotateText(text, i));
        }
    }
}
