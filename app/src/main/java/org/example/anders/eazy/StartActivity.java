package org.example.anders.eazy;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.List;


public class StartActivity extends Activity {
    Spinner workoutSpinner;
    ArrayAdapter<CharSequence> adapter, timeAdapter,exerciseAdapter;
    Button button;
    ToggleButton togglebutton;
    Spinner setSpinner;
    Spinner timerSpinner;
    ListView excerciseList;
    String selectedWorkout;
    int timeChosen;
    int setsChosen;
    boolean togglebuttonpress=false;

   // ArrayAdapter<Integer> timeAdapter;
   // ArrayAdapter<CharSequence> timeAdapter;

    Integer[] sets= {1,2,3,4,5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //Find all views
        workoutSpinner = (Spinner)findViewById(R.id.spinnerWorkout);
        button =(Button)findViewById(R.id.push_button);
        togglebutton = (ToggleButton) findViewById(R.id.toggleButton1);
        setSpinner=(Spinner)findViewById(R.id.setSpinner);
        timerSpinner=(Spinner)findViewById(R.id.timerSpinner);
        excerciseList=(ListView)findViewById((R.id.listViewExercises));


        timerSpinner.setEnabled(false);
        setSpinner.setEnabled(false);

        final ArrayAdapter<Integer> setsAdapter= new ArrayAdapter<Integer>(this,R.layout.spinner_item,sets);
        setsAdapter.setDropDownViewResource(R.layout.spinner_item);
        adapter =ArrayAdapter.createFromResource(this,R.array.workout_name,android.R.layout.simple_spinner_item);
        timeAdapter =ArrayAdapter.createFromResource(this,R.array.Time_of_rest,R.layout.spinner_item);
        timeAdapter.setDropDownViewResource(R.layout.spinner_item);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getBaseContext(),workoutSpinner.getSelectedItem() +" selected", Toast.LENGTH_LONG).show();
                //button.setBackgroundColor(getResources().getColor(R.color.red));
                if (togglebutton.isChecked()){
                    togglebuttonpress =true;
                    setsChosen = Integer.parseInt(setSpinner.getSelectedItem().toString());
                }
        
                Intent exercise = new Intent(StartActivity.this, ExerciseActivity.class);
                exercise.putExtra("togglebuttonPress",togglebuttonpress);
                exercise.putExtra("workoutName",selectedWorkout);
                exercise.putExtra("timeChosen",timeChosen);
                exercise.putExtra("setsChosen",setsChosen);
                startActivity(exercise);
            }
        });

        togglebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (togglebutton.isChecked()) {
                    setSpinner.setEnabled(true);
                    timerSpinner.setEnabled(true);
                    timerSpinner.setAdapter(timeAdapter);
                    setSpinner.setAdapter(setsAdapter);


                    timerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String timerString=timerSpinner.getSelectedItem().toString();
                            timeChosen = Character.getNumericValue(timerString.charAt(0));

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }
                else {
                    setSpinner.setEnabled(false);
                    timerSpinner.setEnabled(false);

                }}});


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        workoutSpinner.setAdapter(adapter);
        workoutSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG).show();
                String sp1= String.valueOf(workoutSpinner.getSelectedItem());
                if(sp1.contentEquals("Heavy Chest and Arms")){
                    exerciseAdapter= ArrayAdapter.createFromResource(getBaseContext(),R.array.heavy_chest_arms,android.R.layout.simple_list_item_1);
                    excerciseList.setAdapter(exerciseAdapter);
                   // excerciseList.getSelectedItem();

                    exerciseAdapter.notifyDataSetChanged();



            }
                selectedWorkout=workoutSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });










    }

}
