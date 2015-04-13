package com.labas.bozidar.foi.codebox.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.labas.bozidar.foi.codebox.R;
import com.labas.bozidar.foi.codebox.mvp.models.User;

import java.util.Collections;
import java.util.List;

/**
 * Created by bozidar on 12.04.15..
 */
public class TopPlayersAdapter extends RecyclerView.Adapter<TopPlayersAdapter.PlayerViewHolder>{

    private LayoutInflater inflater;
    List<User> data = Collections.emptyList();


    public TopPlayersAdapter(Context context, List<User> data){
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public PlayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.players_row, parent, false);
        PlayerViewHolder holder = new PlayerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PlayerViewHolder holder, int position) {
        User user = data.get(position);
        holder.username.setText("player: " + user.getUsername());
        holder.score.setText("score: " + user.getScore());
        holder.rank.setText((position + 1) + "");

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PlayerViewHolder extends RecyclerView.ViewHolder{
        TextView username;
        TextView score;
        TextView rank;

        public PlayerViewHolder(View itemView) {
            super(itemView);
            username = (TextView) itemView.findViewById(R.id.tvUsername);
            score = (TextView) itemView.findViewById(R.id.tvScore);
            rank = (TextView) itemView.findViewById(R.id.tvRank);
        }
    }
}