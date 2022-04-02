package ha.ax.it.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final DecimalFormat REAL_FORMATTER = new DecimalFormat("0.###");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculate = findViewById(R.id.button);
        EditText priceInput = findViewById(R.id.editTextNumberDecimal);
        EditText percentageInput = findViewById(R.id.editTextNumberDecimal2);
        TextView baseAmount = findViewById(R.id.textView3);
        TextView totalAmount = findViewById(R.id.textView4);
        TextView totalTipAmount = findViewById(R.id.textView6);

        calculate.setOnClickListener(view -> {
            if (validateInput(priceInput) && validateInput(percentageInput)) {
                if (priceInput.getText() != null && percentageInput.getText() != null) {
                    final double percentage = Integer.parseInt(percentageInput.getText().toString());
                    final double base = Integer.parseInt(priceInput.getText().toString());
                    final double totalTip = base * (percentage / 100);
                    final double totalCostAmount = (int)(base + totalTip);
                    final String formattedBaseValue = "Base: " + REAL_FORMATTER.format(base)+ "€";
                    final String formattedTotalTipValue = "Tip: " + REAL_FORMATTER.format(totalTip) + "%";
                    final String formattedTotalCostValue = "Total cost: " + REAL_FORMATTER.format(totalCostAmount) + "€";
                    baseAmount.setText(formattedBaseValue);
                    totalAmount.setText(formattedTotalCostValue);
                    totalTipAmount.setText(formattedTotalTipValue);
                    priceInput.setText("");
                    percentageInput.setText("");
                }
            }
        });
    }

    private boolean validateInput(EditText text) {
        return text.length() != 0;
    }
}