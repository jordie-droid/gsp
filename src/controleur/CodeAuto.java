/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.util.Random;

/**
 *
 * @author Jordie
 */
public class CodeAuto {

    public String createCode() {
        Random ran = new Random();
        int l = 7 + (Math.abs(ran.nextInt() % 3));
        StringBuffer capBuff = new StringBuffer();
        for (int i = 0; i < l; i++) {
            int bcase = Math.abs(ran.nextInt()) % 62;
            int charnum = 0;
            if (bcase < 26) {
                charnum = 65 + bcase;
            } else if (bcase < 52) {
                charnum = 97 + (bcase - 26);
            } else {
                charnum = 48 + (bcase - 52);
            }
            capBuff.append((char) charnum);
        }
        return capBuff.toString();
    }
}
