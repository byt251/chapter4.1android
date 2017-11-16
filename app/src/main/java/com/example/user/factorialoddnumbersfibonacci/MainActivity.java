package com.example.user.factorialoddnumbersfibonacci;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView display = (TextView)findViewById(R.id.display);
        final EditText editText = (EditText)findViewById(R.id.editText);

        final String [] out = {" "};
        final String [] output = {""};

        Button factorialButton = (Button)findViewById(R.id.factorialfactorialBtn);
        Button fibonacciButton = (Button)findViewById(R.id.fibonacciBtn);
        Button oddsButton = (Button)findViewById(R.id.oddNumbersBtn);

        factorialButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String input = editText.getText().toString();
                int factorial = 1;
                int n = Integer.parseInt(input);

                while(n>1) {
                    factorial = factorial*n;
                    n--;
                }
                out[0] = String.valueOf(factorial);
                display.setText(out[0]);
            }
        });

        fibonacciButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();
                int n = Integer.parseInt(input);
                Toast.makeText(getApplicationContext(), input, Toast.LENGTH_SHORT).show();
                int i=0;
                int previous = 0;
                int prePrevious = 0;
                int [] outs = new int[n];
                do {
                    if (i==1) {
                        previous = 1;
                    }
                    outs[i] = previous + prePrevious;
                    previous = outs[i];
                    if(i>0) {
                        prePrevious = outs[i - 1];
                    }
                    i++;
                }while(i<n);

                display.setText(Arrays.toString(outs));
            }
        });


        oddsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i , sum = 0;
                String input = editText.getText().toString();
                int n = Integer.parseInt(input);

                for (i = 0; i <= n; i++){
                    if ( (i%2) == 1 ) {
                        sum += i;
                    }
                }
                output[0] = String.valueOf(sum);
                display.setText(output[0]);

            }


        });


    }
}

