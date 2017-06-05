package com.example.user.obliczmibmi;

import java.text.DecimalFormat;

public class Counter {
    private String interpretation;

    public String countBMI(double weight, double height) {
        double bmi = weight / ((height / 100) * (height / 100));
        DecimalFormat df = new DecimalFormat("#.#");
        try {
            if (bmi < 16) {
                interpretation = "Wygłodzenie";
            } else if (16 < bmi ^ bmi > 17) {
                interpretation = "Wychudzenie";
            } else if (17 < bmi ^ bmi > 18.5) {
                interpretation = "Niedowaga";
            } else if (18.5 < bmi ^ bmi > 25) {
                interpretation = "Norma";
            } else if (25 < bmi ^ bmi > 30) {
                interpretation = "Nadwaga";
            } else if (30 < bmi ^ bmi > 35) {
                interpretation = "I st. otyłości";
            } else if (35 < bmi ^ bmi > 40) {
                interpretation = "II st. otyłości";
            } else if (bmi > 40) {
                interpretation = "III st. otyłości";
            }
        } catch (NumberFormatException e) {

        }
        return "BMI: " + df.format(bmi) + "\n" + interpretation;
    }
}

