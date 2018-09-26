package com.whitney.nyaradzowalkathon;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.regBtn) MaterialButton mButton;
    @BindView(R.id.sex) RadioGroup radioGroup;
    @BindView(R.id.shirtSize) Spinner mSpinner;
    TextInputEditText nameField, phoneField, emergencyField, emailField, nationalityField, companyField;
    RadioButton radioButton;

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String[] sizes = {"", "Small", "Medium", "Large", "XLarge"};
    private String userId;
    private DatabaseReference mFirebaseDatabase;
    FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        /*Offline data ability but it is causing the app to crash. Uncomment if bug is fixed*/
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        // instantiate the DB
        mFirebaseInstance = FirebaseDatabase.getInstance();
        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("users");

        nameField = findViewById(R.id.nameText);
        phoneField = findViewById(R.id.phoneText);
        emergencyField = findViewById(R.id.emergencyText);
        emailField = findViewById(R.id.emailText);
        nationalityField = findViewById(R.id.nationalityText);
        companyField = findViewById(R.id.companyText);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
                radioButton = radioGroup.findViewById(checkedId);
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, sizes);
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(position)
                        +" shirtSize", Toast.LENGTH_SHORT);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView1 = (TextView) mSpinner.getSelectedView();
                String name = nameField.getEditableText().toString().trim();
                String phone = phoneField.getEditableText().toString().trim();
                String gender = radioButton.getText().toString();
                String shirtSize = textView1.getText().toString();
                String emergency = emergencyField.getEditableText().toString().trim();
                String email = emailField.getEditableText().toString().trim();
                String nationality = nationalityField.getEditableText().toString().trim();
                String company = companyField.getEditableText().toString().trim();

                checkUserId(name, phone, gender, shirtSize, emergency, email,
                        nationality, company);
            }
        });
//        toggleButton();
    }

    private void checkUserId(String name, String phone, String gender, String email, String company,
                             String emergency, String shirtSize, String nationality) {
        // Check for already existed userId
        if (TextUtils.isEmpty(userId)) {
            createUser(name, phone, gender, shirtSize, emergency, nationality, company,email);
        } else {
            updateUser(name, phone, gender, shirtSize, emergency, nationality, company, email);
        }
    }

//    private void toggleButton() {
//        if (TextUtils.isEmpty(userId)) {
//            mButton.setText(R.string.save);
//        } else {
//            mButton.setText(R.string.update);
//        }
//    }

    private void updateUser(String name, String phone, String gender, String shirtSize,
                            String emergency, String nationality, String company, String email) {
        // updating the user via child nodes
        if (!TextUtils.isEmpty(name))
            mFirebaseDatabase.child(userId).child("Name").setValue(name);

        if (!TextUtils.isEmpty(phone))
            mFirebaseDatabase.child(userId).child("Phone").setValue(phone);

        if (!TextUtils.isEmpty(gender))
            mFirebaseDatabase.child(userId).child("Gender").setValue(gender);

        if (!TextUtils.isEmpty(shirtSize))
            mFirebaseDatabase.child(userId).child("T-shirt Size").setValue(shirtSize);

        if (!TextUtils.isEmpty(emergency))
            mFirebaseDatabase.child(userId).child("Emergency Contact").setValue(emergency);

        if (!TextUtils.isEmpty(nationality))
            mFirebaseDatabase.child(userId).child("Nationality").setValue(nationality);

        if (!TextUtils.isEmpty(company))
            mFirebaseDatabase.child(userId).child("Company").setValue(company);

        if (!TextUtils.isEmpty(email))
            mFirebaseDatabase.child(userId).child("Email").setValue(email);
    }

    private void createUser(String name, String phone, String gender, String shirtSize,
                            String emergency, String nationality, String company, String email) {
        if (TextUtils.isEmpty(userId)) {
            userId = mFirebaseDatabase.push().getKey();
        }

        User user = new User(name, phone, gender, shirtSize, emergency, nationality, company, email);
        mFirebaseDatabase.child(userId).setValue(user);
        addUserChangeListener();
    }

    private void addUserChangeListener() {
        // User data change listener
        mFirebaseDatabase.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                // Check for null
                if (user == null) {
                    Log.e(TAG, "User data is null!");
                    return;
                }

                Log.e(TAG, String.format("User data is changed!%s, %s%s%s", user.name,
                        user.email, user.gender, user.phone));

                clearSetValues();
//                toggleButton();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read user", error.toException());
            }
        });
    }

    private void clearSetValues() {
        nameField.getEditableText().clear();
        phoneField.getEditableText().clear();
        radioGroup.clearCheck();
        emergencyField.getEditableText().clear();
        nationalityField.getEditableText().clear();
        mSpinner.setAdapter(new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_dropdown_item_1line, sizes));
        companyField.getEditableText().clear();
        emailField.getEditableText().clear();
    }
}