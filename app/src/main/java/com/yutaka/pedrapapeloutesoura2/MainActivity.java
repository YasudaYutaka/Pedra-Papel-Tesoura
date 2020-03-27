package com.yutaka.pedrapapeloutesoura2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionarPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionarTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {

        ImageView imagemResultado = (ImageView) findViewById(R.id.imageResultado);
        TextView textoResultado = (TextView) findViewById(R.id.textResultado);
        TextView textoYasuda = (TextView) findViewById(R.id.textYasuda);

        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numero = new Random().nextInt(3);
        String escolhaApp = opcoes[numero];

        switch (escolhaApp) {

            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (escolhaApp == "pedra" && escolhaUsuario == "tesoura" ||
            escolhaApp == "papel" && escolhaUsuario == "pedra" ||
            escolhaApp == "tesoura" && escolhaUsuario == "papel") {

            textoResultado.setText("Você perdeu! :)");
            textoYasuda.setTextColor(Color.parseColor("#BD0A0A")); // vermelho se perder
           } else if (escolhaApp == "pedra" && escolhaUsuario == "papel" ||
                      escolhaApp == "papel" && escolhaUsuario == "tesoura" ||
                      escolhaApp == "tesoura" && escolhaUsuario == "pedra") {

                      textoResultado.setText("Você Ganhou! :)");
                      textoYasuda.setTextColor(Color.parseColor("#16FF07"));
                      } else {

                       textoResultado.setText("Empatou!");
                       textoYasuda.setTextColor(Color.parseColor("#6A6A74"));
                      }
     //   textoYasuda.setTextColor("#2828DF");
    }
}