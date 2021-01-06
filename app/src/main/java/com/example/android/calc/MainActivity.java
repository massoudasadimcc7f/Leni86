package com.example.android.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // robie globala String do łączenia tego wszystkiego
    String chain = "";



       // zmienna do rodzaju działania
    int coRobimy =0;
    double wynik=0;
    double a;
    double b;
                                                // wyswietlany na ekranie WSZYSTKIE CYFRY
    public void add1 (View view){
        chain += "1";
wyswietlamyEkran1(chain);
    }
    public void add2 (View view){
        chain += "2";
        wyswietlamyEkran1(chain);
    }
    public void add3 (View view){
        chain += "3";
        wyswietlamyEkran1(chain);
    }
    public void add4 (View view){
        chain += "4";
        wyswietlamyEkran1(chain);
    }
    public void add5 (View view){
        chain += "5";
        wyswietlamyEkran1(chain);
    }
    public void add6 (View view){
        chain += "6";
        wyswietlamyEkran1(chain);
    }
    public void add7 (View view){
        chain += "7";
        wyswietlamyEkran1(chain);
    }
    public void add8 (View view){
        chain += "8";
        wyswietlamyEkran1(chain);
    }
    public void add9 (View view){
        chain += "9";
        wyswietlamyEkran1(chain);
    }
    public void add0 (View view){
        chain += "0";
        wyswietlamyEkran1(chain);
    }
    public void kropka (View view){
        chain += ".";
        wyswietlamyEkran1(chain);
    }
    public  void toascik (View view){
        Toast.makeText(this, "Podziękowania dla \nEwy B.\n Za inspirację do pokodowania :)", Toast.LENGTH_LONG).show();
    }
                                                // zamieniamy ekran 1 na liczbe
    public double liczbaEkran1 (){
        TextView wyswietlacz = findViewById(R.id.wyswietlaczglowny);
        String liczbaDouble = wyswietlacz.getText().toString();
        a = Double.parseDouble(liczbaDouble);
        return a;
    }
                                                // zmiana ekranu 2 na cyfre

    public double liczbaEkran2 () {
        TextView wyswietlacz2 = findViewById(R.id.wyswietlacz2);
        String liczbaDouble2 = wyswietlacz2.getText().toString();
        b =  Double.parseDouble(liczbaDouble2);
        return b;
    }
                                                // wyswietlamy wartość na ekranie 1
    public void wyswietlamyEkran1 (String coWyswietlamy1){
        TextView wyswietlacz = findViewById(R.id.wyswietlaczglowny);
        wyswietlacz.setText(coWyswietlamy1);
    }
                                                // wyswietlamy wartość na ekranie 2
    public void wyswietlamyEkran2 (String coWyswietlamy2){
        TextView wyswietlacz2 = findViewById(R.id.wyswietlacz2);
        wyswietlacz2.setText(coWyswietlamy2);
    }

                                                //wyswietlamy ZNAKI OPERACJI
    public void znaki (String znak){
        TextView pokazujemy = findViewById(R.id.wyswietlaczZnaki);
        pokazujemy.setText(znak);
    }

                                                // bloki WYKONYWANIA DZIAŁAŃ
    public void dodac (View view){
        znaki("+");
        liczbaEkran1();
        liczbaEkran2();
        double c =a+b;
        wyswietlamyEkran2(""+c);
        wyswietlamyEkran1("0");
        chain="";
        coRobimy=1;
    }

    public void odjac (View view){
        znaki("-");
        liczbaEkran1();
        liczbaEkran2();
        double c =a-b;
        wyswietlamyEkran2(""+c);
        wyswietlamyEkran1("0");
        chain="";
        coRobimy=2;
    }

    public void mnozenie (View view){
        znaki("*");
        liczbaEkran1();
        liczbaEkran2();
        if (liczbaEkran2()==0){
            wyswietlamyEkran2(""+liczbaEkran1());
            wyswietlamyEkran1("0");
        } else {
            double c =b*a;
            wyswietlamyEkran2(""+c);
            wyswietlamyEkran1("0");
        }

        chain="";
        coRobimy=3;
    }
    public void dzielenie (View view){
        znaki("/");
        liczbaEkran1();
        liczbaEkran2();
        if (liczbaEkran2()==0){
            wyswietlamyEkran2(""+liczbaEkran1());
            wyswietlamyEkran1("0");
        } else {
            double c =b/a;
            wyswietlamyEkran2(""+c);
            wyswietlamyEkran1("0");
        }
        chain="";
        coRobimy=4;
    }
    public void procent (View view){
        znaki("%");
        liczbaEkran1();
        liczbaEkran2();
        if (liczbaEkran2()==0){
            wyswietlamyEkran2(""+liczbaEkran1());
            wyswietlamyEkran1("0");
        } else {
            double c =(b*a)/100;
            wyswietlamyEkran2(""+c);
            wyswietlamyEkran1("0");
        }
        chain="";
        coRobimy=5;
    }
                                                                    // OWROTNOŚĆ LICZBY
    public void zamiana (View viev){
        znaki("");
            if (liczbaEkran1()>= 0) {
                double zamianka = liczbaEkran1() - (2 * liczbaEkran1());
                wyswietlamyEkran1("" + zamianka);
                zamianka=0;
            } else if (liczbaEkran1()<0){
                double zamianka2 = (liczbaEkran1() - (2*liczbaEkran1()));
                wyswietlamyEkran1("" + zamianka2);
                zamianka2=0;
            }
            chain="";

        }


                                                            // CZYŚCIMY EKRAN
    public void clear (View view){
        znaki("");
        wyswietlamyEkran2("0");
        wyswietlamyEkran1("0");
        chain="";
    }

                                                            // wyniki !!!!!!!!!!!!!!!!!
    public void wynik (View view) {
        znaki("");
        liczbaEkran1();
        liczbaEkran2();
        // warunki do metod działań
        if (coRobimy == 1) {
            wynik = b + a;
        } else if (coRobimy == 2) {
            wynik = b - a;
        } else if (coRobimy == 3) {
            wynik = b * a;
        } else if (coRobimy == 4) {
            wynik = b / a;
        } else if (coRobimy == 5) {
            wynik = (b * a) / 100;
        }

        wyswietlamyEkran2("0");
        wyswietlamyEkran1("" + wynik);
        chain = "";
        coRobimy = 0;

    }
}
