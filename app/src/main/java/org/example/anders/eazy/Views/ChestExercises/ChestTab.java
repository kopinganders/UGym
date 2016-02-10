package org.example.anders.eazy.Views.ChestExercises;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.example.anders.eazy.R;


/**
 * Created by Anders on 2015-12-13.
 */
public class ChestTab extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View android = inflater.inflate(R.layout.chest_frag, container, false);
        ((TextView)android.findViewById(R.id.textView)).setText("Chest");
        return android;
    }

}
