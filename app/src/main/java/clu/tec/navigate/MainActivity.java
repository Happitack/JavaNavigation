package clu.tec.navigate;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityResultLauncher<Intent> nameActivityLauncher, colorActivityLauncher;
    TextView txtFromName;
    Button btnGoToName;
    Button btnGoToColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFromName = findViewById(R.id.txtFromName);
        btnGoToName = findViewById(R.id.btnToName);
        btnGoToColor = findViewById(R.id.btnToColor);
        btnGoToName.setOnClickListener(this);
        btnGoToColor.setOnClickListener(this);

        nameActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == Activity.RESULT_OK)
                    {
                        Intent intent = result.getData();
                        String text = intent.getStringExtra("textFromName");
                        txtFromName.setText(text);
                    }
                }
        );
        colorActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == Activity.RESULT_OK)
                    {
                        Intent intent = result.getData();
                        int color = intent.getIntExtra("savedColor", 0);
                        txtFromName.setBackgroundColor(color);
                    }
                }
        );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnToName:
                Intent intentName = new Intent(this, GetNameActivity.class);
                nameActivityLauncher.launch(intentName);
                break;
            case R.id.btnToColor:
                Intent intentColor = new Intent(this, GetColorActivity.class);
                colorActivityLauncher.launch(intentColor);
                break;
        }
    }
}