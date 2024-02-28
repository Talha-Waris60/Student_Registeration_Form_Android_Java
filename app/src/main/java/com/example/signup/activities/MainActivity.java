package com.example.signup.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.signup.databinding.ActivityMainBinding;
import com.example.signup.databinding.LayoutDialogueBoxBinding;
import com.example.signup.model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private final String matchEmail = "izyan@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setUpListeners();

    }

    private void setUpListeners() {

        binding.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserData();
            }
        });

        binding.clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.nameEditText.getText().clear();
                binding.emailEditText.getText().clear();
                binding.passwordEditText.getText().clear();
                binding.confirmEditText.getText().clear();
                binding.birthEditText.getText().clear();
                binding.cityEditText.getText().clear();
                binding.countryEditText.getText().clear();
                binding.maleRadioButton.setChecked(false);
                binding.femaleRadioButton.setChecked(false);
                binding.beginnerRadioButton.setChecked(false);
                binding.advanceRadioButton.setChecked(false);
                binding.cricketCheckBox.setChecked(false);
                binding.hockeyCheckBox.setChecked(false);
                binding.footballCheckBox.setChecked(false);
                binding.termsCheckBox.setChecked(false);
            }
        });

        binding.maleRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Male radio button is selected, remove focus from female radio button
                    binding.femaleRadioButton.setChecked(false);
                }
            }
        });

        binding.femaleRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Female radio button is selected, remove focus from male radio button
                    binding.maleRadioButton.setChecked(false);
                }
            }
        });


        binding.beginnerRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Male radio button is selected, remove focus from female radio button
                    binding.advanceRadioButton.setChecked(false);
                }
            }
        });

        binding.advanceRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Female radio button is selected, remove focus from male radio button
                    binding.beginnerRadioButton.setChecked(false);
                }
            }
        });
    }

    private void getUserData() {
        String name = binding.nameEditText.getText().toString();
        String email = binding.emailEditText.getText().toString();
        String password = binding.passwordEditText.getText().toString();
        String confirm = binding.confirmEditText.getText().toString();
        String birth = binding.birthEditText.getText().toString();
        String city = binding.cityEditText.getText().toString();
        String country = binding.countryEditText.getText().toString();
        boolean isMale = binding.maleRadioButton.isChecked();
        boolean isFemale = binding.femaleRadioButton.isChecked();
        boolean isBeginner = binding.beginnerRadioButton.isChecked();
        boolean isAdvance = binding.advanceRadioButton.isChecked();
        boolean hasCricket = binding.cricketCheckBox.isChecked();
        boolean hasHockey = binding.hockeyCheckBox.isChecked();
        boolean hasFootball = binding.footballCheckBox.isChecked();
        boolean acceptsTerms = binding.termsCheckBox.isChecked();


        if (!name.isEmpty()) {
            if (!email.isEmpty()) {
                if (email.matches(emailPattern) && email.equals(matchEmail)) {
                    if (!password.isEmpty()) {
                        if (password.equals(confirm)) {
                            if (!birth.isEmpty()) {
                                if (!city.isEmpty()) {
                                    if (acceptsTerms) {
                                        Student studentModel = new Student(name, email, password, confirm, birth, city, country,
                                                isMale, isFemale, isBeginner, isAdvance, hasCricket, hasHockey, hasFootball, acceptsTerms);
                                        dialogueBox(studentModel);
                                    } else {
                                        showToast("Please check Terms and Conditions");
                                    }
                                } else {
                                    binding.cityEditText.setError("Field is Empty");
                                }
                            } else {
                                binding.birthEditText.setError("Field is Empty");
                            }
                        } else {
                            binding.confirmEditText.setError("Passwords do not match");
                        }
                    } else {
                        binding.passwordEditText.setError("Field is Empty");
                    }
                } else {
                    binding.emailEditText.setError("Enter Correct Email");
                }
            } else {
                binding.emailEditText.setError("Field is Empty");
            }
        } else {
            binding.nameEditText.setError("Field is Empty");
        }

    }

    private void dialogueBox(Student model) {
        LayoutDialogueBoxBinding dialogBinding = LayoutDialogueBoxBinding.inflate(getLayoutInflater());
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setView(dialogBinding.getRoot())
                .create();

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.show();

        if (alertDialog.getWindow() != null) {
            WindowManager.LayoutParams layoutParams = alertDialog.getWindow().getAttributes();
            layoutParams.width = 600;
            layoutParams.height = 900;
            layoutParams.gravity = Gravity.CENTER_VERTICAL;
            alertDialog.getWindow().setAttributes(layoutParams);
        }

        // Set properties
        dialogBinding.welcomePersonTv.setText("Welcome, " + model.getName());
        dialogBinding.emailPerson.setText("Email: " + model.getEmail());
        dialogBinding.birthPerson.setText("Birth: " + model.getBirth());
        dialogBinding.cityPerson.setText("Location: " + model.getCity() + ", " + model.getCountry());
        // Display selected sports
        ArrayList<String> selectedSports = new ArrayList<>();
        if (model.isHasCricket()) {
            selectedSports.add("Cricket");
        }
        if (model.isHasHockey()) {
            selectedSports.add("Hockey");
        }
        if (model.isHasFootball()) {
            selectedSports.add("Football");
        }
        String sportsText = selectedSports.isEmpty() ? "None" : String.join(", ", selectedSports);
        dialogBinding.sportsPerson.setText("Sports: " + sportsText);

        // Display selected skill
        dialogBinding.skillPerson.setText("Skills: " + (model.isAdvance() ? "Advance" : "Beginner"));

        // Display selected gender
        dialogBinding.genderPerson.setText("Gender: " + (model.isMale() ? "Male" : "Female"));

        dialogBinding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        dialogBinding.okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}