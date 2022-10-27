package com.test.testtask;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.test.testtask.databinding.ActivityMainBinding;
import com.test.testtask.server.ListUsers;
import com.test.testtask.server.Reponse;
import com.test.testtask.server.RetrofitApi;
import com.test.testtask.server.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private List<ListUsers> listUsers;
    private String mUid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.test.testtask.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RetrofitApi apiService =
                RetrofitClient.getClient().create(RetrofitApi.class);
       /* TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);

        @SuppressLint({"MissingPermission", "HardwareIds"})
        Call<List<ListUsers>> callListUsers = apiService.getListUsers(telephonyManager.getDeviceId());*/
        int IMEI = 111111111;
        Call<List<ListUsers>> callListUsers = apiService.getListUsers(IMEI);
        callListUsers.enqueue(new Callback<List<ListUsers>>() {
            @Override
            public void onResponse(Call<List<ListUsers>> call, Response<List<ListUsers>> response) {
                listUsers = response.body();
            }
            @Override
            public void onFailure(Call<List<ListUsers>> call, Throwable t) {
            }
        });
        String[] strSpinner;
        int n = 0;
        String[][] arrays;
        int user = 0;
        int uid = 0;
        if(listUsers !=null){
            strSpinner = new String[listUsers.size()];
            arrays = new String[listUsers.size()][2];
            for (ListUsers listUsrs: listUsers) {
                arrays[n][user] = String.valueOf(listUsrs.getUser());
                arrays[n][uid] = listUsrs.getUid();
                strSpinner[n] = listUsrs.getUser();
                n++;
            }
        }else {
            List<ListUsers> lUr = new ArrayList<>();
            lUr.add(0,new ListUsers("РђРґРјРёРЅРёСЃС‚СЂР°С‚РѕСЂ","e484605b-25cf-11ec-ab51-000c29601d6b",""));
            lUr.add(0,new ListUsers("РљР»Р°РґРѕРІС‰РёРє (РћСЃРЅРѕРІРЅРѕР№ СЃРєР»Р°Рґ, Р°РґСЂРµСЃРЅС‹Р№)","fa1cb834-d744-11ec-ab52-000c29601d6b",""));
            lUr.add(0,new ListUsers("РљР»Р°РґРѕРІС‰РёРє (РЎРєР»Р°Рґ РјРµР±РµР»Рё, РѕСЂРґРµСЂРЅС‹Р№)","РљР»Р°РґРѕРІС‰РёРє (РЎРєР»Р°Рґ РјРµР±РµР»Рё, РѕСЂРґРµСЂРЅС‹Р№)",""));
            lUr.add(0,new ListUsers("РљР»Р°РґРѕРІС‰РёРє (РЎРєР»Р°Рґ РјР°С‚РµСЂРёР°Р»РѕРІ)","РљР»Р°РґРѕРІС‰РёРє (РЎРєР»Р°Рґ РјР°С‚РµСЂРёР°Р»РѕРІ)",""));
            lUr.add(0,new ListUsers("Dev","a1404b22-d821-11ec-ab52-000c29601d6b",""));
            strSpinner = new String[lUr.size()];
            arrays = new String[lUr.size()][2];
            for (ListUsers listUsrs: lUr) {   
                arrays[n][user] = String.valueOf(listUsrs.getUser());
                arrays[n][uid] = listUsrs.getUid();
                strSpinner[n] = listUsrs.getUser();
                n++;
            }
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_layout_view, strSpinner);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_layout_items);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);
        TextView enter = binding.enter;
        TextView pass = binding.pass;
        enter.setOnClickListener(this);
        if(pass.getText()!=null){
            enter.setOnClickListener(v -> {
                Call<List<Reponse>> listReponse = apiService.getReponse(IMEI,pass.getText().toString(),mUid,false,"");
                listReponse.enqueue(new Callback<List<Reponse>>() {
                    @Override
                    public void onResponse(Call<List<Reponse>> call, Response<List<Reponse>> response) {
                        Intent intent  = new Intent(MainActivity.this, ListUsersActivity.class);
                        intent.putExtra("Reponse", (Parcelable) response.body());
                        startActivity(intent);
                    }
                    @Override
                    public void onFailure(Call<List<Reponse>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
                    }
                });

            });
        }

        String[][] finalArrays = arrays;
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                mUid = finalArrays[position][uid];
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}