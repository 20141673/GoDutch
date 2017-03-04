package cn.edu.cqu.godutch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String amount;
    EditText totalAmount,persNbr;
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalAmount=(EditText)findViewById(R.id.etAmount);
        persNbr=(EditText)findViewById(R.id.etNbr);
        display=( TextView)findViewById(R.id.tvAmountPerPerson);

    }
    public void btnCompute(View v){
        //Check if the number of persons has been entered
        if(persNbr.getText().toString().length()<1||totalAmount.getText().toString().length()<0){
            Toast.makeText(getBaseContext(), "Please enter the number of persons or Amount", Toast.LENGTH_SHORT).show();
        }
        else {
            Double total = Double.parseDouble(totalAmount.getText().toString());
            Double persons = Double.parseDouble(persNbr.getText().toString());

            if (persons == 0) {             //check if the number of person is 0
                Toast.makeText(getBaseContext(), "The number of persons can't be 0 ", Toast.LENGTH_SHORT).show();
            } else {
                Double share = total / persons;
                share = Double.valueOf(Math.round(share * 100));
                share = share / 100;
                Toast.makeText(getBaseContext(), "The amount to share is " + share, Toast.LENGTH_SHORT).show();
                display.setText("The amount to share is" + share);
            }
        }
    }
}
