package com.example.hamburgueriaz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNome;
    private CheckBox cbBacon, cbQueijo, cbOnion;
    private TextView tvQuantidade, tvTotal;
    private Button btnMais;
    private Button btnMenos;
    private Button btnPedido;

    private int quantidade = 0;

    private static final double PRECO_BASE = 20.0;
    private static final double PRECO_BACON = 2.0;
    private static final double PRECO_QUEIJO = 2.0;
    private static final double PRECO_ONION = 3.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupListeners();
    }

    private void initViews() {
        etNome = findViewById(R.id.etNome);
        cbBacon = findViewById(R.id.cbBacon);
        cbQueijo = findViewById(R.id.cbQueijo);
        cbOnion = findViewById(R.id.cbOnion);

        tvQuantidade = findViewById(R.id.tvQuantidade);
        tvTotal = findViewById(R.id.tvTotal);

        btnMais = findViewById(R.id.btnMais);
        btnMenos = findViewById(R.id.btnMenos);
        btnPedido = findViewById(R.id.btnPedido);
    }

    private void setupListeners() {

        btnMais.setOnClickListener(v -> {
            quantidade++;
            atualizarQuantidade();
        });

        btnMenos.setOnClickListener(v -> {
            if (quantidade > 0) {
                quantidade--;
                atualizarQuantidade();
            }
        });

        cbBacon.setOnCheckedChangeListener((buttonView, isChecked) -> calcularEExibirPrecoTemporario());
        cbQueijo.setOnCheckedChangeListener((buttonView, isChecked) -> calcularEExibirPrecoTemporario());
        cbOnion.setOnCheckedChangeListener((buttonView, isChecked) -> calcularEExibirPrecoTemporario());

        btnPedido.setOnClickListener(v -> enviarPedido());
    }

    private void atualizarQuantidade() {
        tvQuantidade.setText(String.valueOf(quantidade));
        calcularEExibirPrecoTemporario();
    }

    private void calcularEExibirPrecoTemporario() {
        double total = somarValorTotal();
        tvTotal.setText("R$ " + String.format("%.2f", total));
    }

    private double somarValorTotal() {
        double precoHambúrguer = PRECO_BASE;

        if (cbBacon.isChecked()) precoHambúrguer += PRECO_BACON;
        if (cbQueijo.isChecked()) precoHambúrguer += PRECO_QUEIJO;
        if (cbOnion.isChecked()) precoHambúrguer += PRECO_ONION;

        return precoHambúrguer * quantidade;
    }

    private void enviarPedido() {
        String nome = etNome.getText().toString();
        boolean temBacon = cbBacon.isChecked();
        boolean temQueijo = cbQueijo.isChecked();
        boolean temOnion = cbOnion.isChecked();
        double precoFinal = somarValorTotal();

        String resumo = "Nome do cliente: " + nome + "\n" +
                "Tem Bacon? " + (temBacon ? "Sim" : "Não") + "\n" +
                "Tem Queijo? " + (temQueijo ? "Sim" : "Não") + "\n" +
                "Tem Onion Rings? " + (temOnion ? "Sim" : "Não") + "\n" +
                "Quantidade: " + quantidade + "\n" +
                "Preço final: R$ " + String.format("%.2f", precoFinal);

        tvTotal.setText(resumo);

        // Intent para chamar aplicativos de e-mail
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:eduardorodigoalmeida18@gmail.com")); // Apenas apps de e-mail devem tratar isso
        intent.putExtra(Intent.EXTRA_SUBJECT, "Pedido de " + nome);
        intent.putExtra(Intent.EXTRA_TEXT, resumo);

        // Verifica se existe um app que possa responder ao intent antes de iniciar
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}