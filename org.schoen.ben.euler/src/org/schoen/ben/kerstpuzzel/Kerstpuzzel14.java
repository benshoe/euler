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
        String text = "ig znbnpn zig ong ib wjjpqhuifgdifb kgqsnpcndifb";
        String text2 = "nzr nnfvyt qjg iwqn iqfllnjq";
        String text3 = "XS UOOH VSH DOG NWSB OZG XS VSH RCCF VSPH"; // je gaat het pas zien als je het door hebt
        String text4 = "ANLNISUEWHTINSJECDNOENRBUEAKNLNHEEBB";
        String text5 = "VROPRIDGIVDLWSEHVANBIVRWRWVAASIGMXCVOVRTQDPWPEECSZAIIROAD MECANRT";
        String text6 = "RM ELVGYZO RH SVG HRNKVO: QV YVMG LU LK GRQW LU QV YVMG GV OZZG. ZOH QV GV OZZG YVMG, NLVG QV ALITVM WZG QV LK GRQW EVIGIVPG";
        String text7 = "TMAVFEKUOBOBRNRSEVVALCYAVNMAMASSWETIC";
        m_rotator.printRotatedText(text);
        m_rotator.printRotatedText(text2);
        m_rotator.printRotatedText(text3);
        m_rotator.printRotatedText(text4);
        m_rotator.printRotatedText(text5);
        m_rotator.printRotatedText(text6);
        m_rotator.printRotatedText(text7);
    }
}
