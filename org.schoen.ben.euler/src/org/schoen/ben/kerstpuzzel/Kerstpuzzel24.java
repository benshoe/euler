package org.schoen.ben.kerstpuzzel;

import javax.xml.soap.Text;

/**
 * Created by ben on 26-12-16.
 */
public class Kerstpuzzel24 {

    public static void main(String[] args) {
        Kerstpuzzel24 kerstpuzzel24 = new Kerstpuzzel24();
        kerstpuzzel24.run();
    }

    private void run() {
        TextRotator textRotator = new TextRotator();
        String text = "paulafnaonpgnaiprypbefdpuldelqnapyaprtiglelpkwtarnaphtoubdbgcxeababgxcnewbabaglgxenewbacaglgxcnewbabaglgxcnewbaeaglgxbnewbaeaglgxcnewbabaglgxcnewbabaglgxenewbacaglgxenewbacaglgxbnewbaeaglgxbnewbacaglgxenewbabaglgxcnewbabaglgxeneonarkloedxeacabgxaz";
        textRotator.printRotatedText(text);

        VigenereDecoder decoder = new VigenereDecoder();
        System.out.println("TOLKIEN");
//        textRotator.printRotatedText(decoder.decode(text, "tolkien"));
        System.out.println("RINGEN");
        textRotator.printRotatedText(decoder.decode(text, "ringen"));
        System.out.println("RUNEN");
//        textRotator.printRotatedText(decoder.decode(text, "runen"));
        System.out.println("MORDOR");
//        textRotator.printRotatedText(decoder.decode(text, "mordor"));
        System.out.println("TORENS");
        textRotator.printRotatedText(decoder.decode(text, "torens"));

    }
}
