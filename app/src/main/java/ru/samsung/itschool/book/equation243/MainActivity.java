package ru.samsung.itschool.book.equation243;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Вызывается при создании Активности
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Инициализирует Активность.
        setContentView(R.layout.activity_main);
    }

    /** Вызывается при нажатии пользователем на кнопку Решить */
        @SuppressLint("SetTextI18n")
        public void solveEquation(View view) {
             // ax^2+bx+c=0
            double a = Double.parseDouble( ((EditText)
                    findViewById(R.id.coefficient_a)).getText().toString());
            double b = Double.parseDouble( ((EditText)
                    findViewById(R.id.coefficient_b)).getText().toString());
            double c = Double.parseDouble( ((EditText)
                    findViewById(R.id.coefficient_c)).getText().toString());
            TextView result = (TextView) findViewById(R.id.result);
            // найдём дискриминант
            double D = b * b - 4 * a * c;

            // если A равно нулю, то уравнение линейное: Bx + C = 0
            if (a == 0) {

                // Bx = -C => x = -C / B
                if (b != 0) {
                    result.setText("" + String.valueOf(- c / b));
                }
                // если B равно нулю, корней нет

            } else if (D == 0) {  // случай с нулевым дискриминантом

                // корень ровно один
                result.setText("" + String.valueOf( - b / (2*a)));
            } else if (D > 0) {  // в случае с положительным дискриминантом корня два

                double x1 = (-b + Math.sqrt(D)) / (2 * a);
                double x2 = (-b - Math.sqrt(D)) / (2 * a);
                result.setText(x1 + " " + x2);
            }
            // если дискриминант отрицателен, действительных корней нет
        }

}
