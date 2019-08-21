package com.example.americano;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super .onCreate(bundle);
        setContentView(R.layout.activity_favorite);
        Intent intent = getIntent();

        /*
        // List View
        String[] items = {"스타벅스 홍대점", "엔젤 인 어스 합정점", "롯데백화점 판교"};
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                        String item = String.valueOf(parent.getItemAtPosition(i));
                        Toast.makeText(FavoriteActivity.this, item, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), StoreActivity.class);
                        startActivity(intent);
                    }
                }
        );
        */

        listView = (ListView)this.findViewById(R.id.listView);

        ArrayList<String> items = new ArrayList<>();
        items.add("스타벅스 홍대점");
        items.add("엔젤 인 어스 합정점");
        items.add("롯데백화점 판교점");

        CustomAdapter adapter = new CustomAdapter(this, 0, items);
        listView.setAdapter(adapter);

    }

    private class CustomAdapter extends ArrayAdapter<String> {
        private ArrayList<String> items;

        public CustomAdapter(Context context, int textViewResourceId, ArrayList<String> objects) {
            super(context, textViewResourceId, objects);
            this.items = objects;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.listview_item, null);
            }

            ImageView imageView = (ImageView)v.findViewById(R.id.imageView);

            //리스트뷰의 item에 이미지를 변경한다.
            if("스타벅스 홍대점".equals(items.get(position)))
                imageView.setImageResource(R.drawable.starbucks);
            else if("엔젤 인 어스 합정점".equals(items.get(position)))
                imageView.setImageResource(R.drawable.angelinus);
            else if("롯데백화점 판교점".equals(items.get(position)))
                imageView.setImageResource(R.drawable.lottedepartment);

            TextView textView = (TextView)v.findViewById(R.id.textView);
            textView.setText(items.get(position));

            final String text = items.get(position);
            Button button = (Button)v.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(FavoriteActivity.this, text+"이 제거되었습니다.", Toast.LENGTH_SHORT).show();
                }
            });

            v.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), StoreActivity.class);
                    startActivity(intent);
                }
            });

            return v;
        }
    }



}
