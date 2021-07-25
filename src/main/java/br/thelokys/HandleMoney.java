package br.thelokys;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.InteiroSemFormato;
import br.com.caelum.stella.inwords.NumericToWordsConverter;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.MonetaryOperators;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;
import javax.money.Monetary;
import javax.money.NumberValue;

/**
 * Api Moneta and Stella to handle money and values
 */
public class HandleMoney {
    public static void main(String[] args) {
        CurrencyUnit currency = Monetary.getCurrency("BRL");
        MonetaryAmount portion = Money.of(75, currency);
        System.out.println(portion);

        MonetaryAmount total = portion.multiply(12);
        System.out.println("total: " + total);

        MonetaryAmount discount = total.with(MonetaryOperators.percent(10));
        System.out.println("desconto: " + discount);

        NumberValue discountWithoutCurrency = discount.getNumber();

        NumericToWordsConverter converter  = new NumericToWordsConverter(new FormatoDeReal());
        String numberName = converter.toWords(discountWithoutCurrency.doubleValue());
        System.out.println("desconto: " + numberName);
    }
}
