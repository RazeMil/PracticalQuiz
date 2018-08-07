package sg.edu.rp.c346.practicalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView tvText;
    Spinner spnSite;
    WebView wvSite;

    ArrayList<String> alSite;
    ArrayAdapter<String> aaSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = findViewById(R.id.textViewSite);
        spnSite = findViewById(R.id.spinnerSite);
        wvSite = findViewById(R.id.webViewSite);

        alSite = new ArrayList<>();

        String[] strSite = getResources().getStringArray(R.array.website);
        alSite.addAll(Arrays.asList(strSite));

        aaSite = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alSite);
        spnSite.setAdapter(aaSite);

        spnSite.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int Site = spnSite.getSelectedItemPosition();


                if (Site == 0) {
                    String url = "https://www.google.com/";
                    wvSite.loadUrl(url);


                } else {
                    String url = "https://www.rp.edu.sg/";
                    wvSite.loadUrl(url);

                }aaSite.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}

