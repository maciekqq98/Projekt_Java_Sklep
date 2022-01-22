package com.gradle;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


class FirstClassTest {


    @Test
    void czyPrzeterminowanyProduktTenSamDzien() {

        // given
        Produkty produkty = new Produkty();
        LocalDate now = LocalDate.now();

        produkty.setDateSpozycia(now);
        // when
        boolean result = produkty.SprawdzDateWaznosci(produkty);
        // then
        Assertions.assertThat(result).isFalse();

    }@Test
    void czyPrzeterminowanyProduktKilkadniPoTerminie() {

        // given
        Produkty produkty = new Produkty();
        LocalDate now = LocalDate.now();

        produkty.setDateSpozycia(now.minusDays(5));
        // when
        boolean result = produkty.SprawdzDateWaznosci(produkty);
        // then
        Assertions.assertThat(result).isTrue();

    }
    @Test
    void NieprzeterminowanyProdukt() {

        // given
        Produkty produkty = new Produkty();
        LocalDate now = LocalDate.now();
        produkty.setDateSpozycia(now.plusDays(5));
        // when
        boolean result = produkty.SprawdzDateWaznosci(produkty);
        // then
        Assertions.assertThat(result).isFalse();

    }

}