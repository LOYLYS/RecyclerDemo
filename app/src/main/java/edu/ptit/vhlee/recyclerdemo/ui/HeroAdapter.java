package edu.ptit.vhlee.recyclerdemo.ui;

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
    private ItemClickListener mListener;

    public HeroAdapter(List<Hero> heroes, ItemClickListener listener) {
        mHeroes = heroes;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        mInflater = LayoutInflater.from(parent.getContext());
        View view = mInflater.inflate(R.layout.item_hero, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(mListener, mHeroes.get(position), position);
    }

    @Override
    public int getItemCount() {
        return (mHeroes != null) ? mHeroes.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        private ImageView mAvatar;
        private ImageView mFavorite;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.text_name);
            mAvatar = itemView.findViewById(R.id.image_avatar);
            mFavorite = itemView.findViewById(R.id.image_favorite);
        }

        public void bindData(final ItemClickListener itemClickListener, Hero hero, final int position) {
            mName.setText(hero.getName());
            mAvatar.setImageResource(hero.getAvatar());
            if (hero.isFavorite()) mFavorite.setImageResource(R.drawable.ic_liked);
            else mFavorite.setImageResource(R.drawable.ic_unlike);
            mAvatar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.onAvatarClick(position);
                }
            });
            mFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.onFavoriteClick(position);
                }
            });
        }

    }

    interface ItemClickListener {
        void onFavoriteClick(int position);

        void onAvatarClick(int position);
    }
}
