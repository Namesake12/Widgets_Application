package widgets.com.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProcessForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_form);
        TextView t1 = (TextView) findViewById(R.id.textView);
        String name = getIntent().getStringExtra("gender");
        t1.setText("Welcome "+ name);
    }
}
