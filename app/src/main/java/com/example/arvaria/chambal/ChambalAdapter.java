package com.example.arvaria.chambal;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arvaria.Person;
import com.example.arvaria.R;
import com.example.arvaria.UpdateRecordActivity;

import java.util.List;

public class ChambalAdapter extends RecyclerView.Adapter<ChambalAdapter.ViewHolder> {
    private List<Person> ChambalList;
    private Context mContext;
    private RecyclerView cRecyclerV;
    @NonNull
    @Override
    public ChambalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.single_row,parent,false);
        ViewHolder ch=new ViewHolder(v);
        return ch;
    }

    @Override
    public void onBindViewHolder(@NonNull ChambalAdapter.ViewHolder holder, final int position) {
        final Person person= ChambalList.get(position);
        holder.chambalNameTxtV.setText("Variant: " + person.getName());
        holder.chambalAgeTxtV.setText("Boxes: " + person.getAge());
        holder.chambalOccupationTxtV.setText("Packing: " + person.getOccupation());
        holder.Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("Choose option");
                builder.setMessage("Update or delete Variant?");
                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //go to update activity
                        goToUpdateActivity(person.getId());

                    }
                });
                builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ChambalDBHelper dbHelper = new ChambalDBHelper(mContext);
                        dbHelper.deleteChambalRecord(person.getId(), mContext);

                       ChambalList.remove(position);
                        cRecyclerV.removeViewAt(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, ChambalList.size());
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();

            }
        });
    }
    private void goToUpdateActivity(long personId){

        Intent goToUpdate = new Intent(mContext, UpdateChambalRecordActivity.class);
        goToUpdate.putExtra("USER_ID", personId);
        mContext.startActivity(goToUpdate);
    }


    @Override
    public int getItemCount() {
        return ChambalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView chambalNameTxtV;
        public TextView chambalAgeTxtV;
        public TextView chambalOccupationTxtV;
        public View Layout;
        public ViewHolder(View v) {
            super(v);
            Layout=v;
            chambalNameTxtV=(TextView)v.findViewById(R.id.name);
            chambalAgeTxtV = (TextView) v.findViewById(R.id.age);
            chambalOccupationTxtV = (TextView) v.findViewById(R.id.occupation);
        }
    }
    public void add(int position, Person person) {
        ChambalList.add(position, person);
        notifyItemInserted(position);
    }
    public void remove(int position) {
        ChambalList.remove(position);
        notifyItemRemoved(position);
    }
    public ChambalAdapter(List<Person> myDataset, Context context, RecyclerView recyclerView) {
        ChambalList = myDataset;
        mContext = context;
        cRecyclerV = recyclerView;
    }

}
