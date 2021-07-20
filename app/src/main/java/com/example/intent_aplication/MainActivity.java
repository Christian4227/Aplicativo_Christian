package com.example.intent_aplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView textoFinal, txtmedida, textMedida1, textMedida2;
    EditText valor, indice;
    Button btnCalcular;
    ImageView image, imageWhats, imageMessenger, imageGmail;
    Spinner spnlista;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnlista = new Spinner(this);
        image = new ImageView(this);
        textoFinal = new TextView(this);

        valor = findViewById(R.id.editText1);

        imageWhats = findViewById(R.id.imageWhats);
        imageGmail = findViewById(R.id.imageGmail);
        imageMessenger = findViewById(R.id.imageMessernger);
        btnCalcular = findViewById(R.id.btnCalcular);
        spnlista = findViewById(R.id.spinner);
        image = findViewById(R.id.imageView2);
        txtmedida = findViewById(R.id.txtInforma);
        textMedida1 = findViewById(R.id.textView);
        textMedida2 = findViewById(R.id.textView2);


        spnlista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0){
                    image.setImageResource(R.drawable.polegada);
                    textMedida1.setText(R.string.polegada);
                    textMedida2.setText(R.string.centimetro);
                }
                else if (position == 1) {
                    image.setImageResource(R.drawable.medida_altura);
                    textMedida1.setText(R.string.pes);
                    textMedida2.setText(R.string.metros);

                }
                else if (position == 2){
                    image.setImageResource(R.drawable.quilometragem);
                    txtmedida.setText(R.string.milha);
                    textMedida1.setText(R.string.milha);
                    textMedida2.setText(R.string.quilometro);
                }
                else if (position == 3){
                    image.setImageResource(R.drawable.temperatura_calor_capa);
                    textMedida1.setText(R.string.celsius);
                    textMedida2.setText(R.string.farenheint);
                }
                else if (position == 4){
                    image.setImageResource(R.drawable.nos);
                    textMedida1.setText(R.string.nos);
                    textMedida2.setText(R.string.km_h);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void btnLimpar(View view){
        valor = findViewById(R.id.editText1);
        txtmedida = findViewById(R.id.txtInforma);

        valor.setText("");
        txtmedida.setText(R.string.valor_vazio);
    }

    public void btnTrocar(View view){
        valor = findViewById(R.id.editText1);
        textMedida1 = findViewById(R.id.textView);
        textMedida2 = findViewById(R.id.textView2);

        String med_1 = textMedida1.getText().toString();
        String med_2 = textMedida2.getText().toString();

        textMedida1.setText(med_2);
        textMedida2.setText(med_1);

        String entrada = valor.getText().toString();
        conversao(entrada);
    }

    public void btnCalcular(View view) {
        valor = findViewById(R.id.editText1);
        txtmedida = findViewById(R.id.txtInforma);
        String entrada = valor.getText().toString();

        conversao(entrada);
    }

    public void conversao(String entrada){
            txtmedida = findViewById(R.id.txtInforma);
            if (entrada.equals(""))
                txtmedida.setText(R.string.valor_vazio);
            else {
                float numero = Float.parseFloat(valor.getText().toString());
                if (textMedida1.getText().toString().equals("Polegada")){
                    double resultado = numero * 2.54;
                    DecimalFormat formatado = new DecimalFormat("0.00");
                    String textResultado = formatado.format(resultado) + " Centímetros" + "Unidade de Medida - SI";
                    txtmedida.setText(textResultado);
                }
                else if (textMedida1.getText().toString().equals("Centímetro")){
                    double resultado = numero * 0.39;
                    DecimalFormat formatado = new DecimalFormat("0.00");
                    String textResultado = formatado.format(resultado) + " Polegadas" + "Unidade de Medida - EUA";
                    txtmedida.setText(textResultado);
                }
                else if (textMedida1.getText().toString().equals("Pés")){
                    double resultado = numero * 0.3;
                    DecimalFormat formatado = new DecimalFormat("0.00");
                    String textResultado = formatado.format(resultado) + " Metros" + "Unidade de Medida - SI";
                    txtmedida.setText(textResultado);
                }
                else if (textMedida1.getText().toString().equals("Metros")){
                    double resultado = numero * 3.28;
                    DecimalFormat formatado = new DecimalFormat("0.00");
                    String textResultado = formatado.format(resultado) + " Pés" + "SI Antiga - EUA";
                    txtmedida.setText(textResultado);
                }
                else if (textMedida1.getText().toString().equals("Milha")){
                    double resultado = numero * 1.6;
                    DecimalFormat formatado = new DecimalFormat("0.00");
                    String textResultado = formatado.format(resultado) + " Quilometros" + " Unidade de Medida SI";
                    txtmedida.setText(textResultado);
                }
                else if (textMedida1.getText().toString().equals("Quilometros")){
                    double resultado = numero * 0.62;
                    DecimalFormat formatado = new DecimalFormat("0.00");
                    String textResultado = formatado.format(resultado) + " Milhas" + "SI Antiga - EUA";
                    txtmedida.setText(textResultado);
                }
                else if (textMedida1.getText().toString().equals("Celsius")){
                    double resultado = (numero * 1.8) + 32;
                    DecimalFormat formatado = new DecimalFormat("0.00");
                    String textResultado = formatado.format(resultado) + "ºF" + "SI Antiga - EUA";
                    txtmedida.setText(textResultado);
                }
                else if (textMedida1.getText().toString().equals("Farenheint")){
                    double resultado = ((numero -32) * 5) / 9;
                    DecimalFormat formatado = new DecimalFormat("0.00");
                    String textResultado = formatado.format(resultado) + "ºC" + " Unidade de Medida - SI";
                    txtmedida.setText(textResultado);
                }
                else if (textMedida1.getText().toString().equals("Nós")){
                    double resultado = numero * 1.8;
                    DecimalFormat formatado = new DecimalFormat("0.00");
                    String textResultado = formatado.format(resultado) + " Km/h" + " Unidade de Medida - SI";
                    txtmedida.setText(textResultado);
                }
                else if (textMedida1.getText().toString().equals("Km/h")){
                    double resultado = numero * 0.5;
                    DecimalFormat formatado = new DecimalFormat("0.00");
                    String textResultado = formatado.format(resultado) + " Nós" + " SI Antiga - EUA";
                    txtmedida.setText(textResultado);
                }
        }
    }

    public void btnEnviaWhatsapp(View view){
        valor = findViewById(R.id.editText1);
        String num = valor.getText().toString();
        if (! num.equals("")){
            PackageManager pm = getPackageManager();
            try {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, txtmedida.getText().toString());
                PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
                intent.setPackage("com.whatsapp");
                startActivity(intent);
            } catch (PackageManager.NameNotFoundException e) {
                Toast.makeText(this, "Não foi possível enviar a mensagem", Toast.LENGTH_LONG).show();
            }
        }
       else{
           Toast.makeText(this, "Digite algum valor na caixa de texto", Toast.LENGTH_LONG).show();
        }
    }

    public void btnEnviaGoogleDocs(View view) {
        valor = findViewById(R.id.editText1);
        String num = valor.getText().toString();
        if (! num.equals("")){
            PackageManager pm = getPackageManager();
            try {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, txtmedida.getText().toString());
                intent.putExtra(Intent.EXTRA_SUBJECT, "Nota da atividade Intents - ILP 506");
                PackageInfo info = pm.getPackageInfo("com.google.android.apps.docs", PackageManager.GET_META_DATA);
                intent.setPackage("com.google.android.apps.docs");
                startActivity(intent);
            } catch (PackageManager.NameNotFoundException e) {
                Toast.makeText(this, "Não foi possível enviar a mensagem", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this, "Digite algum valor na caixa de texto", Toast.LENGTH_LONG).show();
        }

    }

    public void btnEnviaGmail(View view) {
        valor = findViewById(R.id.editText1);
        String num = valor.getText().toString();
        if (! num.equals("")){
            PackageManager pm = getPackageManager();
            try {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, "christian.cubo@fatec.gov.sp.br");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Nota da atividade Intents - Matéria ILP 506");
                intent.putExtra(Intent.EXTRA_TEXT, txtmedida.getText().toString());
                PackageInfo info = pm.getPackageInfo("com.google.android.gm", PackageManager.GET_META_DATA);
                intent.setPackage("com.google.android.gm");
                startActivity(Intent.createChooser(intent, "Send Email"));
            } catch (PackageManager.NameNotFoundException e) {
                Toast.makeText(this, "Não foi possível enviar a mensagem", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this, "Digite algum valor na caixa de texto", Toast.LENGTH_LONG).show();
        }
    }
}
