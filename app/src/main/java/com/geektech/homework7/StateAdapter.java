package com.geektech.homework7;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder> {

    private Context context;

    private final LayoutInflater inflater;
    private final List<State> states;
    private String selectedColor = "";


    StateAdapter(Context context, List<State> states) {
        this.states = states;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public StateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StateAdapter.ViewHolder holder, int position) {
        State state = states.get(position);
        holder.flagView.setImageDrawable(state.getFlagResource());
        holder.nameView.setText(state.getName());
        holder.capitalView.setText(state.getCapital());

        holder.itemView.setOnClickListener(v -> {
            String[] list = {"Синиий", "Черный", "Желтый", "Красный"};
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Выбери цвет");
            builder.setSingleChoiceItems(list, 0, (dialog, which) -> {
                selectedColor = list[which];
            }).setPositiveButton("Ок", (dialog, which) -> {
                if (selectedColor.equals("Синиий")) {
                    holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.purple_700));
                } else if (selectedColor.equals("Черный")) {
                    holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.black));
                } else if (selectedColor.equals("Желтый")) {
                    holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.purple_200));
                } else if (selectedColor.equals("Красный")) {
                    holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.teal_200));
                }
                dialog.dismiss();
            }).show();
        });

        holder.itemView.setOnLongClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle("Вы точно хотите удалить?").setNegativeButton("Нет", (dialog, which) -> dialog.cancel())
                    .setPositiveButton("Да", (dialog, which) -> {
                        states.remove(position);
                        notifyDataSetChanged();
                    })
                    .create()
                    .show();
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flagView;
        final TextView nameView, capitalView;

        ViewHolder(View view) {
            super(view);
            flagView = view.findViewById(R.id.flag);
            nameView = view.findViewById(R.id.name);
            capitalView = view.findViewById(R.id.capital);
        }
    }
}
