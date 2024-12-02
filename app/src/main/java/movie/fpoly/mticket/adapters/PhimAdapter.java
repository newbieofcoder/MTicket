package movie.fpoly.mticket.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import movie.fpoly.mticket.R;
import movie.fpoly.mticket.models.Phim_example;

public class PhimAdapter extends RecyclerView.Adapter<PhimAdapter.PhimViewHolder> {
    private Context context;
    private List<Phim_example> listPhim;

    public interface OnItemClickListener {
        void onItemClick(Phim_example phim);
    }

    public PhimAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Phim_example> listPhim) {
        this.listPhim = listPhim;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhimViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.film_item_layout, null);
        return new PhimViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhimViewHolder phimViewHolder, int i) {
        Phim_example phim = listPhim.get(i);
        if (phim == null) {
            return;
        }
        phimViewHolder.imgFilm.setImageResource(phim.getImage());
        phimViewHolder.nameFilm.setText(phim.getTitle());
    }

    @Override
    public int getItemCount() {
        if (listPhim != null) {
            return listPhim.size();
        }
        return 0;
    }

    public class PhimViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFilm;
        private TextView nameFilm;

        public PhimViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFilm = itemView.findViewById(R.id.imgFilm);
            nameFilm = itemView.findViewById(R.id.nameFilm);
        }
    }
}
