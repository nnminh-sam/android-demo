package nnminh.playground.gridviewadvance;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridAdapter extends BaseAdapter {
    private final Context context;
    private final List<Item> itemList;

    private final int layoutId;

    public GridAdapter(Context context, List<Item> itemList, int layoutId) {
        this.context = context;
        this.itemList = itemList;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(this.layoutId, viewGroup, false);
        }

        ImageView imgBackground = view.findViewById(R.id.imgBackground);
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtPrice = view.findViewById(R.id.txtPrice);
        TextView txtDiscount = view.findViewById(R.id.txtDiscount);

        Item item = itemList.get(i);

        imgBackground.setImageResource(item.getImageResId());

        txtName.setText(item.getName());
        txtPrice.setText("$" + item.getPrice());

        if (item.getDiscount() != null && !item.getDiscount().isEmpty()) {
            txtDiscount.setText(item.getDiscount());
            txtDiscount.setVisibility(View.VISIBLE);
        } else {
            txtDiscount.setVisibility(View.GONE);
        }

        view.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailItemActivity.class);
            intent.putExtra("item", item);
            context.startActivity(intent);
        });

        return view;
    }
}
