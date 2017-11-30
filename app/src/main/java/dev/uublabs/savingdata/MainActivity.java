package dev.uublabs.savingdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private EditText etDataSharedPref;
    private TextView tvDisplaySharedPref;
    private EditText etPersonGender;
    private EditText etPersonName;
    private TextView tvDisplaySQL;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //view for shared pref
        etDataSharedPref = findViewById(R.id.etDataToBeSaved);
        tvDisplaySharedPref = findViewById(R.id.tvDisplayDataSharedPref);
        //view for sql
        etPersonGender = findViewById(R.id.etPersonGender);
        etPersonName = findViewById(R.id.etPersonName);
        tvDisplaySQL = findViewById(R.id.tvDisplayDataSQL);
    }

    public void handlingDataSharedPref(View view)
    {
        //Shared preferences instance
        SharedPreferences sharedPreferences = getSharedPreferences("mySharedPref", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();


        //create switch case for each button view
        switch (view.getId()) {
            case R.id.btnSaveDataSharedPref: {
                editor.putString("key", etDataSharedPref.getText().toString());
                boolean isSaved = editor.commit();
                if (isSaved) {
                    Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.btnGetDataSharedPref: {
                String data = sharedPreferences.getString("key", "default");
                tvDisplaySharedPref.setText(data);

                break;
            }
            case R.id.btnClearDataSharedPref: {
                editor.clear();
                boolean isCleared = editor.commit();
                if (isCleared) {
                    Toast.makeText(this, "Cleared data", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    public void handlingDataSQL(View view)
    {

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        switch (view.getId())
        {
            case R.id.btnSaveDataSQL:
            {
                String name = etPersonName.getText().toString();
                String gender = etPersonGender.getText().toString();
                Person person = new Person(name, gender);
                long row = databaseHelper.savePerson(person);
                String toastString;
                if(row>0)
                    toastString = "Saved at:" + row;
                else
                    toastString = "Not saved";
                Toast.makeText(this, toastString, Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btnGetDataSQL:
            {
                tvDisplaySQL.setText(databaseHelper.getPersons().toString());
                break;
            }
        }

    }
}
