package org.schoen.ben.kerstpuzzel;

/**
 * Created by ben on 17-12-16.
 */
public class Kerstpuzzel14 {

    TextRotator m_rotator = new TextRotator();

    private String m_text1;

    private String m_text2;

    private String m_text3;

    private String m_text4;

    private String m_text5;

    private String m_text6;

    private String m_text7;

    private String m_text6WithoutSpace;

    public static void main(String[] args) {
        Kerstpuzzel14 kerstpuzzel14 = new Kerstpuzzel14();
        kerstpuzzel14.run();
    }

    private void run() {
        TextRotator rotator = new TextRotator();
        m_text1 = "IGZNBNPNZIGONGIBWJJPQHUIFGDIFBKGQSNPCNDIFB";
        m_text2 = "NZRNNFVYTQJGIWQNIQFLLNJQ";
        // je gaat het pas zien als je het door hebt
        m_text3 = "XS UOOH VSH DOG NWSB OZG XS VSH RCCF VSPH";
        m_text4 = "ANLNISUEWHTINSJECDNOENRBUEAKNLNHEEBB";
        m_text5 = "VROPRIDGIVDLWSEHVANBIVRWRWVAASIGMXCVOVRTQDPWPEECSZAIIROADMECANRT";
        m_text6 = "RM ELVGYZO RH SVG HRNKVO: QV YVMG LU LK GRQW LU QV YVMG GV OZZG. ZOH QV GV OZZG YVMG, NLVG QV ALITVM WZG QV LK GRQW EVIGIVPG";
        m_text6WithoutSpace = "RMELVGYZORHSVGHRNKVOQVYVMGLULKGRQWLUQVYVMGGVOZZGZOHQVGVOZZGYVMGNLVGQVALITVMWZGQVLKGRQWEVIGIVPG";
        m_text7 = "TMAVFEKUOBOBRNRSEVVALCYAVNMAMASSWETIC";
        m_rotator.printRotatedText(m_text1);
        m_rotator.printRotatedText(m_text2);
        System.out.println("Text3: ");
        m_rotator.printRotatedText(m_text3);
        m_rotator.printRotatedText(m_text4);
        m_rotator.printRotatedText(m_text5);
        m_rotator.printRotatedText(m_text6);
        m_rotator.printRotatedText(m_text7);

        printVignereText("JOHANCRUIJFF");
        //printVignereText("AJAX");
        //printVignereText("VERLOSSER");
        //printVignereText("FEIJENOORD");
        //printVignereText("FCBARCELONA");
        //printVignereText("BARCELONA");
        //printVignereText("VEERTIEN");
        printVignereText("ARENA");
    }

    private void printVignereText(String keyword) {
        System.out.println("keyword = [" + keyword + "]");
        VigenereDecoder vigenereDecoder = new VigenereDecoder();
        System.out.println("Vigenere pogingen");
        String vignereText = vigenereDecoder.decode(m_text1, keyword);
        System.out.println("Text1: " + vignereText);
        String vignereText2 = vigenereDecoder.decode(m_text2, keyword);
        System.out.println("Text2: " + vignereText2); //ELKNADEELHEBZIJNVOORDEEL
        String vignereText4 = vigenereDecoder.decode(m_text4, keyword);
        System.out.println("Text4: " + vignereText4);
        String vignereText5 = vigenereDecoder.decode(m_text5, keyword);
        System.out.println("Text5: " + vignereText5);
        String vignereText6 = vigenereDecoder.decode(m_text6WithoutSpace, keyword);
        System.out.println(vignereText6);
        String vignereText7 = vigenereDecoder.decode(m_text7, keyword);
        System.out.println("Text7: " + vignereText7);

        System.out.println("Rotated vignere tekst");
        m_rotator.printRotatedText(vignereText);
        m_rotator.printRotatedText(vignereText2);
        m_rotator.printRotatedText(vignereText4);
        m_rotator.printRotatedText(vignereText5);
        m_rotator.printRotatedText(vignereText6);
        m_rotator.printRotatedText(vignereText7);
    }
}
