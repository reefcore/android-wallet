package com.wallet.reefcoin.Adapter;
/**
 * all required libraries imported here
 */
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wallet.reefcoin.R;


/**
 * Created by ibrahim on 4/10/17.
 */

public class ReceiveandSendAdapter extends RecyclerView.Adapter<ReceiveandSendAdapter.GenericViewHolder> {
    /**
     * Field instance of transaction context and type for receive and send
     */
    Activity context;
    int type = -1;

    /**
     * constructor for getting the current context and type
     * @param context
     * @param type
     */
    public ReceiveandSendAdapter(Activity context, int type) {
        this.context = context;
        this.type = type;
    }

    /**
     * creating each item of reycler view
     * @param viewGroup
     * @param viewType
     * @return
     */

    @Override
    public GenericViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        /**
         * inflating the each item of recycler view with this defined layout of row
         */
        View itemview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_row_, viewGroup, false);
        /**
         * returning the each row
         */
        return new GenericViewHolder(itemview);
    }

    /**
     * this method will called when the view holder will bind to each item created
     * @param holder
     * @param position
     */

    @Override
    public void onBindViewHolder(GenericViewHolder holder, int position) {
        /**
         * if type is 0 then this will be received
         * else then this will be sent
         */
        if (type == 0) {
            /**
             * setting the title to #payment received and change the icon to receive
             */
            holder.tv_title.setText("Payment Received");
            holder.row_icon.setImageResource(R.drawable.receive);
        } else {
            /**
             * setting the title to #payment sent and change the icon to sent
             */
            holder.tv_title.setText("Payment Sent");
            holder.row_icon.setImageResource(R.drawable.sends);
        }
    }

    /**
     * returning total item counts measuring the array list size
     * @return
     */
    @Override
    public int getItemCount() {
        return 10;
    }

    /**
     * view holder for defining the views and holding up
     */

    public static class GenericViewHolder extends RecyclerView.ViewHolder {
        /**
         * field instances of all views of the row
         */
        TextView tv_title;
        ImageView row_icon;

        public GenericViewHolder(View itemView) {
            super(itemView);
            /**
             * type casting all views
             */
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            row_icon = (ImageView) itemView.findViewById(R.id.row_icon);
        }

    }
}
