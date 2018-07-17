package travel.training.ongc.ongccabuser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.text.TextUtils.isEmpty;

public class RequestCabActivity extends AppCompatActivity {

    public EditText personName,departmentName,timeSlot,pickupPont,destination;
    Button submitRequestCab;

    DatabaseReference mDatabase;

    MaterialDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_cab);

        personName = findViewById(R.id.person_name);
        departmentName = findViewById(R.id.department_name);
        timeSlot = findViewById(R.id.time_slot);
        pickupPont = findViewById(R.id.pickup_point);
        destination = findViewById(R.id.destination);
        submitRequestCab = findViewById(R.id.submit_request_cab);


        mDatabase = FirebaseDatabase.getInstance().getReference("Request");
        submitRequestCab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRequestCab();
            }
        });

    }

    public void addRequestCab()
    {

        String sPersonName = personName.getText().toString();
        String sDepartmentName = departmentName.getText().toString();
        String sTimeSlot = timeSlot.getText().toString();
        String sPickupPoint = pickupPont.getText().toString();
        String sDestination = destination.getText().toString();

        if(TextUtils.isEmpty(sPersonName) || TextUtils.isEmpty(sDepartmentName) || TextUtils.isEmpty(sTimeSlot)
                || TextUtils.isEmpty(sPickupPoint) || TextUtils.isEmpty(sDestination))
        {
            Toast.makeText(RequestCabActivity.this, "Field can't be empty", Toast.LENGTH_SHORT).show();
        }
        else
        {
            String id = mDatabase.push().getKey();
            Model model = new Model(id,sPersonName,sDepartmentName,sTimeSlot,sPickupPoint,sDestination);
            mDatabase.child(id).setValue(model);
            dialog = new MaterialDialog.Builder(this)
                    .title("Done")
                    .content("Request is delivered.. \nPlease wait for the confirmation..")
                    .show();
        }

    }

}
