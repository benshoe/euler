package org.schoen.ben.kerstpuzzel;

import org.schoen.ben.euler.util.PermutationUtil;

import java.util.Arrays;
import java.util.List;

public class Kerst2018Opg3 {

    public static void main(String[] args) {
        Kerst2018Opg3 opg3 = new Kerst2018Opg3();
        opg3.run();
    }

    private void run() {
        List<String> combinaties = Arrays.asList(PermutationUtil.getPermutations("KERSTMINLX"));

        long rekenles = 1;

        System.out.println("letters.size() = " + combinaties.size());
        for (String letter : combinaties) {
            int k = letter.indexOf('K');
            int e = letter.indexOf('E');
            int r = letter.indexOf('R');
            int s = letter.indexOf('S');
            int t = letter.indexOf('T');
            int m = letter.indexOf('M');
            int i = letter.indexOf('I');
            int n = letter.indexOf('N');
            int l = letter.indexOf('L');
            if(k == 0 || r == 0 || m == 0 || t == 0 || l == 0) {
                continue;
            }

            StringBuilder kerstString  = new StringBuilder();
            kerstString.append(k);
            kerstString.append(e);
            kerstString.append(r);
            kerstString.append(s);
            kerstString.append(t);
            int kerst = new Integer(kerstString.toString());
            StringBuilder rekenenString = new StringBuilder();
            rekenenString.append(r);
            rekenenString.append(e);
            rekenenString.append(k);
            rekenenString.append(e);
            rekenenString.append(n);
            rekenenString.append(e);
            rekenenString.append(n);
            int rekenen = new Integer(rekenenString.toString());
            StringBuilder metString = new StringBuilder();
            metString.append(m);
            metString.append(e);
            metString.append(t);
            int met = new Integer(metString.toString());
            StringBuilder tienString = new StringBuilder();
            tienString.append(t);
            tienString.append(i);
            tienString.append(e);
            tienString.append(n);
            int tien = new Integer(tienString.toString());
            StringBuilder lettersString = new StringBuilder();
            lettersString.append(l);
            lettersString.append(e);
            lettersString.append(t);
            lettersString.append(t);
            lettersString.append(e);
            lettersString.append(r);
            lettersString.append(s);
            int letters = new Integer(lettersString.toString());

            int uitkomst = rekenen + met * tien - letters;
            if(kerst == uitkomst) {
                System.out.println("kerst = " + kerst);
                System.out.println("rekenen = " + rekenen);
                System.out.println("met = " + met);
                System.out.println("tien = " + tien);
                System.out.println("letters = " + letters);

                System.out.println(kerst + " = " + rekenen + " + " + met + " * " + tien + " - " + letters);

                System.out.println("MINSTREEL = " + m+i+n+s+t+r+e+e+l);
                System.out.println("REKENLES = " + r+e+k+e+n+l+e+s);
                rekenles *= new Integer("" + r+e+k+e+n+l+e+s);
                System.out.println("rekenles = " + rekenles);
            }
        }
    }
}
