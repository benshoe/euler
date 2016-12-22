package org.schoen.ben.kerstpuzzel;

/**
 * Created by ben on 17-12-16.
 */
public class Kerstpuzzel14 {

    TextRotator m_rotator = new TextRotator();

    public static void main(String[] args) {
        Kerstpuzzel14 kerstpuzzel14 = new Kerstpuzzel14();
        kerstpuzzel14.run();
    }

    private void run() {
        TextRotator rotator = new TextRotator();
        String text = "IGZNBNPNZIGONGIBWJJPQHUIFGDIFBKGQSNPCNDIFB";
        String text2 = "NZRNNFVYTQJGIWQNIQFLLNJQ";
        String text3 = "XS UOOH VSH DOG NWSB OZG XS VSH RCCF VSPH"; // je gaat het pas zien als je het door hebt
        String text4 = "ANLNISUEWHTINSJECDNOENRBUEAKNLNHEEBB";
        String text5 = "VROPRIDGIVDLWSEHVANBIVRWRWVAASIGMXCVOVRTQDPWPEECSZAIIROADMECANRT";
        String text6 = "RM ELVGYZO RH SVG HRNKVO: QV YVMG LU LK GRQW LU QV YVMG GV OZZG. ZOH QV GV OZZG YVMG, NLVG QV ALITVM WZG QV LK GRQW EVIGIVPG";
        String text7 = "TMAVFEKUOBOBRNRSEVVALCYAVNMAMASSWETIC";
        m_rotator.printRotatedText(text);
        m_rotator.printRotatedText(text2);
        System.out.println("Text3: ");
        m_rotator.printRotatedText(text3);
        m_rotator.printRotatedText(text4);
        m_rotator.printRotatedText(text5);
        m_rotator.printRotatedText(text6);
        m_rotator.printRotatedText(text7);

        VigenereDecoder vigenereDecoder = new VigenereDecoder();
        System.out.println("Vigenere pogingen");
        System.out.println("Text1: " + vigenereDecoder.decode(text, "JOHANCRUIJFF"));
        System.out.println("Text2: " + vigenereDecoder.decode(text2, "JOHANCRUIJFF")); //ELKNADEELHEBZIJNVOORDEEL
        System.out.println("Text4: " + vigenereDecoder.decode(text4, "JOHANCRUIJFF"));
        System.out.println("Text5: " + vigenereDecoder.decode(text5, "JOHANCRUIJFF"));
        //System.out.println(vigenereDecoder.decode(text6, "JOHANCRUIJFF"));
        System.out.println("Text7: " + vigenereDecoder.decode(text7, "JOHANCRUIJFF"));
    }
}
