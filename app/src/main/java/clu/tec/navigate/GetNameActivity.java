package clu.tec.navigate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GetNameActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnBack;
    EditText txtToCaller;
    TextView textView;
    RadioGroup radioGroup;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        RadioGroup radioGroup = findViewById(R.id.radio_group);
        textView = findViewById(R.id.textViewName);
        txtToCaller = findViewById(R.id.txtToCaller);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadioButton = group.findViewById(checkedId);
                String selectedRadioButtonText = selectedRadioButton.getText().toString();
                textView.setText(selectedRadioButtonText + "'s name: ");
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        TextView textView = findViewById(R.id.textViewName);
        String textViewText = textView.getText().toString();
        String enteredName = txtToCaller.getText().toString();
        String collectedName = textViewText + enteredName;

        intent.putExtra("textFromName",collectedName);
        setResult(RESULT_OK, intent);
        finish();
    }
}