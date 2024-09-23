package com.nexcodelab.agendaclinicaser.shared.utils;

import java.time.DayOfWeek;

/**
 *  Domingo = 0;
 *  Segunda-Feira = 1;
 *  Terça-Feira = 2;
 *  Quarta-Feira =3;
 *  Quinta-Feira =4;
 *  Sexta-Feira =5;
 *  Sábado=6;
 */
public class DiaDaSemanaUtils {

    public static DayOfWeek toDayOfWeek(int dia) {
        if(dia > 7 || dia < 0){
            throw new IllegalArgumentException("Valor deve estar entre 0 e 7, inclusivos.");
        }
        if (dia == 0) {
            dia = 7;
        }
        return DayOfWeek.of(dia);
    }
}
