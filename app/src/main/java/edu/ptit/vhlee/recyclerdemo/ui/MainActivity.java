package edu.ptit.vhlee.recyclerdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import edu.ptit.vhlee.recyclerdemo.R;
import edu.ptit.vhlee.recyclerdemo.data.model.Hero;

public class MainActivity extends AppCompatActivity {
    public static final int TOTAL_HERO = 10;
    private ArrayList<Hero> mHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initRecycler();
    }

    private void initData() {
        mHeroes = new ArrayList<>();
        for (int i = 0; i < TOTAL_HERO; i++) {
            Hero hero = new Hero(getString(R.string.default_hero_name), R.drawable.default_avatar);
            mHeroes.add(hero);
        }
    }

    private void initRecycler() {
        RecyclerView recycler = findViewById(R.id.recycler_movies);
        HeroAdapter adapter = new HeroAdapter(this, mHeroes);
        recycler.setAdapter(adapter);
    }
}
