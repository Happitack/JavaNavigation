package clu.tec.navigate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtFromCaller;
    Button btnBack;
    EditText txtToCaller;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtFromCaller = findViewById(R.id.txtFromCaller);
        txtToCaller = findViewById(R.id.txtToCaller);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        intent = getIntent();
        String text = intent.getStringExtra("textFromCaller");
        txtFromCaller.setText(text);
    }

    @Override
    public void onClick(View v) {
        intent.putExtra("textFromSecond",txtToCaller.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}