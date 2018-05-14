package teamonethursday.map_application;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by User on 14/05/2018.
 */

public class customListView extends ArrayAdapter<String> {

private String[] fruitname;
private String[] desc;
private Integer[] imgid;
private Activity context;
    public customListView(Activity context,String[] fruitname,String[] desc,Integer[] imgid ) {
        super(context, R.layout.listview_layout,fruitname);

        this.context=context;
        this.fruitname=fruitname;
        this.desc=desc;
        this.imgid=imgid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null)
        {
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview_layout,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else
        {
            viewHolder= (ViewHolder) r.getTag();
        }
        viewHolder.ivw.setImageResource(imgid[position]);
        viewHolder.tvw2.setText(fruitname[position]);
        viewHolder.tvw1.setText(desc[position]);

        return r;

    }
    class ViewHolder
    {
        TextView tvw1;
        TextView tvw2;
        ImageView ivw;
        ViewHolder(View v)
        {
            tvw1= (TextView) v.findViewById(R.id.tvfruitname);
            tvw2 = (TextView) v.findViewById(R.id.tvdescription);
            ivw= (ImageView) v.findViewById(R.id.imageView);
        }

    }
}
