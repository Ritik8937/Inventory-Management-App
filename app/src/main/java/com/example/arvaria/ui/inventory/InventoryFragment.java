package com.example.arvaria.ui.inventory;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arvaria.MyCustomAdapter;
import com.example.arvaria.Pictures;
import com.example.arvaria.R;
import com.example.arvaria.User;
import com.example.arvaria.fortune_refined;
import com.example.arvaria.om.Om;
import com.example.arvaria.saffola.Saffola;
import com.example.arvaria.mahakosh.Mahakosh;
import com.example.arvaria.dalda.Dalda;
import com.example.arvaria.dhara.Dhara;
import com.example.arvaria.nature.Nature;
import com.example.arvaria.saloni.Saloni;
import com.example.arvaria.chambal.chambal;
import com.example.arvaria.vibhor.Vibhor;
import com.example.arvaria.rath.Rath;
import com.example.arvaria.gemini.Gemini;


import java.util.ArrayList;
import java.util.List;

public class InventoryFragment extends Fragment {
    RecyclerView mrecyclerview;
    String SpinnerValue;
    String[] oil = { "choose one","refined","mustard","sunflower","rice brain","ghee"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inventory,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

          mrecyclerview=(RecyclerView) getActivity().findViewById(R.id.rec);
          mrecyclerview.setItemAnimator(new DefaultItemAnimator());
          mrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
          userList();
        MyCustomAdapter m = new MyCustomAdapter(getActivity(), userList);
        m.setDeepListener(new MyCustomAdapter.MyListener() {
            @Override
            public void deepItemClick(View view, int position) {
                switch (position)
                {
                    case 0:
//                        AlertDialog.Builder a=new AlertDialog.Builder(getActivity());
//                        View vi=getLayoutInflater().inflate(R.layout.activity_fortune_refine,null);
//                        a.setTitle("Choose Variants");
//                        final Spinner mspinner=(Spinner) vi.findViewById(R.id.fortune_refine_spinner);
//                        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,oil);
//                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                        mspinner.setAdapter(adapter);
//                        a.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                if (!mspinner.getSelectedItem().toString().equalsIgnoreCase("choose one")) {
//                                    int i=mspinner.getSelectedItemPosition();
//                                    SpinnerValue = (String)mspinner.getSelectedItem();
//                                    switch(SpinnerValue)
//                                    {
//                                        case "refined":
                                            Intent it=new Intent(getActivity(), fortune_refined.class);
                                            startActivity(it);
                                         //   break;
//                                        case "rice brain":
//                                            Intent it1=new Intent(getActivity(),fortune_ricebrain.class);
//                                            startActivity(it1);
//                                            break;
//                                        case "mustard":
//                                            Intent it2=new Intent(getActivity(),fortune_mustard.class);
//                                            startActivity(it2);
//                                            break;
//                                        case "sunflower":
//                                            Intent it3=new Intent(getActivity(),fortune_sunflower.class);
//                                            startActivity(it3);
//                                            break;
//                                        default:
//
//                                            Toast.makeText(getActivity(), "Please Select any Value" , Toast.LENGTH_LONG).show();
//
//                                    }
//                                    String str=Integer.toString(i);
//                                    Toast.makeText(getActivity(), mspinner.getSelectedItem().toString() + str , Toast.LENGTH_LONG).show();
//                                    dialog.dismiss();
//                                }
//                            }
//                        });
//                        a.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                            }
//                        });
//
//                        a.setView(vi);
//                        AlertDialog dialog=a.create();
//                        dialog.show();
                           break;
                    case 1:
                        Intent it1=new Intent(getActivity(),chambal.class);
                        startActivity(it1);
                        break;
                    case 2:
                        Intent it2=new Intent(getActivity(), Saloni.class);
                        startActivity(it2);
                        break;
                    case 3:
                        Intent it3=new Intent(getActivity(), Vibhor.class);
                        startActivity(it3);
                        break;
                    case 4:
                        Intent it4=new Intent(getActivity(), Dhara.class);
                        startActivity(it4);
                        break;
                    case 5:
                        Intent it5=new Intent(getActivity(), Dalda.class);
                        startActivity(it5);
                        break;
                    case 6:
                        Intent it6=new Intent(getActivity(), Rath.class);
                        startActivity(it6);
                        break;
                    case 7:
                        Intent it7=new Intent(getActivity(), Nature.class);
                        startActivity(it7);
                        break;
                    case 8:
                        Intent it8=new Intent(getActivity(), Gemini.class);
                        startActivity(it8);
                        break;
                    case 9:
                        Intent it9=new Intent(getActivity(), Mahakosh.class);
                        startActivity(it9);
                        break;
                    case 10:
                        Intent it10=new Intent(getActivity(), Saffola.class);
                        startActivity(it10);
                        break;
                    case 11:
                        Intent it11=new Intent(getActivity(), Om.class);
                        startActivity(it11);
                        break;
//                    case 12:
//                        Intent it12=new Intent(getActivity(), fortune_refined.class);
//                        startActivity(it12);
//                        break;
//
                    default:
                        Toast.makeText(getActivity(),"Ritik",Toast.LENGTH_LONG).show();
                }
                int o=position;
                String str=String.valueOf(o);
                Log.e("checking",str);
//                Intent in=new Intent(getActivity(), detailActivity.class);
//                in.putExtra("deep", userList.get(position));
//                startActivity(in);
            }
        });
        mrecyclerview.setAdapter(m);
    }
    List<User> userList;
    private void userList() {

        userList = new ArrayList<>();

        User u1 = new User();
        u1.setName("Fortune");
        u1.setJob("Techie");
        u1.setImage("https://img.pngio.com/user-icons-free-download-png-and-svg-user-png-200_200.png");

        User u2 = new User();
        u2.setName("Chambal");
        u2.setJob("Techie");
        u2.setImage("https://img.pngio.com/user-icons-free-download-png-and-svg-user-png-200_200.png");

        User u3 = new User();
        u3.setName("Saloni");
        u3.setJob("Techie");
        u3.setImage("https://img.pngio.com/user-icons-free-download-png-and-svg-user-png-200_200.png");

        User u4 = new User();
        u4.setName("Vibhor");
        u4.setJob("Techie");
        u4.setImage("https://img.pngio.com/user-icons-free-download-png-and-svg-user-png-200_200.png");

        User u5 = new User();
        u5.setName("Dhara");
        u5.setJob("Techie");
        u5.setImage("https://img.pngio.com/user-icons-free-download-png-and-svg-user-png-200_200.png");

        User u6 = new User();
        u6.setName("Dalda");
        u6.setJob("Techie");
        u6.setImage("https://img.pngio.com/user-icons-free-download-png-and-svg-user-png-200_200.png");

        User u7 = new User();
        u7.setName("Rath");
        u7.setJob("Techie");
        u7.setImage("https://img.pngio.com/user-icons-free-download-png-and-svg-user-png-200_200.png");

        User u8 = new User();
        u8.setName("Nature");
        u8.setJob("Techie");
        u8.setImage("https://img.pngio.com/user-icons-free-download-png-and-svg-user-png-200_200.png");

        User u9 = new User();
        u9.setName("Gemini");
        u9.setJob("Techie");
        u9.setImage("https://img.pngio.com/user-icons-free-download-png-and-svg-user-png-200_200.png");

        User u10 = new User();
        u10.setName("Mahakosh");
        u10.setJob("Techie");
        u10.setImage("https://img.pngio.com/user-icons-free-download-png-and-svg-user-png-200_200.png");

        User u11 = new User();
        u11.setName("Saffola");
        u11.setJob("Techie");
        u11.setImage("https://img.pngio.com/user-icons-free-download-png-and-svg-user-png-200_200.png");

        User u12 = new User();
        u12.setName("Om");
        u12.setJob("Techie");
        u12.setImage("https://img.pngio.com/user-icons-free-download-png-and-svg-user-png-200_200.png");


        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);
        userList.add(u5);
        userList.add(u6);
        userList.add(u7);
        userList.add(u8);
        userList.add(u9);
        userList.add(u10);
        userList.add(u11);
        userList.add(u12);


    }

//    private ArrayList<Model> getMyList()
//    {
//        ArrayList<Model> models=new ArrayList<>();
//        Model m=new Model();
//        m.setTitle("News Feed");
//        m.setDescription("This is news Description");
//        m.setImg(R.drawable.arvaria);
//        models.add(m);
//        return models;
//    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);



    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.ab,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.profile) {
            Intent it = new Intent(getActivity(), Pictures.class);
            startActivity(it);

        }
        return super.onOptionsItemSelected(item);
    }
   }
