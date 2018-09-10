package edu.ptit.vhlee.recyclerdemo.ui;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import edu.ptit.vhlee.recyclerdemo.R;
import edu.ptit.vhlee.recyclerdemo.data.model.Hero;

public class MainActivity extends AppCompatActivity implements HeroAdapter.ItemClickListener {
    public static final int TOTAL_HERO = 10;
    private ArrayList<Hero> mHeroes;
    private HeroAdapter mAdapter;

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
        mAdapter = new HeroAdapter(mHeroes, this);
        recycler.setAdapter(mAdapter);
    }

    @Override
    public void onFavoriteClick(int position) {
        Hero hero = mHeroes.get(position);
        if (hero.isFavorite()) hero.setFavorite(false);
        else hero.setFavorite(true);
        mAdapter.notifyItemChanged(position);
    }

    @Override
    public void onAvatarClick(int position) {
        Hero hero = mHeroes.get(position);
        CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinator_main);
        Snackbar.make(coordinatorLayout, hero.getName(), Snackbar.LENGTH_LONG).show();
    }
}
