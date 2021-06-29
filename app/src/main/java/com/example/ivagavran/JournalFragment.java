package com.example.ivagavran;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class JournalFragment extends Fragment
{
    EditText etValue;
    Button btAdd;
    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> adapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_journal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etValue =view.findViewById(R.id.et_value);
        btAdd = view.findViewById(R.id.bt_add);
        listView = view.findViewById(R.id.list_view);

        adapter = new ArrayAdapter<>(getActivity()
                , android.R.layout.simple_list_item_1, arrayList);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Data");

        getValue();

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sValue = etValue.getText().toString().trim();

                String sKey = databaseReference.push().getKey();

                if(sKey != null){

                    databaseReference.child(sKey).child("value").setValue(sValue);

                    etValue.setText(" ");
                }
            }
        });
    }

    private void getValue() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                    String sValue = dataSnapshot.child("value").getValue(String.class);

                    arrayList.add(sValue);
                }

                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity()
                        ,error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}