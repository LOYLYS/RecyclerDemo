package edu.ptit.vhlee.recyclerdemo.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.ptit.vhlee.recyclerdemo.R;
import edu.ptit.vhlee.recyclerdemo.data.model.Hero;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {
    private List<Hero> mHeroes;
    private LayoutInflater mInflater;

    public HeroAdapter(Context context, List<Hero> heroes) {
        mHeroes = heroes;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = mInflater.inflate(R.layout.item_hero, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(mHeroes.get(position));
    }

    @Override
    public int getItemCount() {
        return (mHeroes != null) ? mHeroes.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mAvatar;
        private TextView mName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.text_name);
            mAvatar = itemView.findViewById(R.id.image_avatar);
        }

        public void bindData(Hero hero) {
            mName.setText(hero.getName());
            mAvatar.setImageResource(hero.getAvatar());
        }
    }
}
