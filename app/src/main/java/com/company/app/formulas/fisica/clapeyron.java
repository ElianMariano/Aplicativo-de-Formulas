package com.company.app.formulas.fisica;

import android.preference.EditTextPreference;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.company.app.ItensLibrary.EmptyFragment;
import com.company.app.ItensLibrary.TudoPreenchido;
import com.example.company.formulas.R;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class clapeyron extends AppCompatActivity {
    private EditText p;
    private EditText V;
    private EditText n;
    private EditText r;
    private EditText T;
    private TextView line1;
    private TextView line2;
    private TextView line3;
    private TextView line4;
    private TextView line5;
    private Button calcular;
    private boolean isDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clapeyron);

        // Declara as variáveis e referencia os itens
        p = (EditText) findViewById(R.id.p);
        V = (EditText) findViewById(R.id.V);
        n = (EditText) findViewById(R.id.n);
        r = (EditText) findViewById(R.id.r);
        T = (EditText) findViewById(R.id.T);
        line1 = (TextView) findViewById(R.id.line1);
        line2 = (TextView) findViewById(R.id.line2);
        line3 = (TextView) findViewById(R.id.line3);
        line4 = (TextView) findViewById(R.id.line4);
        line5 = (TextView) findViewById(R.id.line5);
        calcular = (Button) findViewById(R.id.calcular);

        // Define o valor de isDone como false
        isDone = false;

        // Cria um listener para o botão calcular
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solve();
            }
        });
    }

    private void solve(){
        // Declara as variáveis a serem usadas
        Double dp, dv, dn, dr, dt;

        // Previne que ocorram erros
        try{
            dp = Double.valueOf(p.getText().toString());
        }
        catch (Exception e){
            dp = null;
        }

        try{
            dv = Double.valueOf(V.getText().toString());
        }
        catch (Exception e){
            dv = null;
        }

        try{
            dn = Double.valueOf(n.getText().toString());
        }
        catch (Exception e){
            dn = null;
        }

        try{
            dr = Double.valueOf(r.getText().toString());
        }
        catch (Exception e){
            dr = null;
        }

        try{
            dt = Double.valueOf(T.getText().toString());
        }
        catch (Exception e){
            dt = null;
        }

        // Verifica o valor de isDone para realizar o calculo
        if (!isDone){
            // Define o valor de isDone como true
            isDone = true;

            // Verifica as possibilidades de calculo
            if (dp == null && dv != null && dn != null && dr != null && dt != null){
                // Define a visibilidade das linhas
                line1.setVisibility(VISIBLE);
                line2.setVisibility(VISIBLE);
                line3.setVisibility(VISIBLE);
                line4.setVisibility(VISIBLE);
                line5.setVisibility(VISIBLE);

                line1.setText("p * " + String.valueOf(dv) + " = " + String.valueOf(dn) + " * "
                        + String.valueOf(dr) + " * " + String.valueOf(dt));
                line2.setText("p * " + String.valueOf(dv) + " = " + String.format("%.2f", dn * dr)
                        + String.valueOf(dt));
                line3.setText("p * " + String.valueOf(dv) + " = " +
                        String.format("%.2f", dn * dr * dt));
                line4.setText("p = " + String.format("%.2f", dn * dr * dt) + "/" +
                        String.valueOf(dv));
                line5.setText("p = " + String.format("%.2f", (dn * dr * dt)/dv));

                // Altera o estilo do botão
                calcular.setBackgroundColor(ContextCompat.getColor(this,
                        R.color.clearButton));
                calcular.setText(R.string.limpar);
            }
            else if (dp != null && dv == null && dn != null && dr != null && dt != null){
                // Define a visibilidade das linhas
                line1.setVisibility(VISIBLE);
                line2.setVisibility(VISIBLE);
                line3.setVisibility(VISIBLE);
                line4.setVisibility(VISIBLE);

                line1.setText(String.valueOf(dp) + " * V = " + String.valueOf(dn) + " * " +
                        String.valueOf(dr) + " * " + String.valueOf(dt));
                line2.setText(String.valueOf(dp) + " * V = " + String.format("%.2f", dn * dr)
                        + " * " + String.valueOf(dt));
                line2.setText(String.valueOf(dp) + " * V = " +
                        String.format("%.2f", dn * dr *  dt));
                line3.setText("V = " + String.format("%.2f", dn * dr *  dt) + "/" + String.valueOf(dp));
                line4.setText("V = " + String.format("%.2f", (dn * dr * dt)/dp));

                // Altera o estilo do botão
                calcular.setBackgroundColor(ContextCompat.getColor(this,
                        R.color.clearButton));
                calcular.setText(R.string.limpar);
            }
            else if (dp != null && dv != null && dn == null && dr != null && dt != null){
                // Define a visibilidade das linhas
                line1.setVisibility(VISIBLE);
                line2.setVisibility(VISIBLE);
                line3.setVisibility(VISIBLE);
                line4.setVisibility(VISIBLE);
                line5.setVisibility(VISIBLE);

                line1.setText(String.valueOf(dp) + " * " + String.valueOf(dv) + " = n * " +
                        String.valueOf(dr) + " * " + String.valueOf(dt));
                line2.setText(String.format("%.2f", dp * dv) + " = n * " + String.valueOf(dr) +
                        " * " + String.valueOf(dt));
                line3.setText(String.format("%.2f", dp * dv) + " = n * " +
                        String.format("%.2f", dr * dt));
                line4.setText("n = " + String.format("%.2f", dp * dv) + "/" +
                        String.format("%.2f", dr * dt));
                line5.setText("n = " + String.format("%.2f", (dp * dv) / (dr * dt)));

                // Altera o estilo do botão
                calcular.setBackgroundColor(ContextCompat.getColor(this,
                        R.color.clearButton));
                calcular.setText(R.string.limpar);
            }
            else if (dp != null && dv != null && dn != null && dr == null && dt != null){
                // Define a visibilidade das linhas
                line1.setVisibility(VISIBLE);
                line2.setVisibility(VISIBLE);
                line3.setVisibility(VISIBLE);
                line4.setVisibility(VISIBLE);
                line5.setVisibility(VISIBLE);

                line1.setText(String.valueOf(dp) + " * " + String.valueOf(dv) + " = " +
                        String.valueOf(dn) + " *  R * " + String.valueOf(dt));
                line2.setText(String.format("%.2f", dp * dv) + " = " + String.valueOf(dn) +
                        " * R * " + String.valueOf(dt));
                line3.setText(String.format("%.2f", dp * dv) + " = R * " +
                        String.format("%.2f", dn * dt));
                line4.setText("R = " + String.format("%.2f", dp * dv) + "/" +
                        String.format("%.2f", dn * dt));
                line5.setText("R = " + String.format("%.2f", (dp * dv) / (dn * dt)));

                // Altera o estilo do botão
                calcular.setBackgroundColor(ContextCompat.getColor(this,
                        R.color.clearButton));
                calcular.setText(R.string.limpar);
            }
            else if (dp != null && dv != null && dn != null && dr != null && dt == null){
                // Define a visibilidade das linhas
                line1.setVisibility(VISIBLE);
                line2.setVisibility(VISIBLE);
                line3.setVisibility(VISIBLE);
                line4.setVisibility(VISIBLE);
                line5.setVisibility(VISIBLE);

                line1.setText(String.valueOf(dp) + " * " + String.valueOf(dv) + " = " +
                        String.valueOf(dn) + " * " + String.valueOf(dr) + " * T");
                line2.setText(String.format("%.2f", dp * dv) + " = " +
                        String.valueOf(dn) + " * " + String.valueOf(dr) + " * T");
                line3.setText(String.format("%.2f", dp * dv) + " = " +
                        String.format("%.2f", dn * dr) + " * T");
                line4.setText("T = " + String.format("%.2f", dp * dv) + "/" +
                        String.format("%.2f", dn * dr));
                line5.setText("T = " + String.format("%.2f", (dp * dv) / (dn * dr)));

                // Altera o estilo do botão
                calcular.setBackgroundColor(ContextCompat.getColor(this,
                        R.color.clearButton));
                calcular.setText(R.string.limpar);
            }
            else if (dp == null && dv == null && dn == null && dr == null && dt == null){
                TudoPreenchido td = new TudoPreenchido();
                td.show(getFragmentManager(), null);
            }
            else{
                EmptyFragment em = new EmptyFragment();
                em.show(getSupportFragmentManager(), null);
            }
        }
        else{
            // Define o valor de isDone como false
            isDone = false;

            // Apaga os textos
            p.setText("");
            V.setText("");
            n.setText("");
            r.setText("");
            T.setText("");

            // Define a visibilidade das linhas
            line1.setVisibility(GONE);
            line2.setVisibility(GONE);
            line3.setVisibility(GONE);
            line4.setVisibility(GONE);
            line5.setVisibility(GONE);

            // Redefino o estilo do botão calcular
            calcular.setBackgroundColor(ContextCompat.getColor(this, R.color.AppThemeBlue));
            calcular.setText(R.string.Calc);
        }
    }
}
