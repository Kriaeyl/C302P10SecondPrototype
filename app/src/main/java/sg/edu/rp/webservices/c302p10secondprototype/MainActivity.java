package sg.edu.rp.webservices.c302p10secondprototype;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2, et3;
    Spinner spn;
    Button b1;
    CheckBox cb1;

    FirebaseFirestore db;
    CollectionReference cr;
    DocumentReference dr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseFirestore.getInstance();
        cr = db.collection("petBoarding");
        dr = cr.document("petBoarding");

        et1 = findViewById(R.id.editText);
        et2 = findViewById(R.id.editText2);
        et3 = findViewById(R.id.editText3);
        b1 = findViewById(R.id.button);
        cb1 = findViewById(R.id.checkBox);
        spn = findViewById(R.id.spinner);
        ArrayList<String> al = new ArrayList<>(Arrays.asList("cat", "dog", "rock", "child"));
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, al);
        spn.setAdapter(aa);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                petBoarding petBoarding = new petBoarding(et1.getText().toString(), et2.getText().toString(), spn.getSelectedItem().toString(), et3.getText().toString(), cb1.isChecked());
                dr.set(petBoarding);
            }
        });
    }
}