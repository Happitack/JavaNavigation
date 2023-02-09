package clu.tec.navigate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetColorActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinnerRed, spinnerGreen, spinnerBlue;
    Button btnSendColor;
    TextView layout_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        layout_color = findViewById(R.id.layout_color);
        btnSendColor = findViewById(R.id.btnSendColor);
        btnSendColor.setOnClickListener(this);

        // Initialize spinners
        spinnerRed = findViewById(R.id.spinner_red);
        spinnerGreen = findViewById(R.id.spinner_green);
        spinnerBlue = findViewById(R.id.spinner_blue);

        // Create a list of hex values
        List<String> hexValues = new ArrayList<>(Arrays.asList(
                "00", "10", "20", "30",
                "40", "50", "60", "70",
                "80", "90", "A0", "B0",
                "C0", "D0", "E0", "F0", "FF"));

        // Create an adapter for the spinners
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, hexValues);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the adapter for each spinner
        spinnerRed.setAdapter(adapter);
        spinnerGreen.setAdapter(adapter);
        spinnerBlue.setAdapter(adapter);

        // Set a listener on each spinner to change the background color
        spinnerRed.setOnItemSelectedListener(new SpinnerSelectionListener());
        spinnerGreen.setOnItemSelectedListener(new SpinnerSelectionListener());
        spinnerBlue.setOnItemSelectedListener(new SpinnerSelectionListener());

    }

    private class SpinnerSelectionListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            String red = (String) spinnerRed.getSelectedItem();
            String green = (String) spinnerGreen.getSelectedItem();
            String blue = (String) spinnerBlue.getSelectedItem();

            int color = Color.parseColor("#" + red + green + blue);
            View layout = findViewById(R.id.layout_color);
            layout.setBackgroundColor(color);
        }
        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            // Do nothing
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        TextView colorContainer = findViewById(R.id.layout_color);
        Drawable backgroundDrawable = colorContainer.getBackground();
        int savedColor = ((ColorDrawable) backgroundDrawable).getColor();

        intent.putExtra("savedColor", savedColor);
        setResult(RESULT_OK, intent);
        finish();
    }
}