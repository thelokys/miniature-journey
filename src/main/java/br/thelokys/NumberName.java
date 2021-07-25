package br.thelokys;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.InteiroSemFormato;
import br.com.caelum.stella.inwords.NumericToWordsConverter;

import java.math.BigDecimal;

/**
 * This class contain example of how to use Lib stella to write number's name
 * from brazil
 */
public class NumberName {
    public static void main(String[] args) {
        var converterRaw = new NumericToWordsConverter(new InteiroSemFormato());
        var valueRaw = new BigDecimal("75.00");
        var valueInNameRaw = converterRaw.toWords(valueRaw.doubleValue());
        System.out.println("Value named: " + valueInNameRaw + " reais");

        var converterInReal = new NumericToWordsConverter(new FormatoDeReal());
        var valueInReal = new BigDecimal("900.00");
        var valueInNameInReal =
                converterInReal.toWords(valueInReal.doubleValue());
        System.out.println("Value named: " + valueInNameInReal);


    }
}
